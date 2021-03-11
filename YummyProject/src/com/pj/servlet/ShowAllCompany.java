package com.pj.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj.bean.CompanyBean;
import com.pj.dao.CompanyDaolmpl;

@WebServlet("/ShowAllCompany")
public class ShowAllCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//建立集合,套用getAlltraining的方法找到資料
		CompanyDaolmpl Company =new CompanyDaolmpl();
		List<CompanyBean> allCompany = Company.getAllCompany();
		//將取得的資料包裝起來傳給All.jsp處理
		request.setAttribute("allCompany",allCompany);
		request.getRequestDispatcher("frontend/AllCompany.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
