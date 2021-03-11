package com.pj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.pj.bean.CompanyBean;
import com.pj.dao.CompanyDaolmpl;

@WebServlet("/CompanyLogIn")
public class CompanyLogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 轉碼
		// 建立物件
		CompanyDaolmpl company = new CompanyDaolmpl();
		CompanyBean companyLogIn=new CompanyBean();
		//取得用戶端輸入的值
		String companyMail =request.getParameter("companyMail");
		String companyPwd =request.getParameter("companyPwd");
		companyLogIn.setCompanyMail(companyMail);
		companyLogIn.setCompanyPwd(companyPwd);
		//設一個findCompany接傳回的Bean資料
		CompanyBean findCompany= company.logInCompany(companyLogIn);
		request.setAttribute("findCompany",findCompany);
		
		//設SESSIONID
		HttpSession sessionid = request.getSession();
		sessionid.setAttribute("id",findCompany.getCompanyID());
		
		
//		System.out.println("輸入值:"+companyMail);
//		System.out.println("輸入值:"+companyPwd);
//		System.out.println("---------傳回的BEAN-----------");
//		System.out.println("傳回值:"+findCompany.getCompanyMail());
//		System.out.println("傳回值:"+findCompany.getCompanyPwd());	
		
	  if (findCompany.getCompanyMail() == null) {
		   request.getRequestDispatcher("/frontend/CompanyLogIn_Erro.jsp").forward(request, response);
		  }
	  else {
		   request.getRequestDispatcher("/frontend/test.jsp").forward(request, response);
	  }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
