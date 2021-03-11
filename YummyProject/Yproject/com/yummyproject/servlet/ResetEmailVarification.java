package com.yummyproject.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yummyproject.Bean.YummyBean;

import SendEmail.SendEmail;


@WebServlet("/ResetEmailVarification")
public class ResetEmailVarification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		YummyBean cus = (YummyBean) session.getAttribute("authcode");
		SendEmail sm = new SendEmail();
		String code = sm.getRandom();
		cus.setCode(code);
		boolean test = sm.sendEmail(cus);
		System.out.println(code);
		System.out.println(cus);
		if(test) {
			session.setAttribute("authcode", cus);
			response.sendRedirect("com.yproject.jsp/Verify.jsp");
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
