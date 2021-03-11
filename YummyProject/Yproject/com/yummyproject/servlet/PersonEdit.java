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


@WebServlet("/PersonEdit")
public class PersonEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    request.setCharacterEncoding("UTF-8");
	    YummyDAOImpl dao = new YummyDAOImpl();
	    YummyBean yb = new YummyBean();
	    yb.setAccount(request.getParameter("account"));
	    yb.setPassword(request.getParameter("password"));
	    yb = dao.FindUser(yb);
	    HttpSession session = request.getSession();
	    session.setAttribute("queryResult", yb);
	    //request.getRequestDispatcher("com.yproject.jsp/edit.jsp").forward(request, response);
	    response.sendRedirect("com.yproject.jsp/edit.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
