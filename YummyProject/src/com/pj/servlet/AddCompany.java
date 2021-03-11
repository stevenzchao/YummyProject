package com.pj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj.bean.CompanyBean;
import com.pj.dao.CompanyDaolmpl;

@WebServlet("/AddCompany")
public class AddCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //轉碼
		//建立物件
		CompanyDaolmpl Company = new CompanyDaolmpl();
		CompanyBean newCompany=new CompanyBean();
		//取得用戶端輸入的值
		String companyName=request.getParameter("ltdname");
		String mail=request.getParameter("mail");
		String pwd=request.getParameter("pwd");
		String contactPperson=request.getParameter("name");
		String phone=request.getParameter("phone");
		//將取到的值存入
		newCompany.setCompanyName(companyName);
		newCompany.setCompanyMail(mail);;
		newCompany.setCompanyPwd(pwd);;
		newCompany.setCompanyContactPperson(contactPperson);;
		newCompany.setCompanyPhone(phone);
		Company.addCompany(newCompany);
		
		request.setAttribute("Company",newCompany);
		request.getRequestDispatcher("/frontend/CompanyLogIn.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
