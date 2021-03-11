package com.yummyproject.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummyproject.Bean.YummyBean;
import com.yummyproject.Dao.YummyDAOImpl;


@WebServlet("/PersonalPage")
public class PersonalPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    request.setCharacterEncoding("UTF-8");
	    YummyDAOImpl dao = new YummyDAOImpl();
	    YummyBean yb = new YummyBean();
	    yb.setAccount(request.getParameter("Account"));
	    yb.setPassword(request.getParameter("PWD"));
	    YummyBean ybean = dao.FindUser(yb);
	    request.setAttribute("queryResult", ybean);
	    request.getRequestDispatcher("/com.yproject.jsp/PersonalPage.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
