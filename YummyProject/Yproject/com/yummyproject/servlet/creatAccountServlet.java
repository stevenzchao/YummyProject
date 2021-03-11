package com.yummyproject.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yummyproject.Bean.YummyBean;
import com.yummyproject.Dao.YummyDAOImpl;

import SendEmail.SendEmail;

@WebServlet("/creatAccountServlet")
public class creatAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//新增帳號，取得輸入資訊(目前只先設定必要資訊)
		request.setCharacterEncoding("UTF-8");
		String account =request.getParameter("account");
		String password =request.getParameter("password");
		String name =request.getParameter("name");
		String nickname =request.getParameter("nickname");
		String cellnum =request.getParameter("cell");
		
		//產生驗證碼&準備發送信件
		SendEmail sm = new SendEmail();
		String code = sm.getRandom();

		//取用 CustomerDAOImpl 新增方法
		YummyDAOImpl cd = new YummyDAOImpl();
		YummyBean cus = new YummyBean();
		cus.setAccount(account);
		cus.setPassword(password);
		cus.setRealName(name);
		cus.setNickName(nickname);
		cus.setPhoneNumber(cellnum);
		cus.setCode(code);
		System.out.println(cus.getCode());
		cd.addUser(cus);
		//發送信件
		boolean test = sm.sendEmail(cus);
		if(test) {
			HttpSession session = request.getSession();
			session.setAttribute("authcode", cus);
			response.sendRedirect("com.yproject.jsp/Verify.jsp");
		}
		//傳到成功新增JSP頁面
		//request.getRequestDispatcher("/FrontEnd/Verify.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
