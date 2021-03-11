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
		//�s�W�b���A���o��J��T(�ثe�u���]�w���n��T)
		request.setCharacterEncoding("UTF-8");
		String account =request.getParameter("account");
		String password =request.getParameter("password");
		String name =request.getParameter("name");
		String nickname =request.getParameter("nickname");
		String cellnum =request.getParameter("cell");
		
		//�������ҽX&�ǳƵo�e�H��
		SendEmail sm = new SendEmail();
		String code = sm.getRandom();

		//���� CustomerDAOImpl �s�W��k
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
		//�o�e�H��
		boolean test = sm.sendEmail(cus);
		if(test) {
			HttpSession session = request.getSession();
			session.setAttribute("authcode", cus);
			response.sendRedirect("com.yproject.jsp/Verify.jsp");
		}
		//�Ǩ즨�\�s�WJSP����
		//request.getRequestDispatcher("/FrontEnd/Verify.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
