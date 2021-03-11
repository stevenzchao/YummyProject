package com.pj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj.daoimpl.MapDAOimple;


@WebServlet("/KeyNameSearch")
public class KeyNameSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String kName=request.getParameter("kName");
		System.out.println(kName);
		MapDAOimple cb=new MapDAOimple();
		String json=cb.cityjson(kName);
		
		request.setAttribute("json",json);		
		request.getRequestDispatcher("/frontend/Maps.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
