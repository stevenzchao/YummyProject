package com.pj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj.daoimpl.MapDAOimple;

/**
 * Servlet implementation class SingleStore
 */
@WebServlet("/SingleStore")
public class SingleStore extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String filename;
		if(request.getParameter("filename")!=null) {
			filename=request.getParameter("filename");
		}else if(request.getAttribute("filename")!=null) {
			filename=(String) request.getAttribute("filename");
		}else {
			
			filename="1";
		}
		int id =Integer.parseInt(filename);
		MapDAOimple cb=new MapDAOimple();
		String json=cb.singlejson(id);
		System.out.println(json);
		request.setAttribute("json",json);
		request.getRequestDispatcher("/frontend/Store.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
