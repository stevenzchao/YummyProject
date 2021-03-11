package com.pj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj.daoimpl.MapDAOimple;


@WebServlet("/CenterSearch")
public class CenterSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String location=request.getParameter("ctPositon");
		int l =location.indexOf("(");
		int r =location.indexOf(")");
		location=location.substring(l+1,r).trim();
//		location.trim();
		System.out.println(request.getParameter("ctPositon"));
		double lat = Double.parseDouble(location.split(",")[0]);
		double lng = Double.parseDouble(location.split(",")[1]);
		System.out.println(lat+"+"+lng);
		MapDAOimple cb=new MapDAOimple();
		String json=cb.centerSelect(lng, lat);		
		
		request.setAttribute("json",json);		
		request.getRequestDispatcher("/frontend/Maps.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
