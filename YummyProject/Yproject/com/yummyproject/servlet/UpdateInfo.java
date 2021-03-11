package com.yummyproject.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yummyproject.Bean.YummyBean;
import com.yummyproject.Dao.YummyDAOImpl;


@WebServlet("/UpdateInfo")
public class UpdateInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    request.setCharacterEncoding("UTF-8");
	    YummyBean yb = new YummyBean();
	    yb.setAccount(request.getParameter("account"));
	    yb.setRealName(request.getParameter("rname"));
	    yb.setNickName(request.getParameter("nname"));
	    yb.setPhoneNumber(request.getParameter("phone"));
	    yb.setBirthDay(request.getParameter("birthdat"));
	    yb.setDistrict(request.getParameter("dist"));
	    YummyDAOImpl dao = new YummyDAOImpl();
	    dao.updateFile(request.getParameter("account"), yb);
	    YummyBean ybupdate = dao.Find_one_User(request.getParameter("account"));
	    request.setAttribute("queryResult", ybupdate);	  
	    request.getRequestDispatcher("/com.yproject.jsp/edit.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
