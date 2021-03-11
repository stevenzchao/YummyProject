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
		//�إ߶��X,�M��getAlltraining����k�����
		CompanyDaolmpl Company =new CompanyDaolmpl();
		List<CompanyBean> allCompany = Company.getAllCompany();
		//�N���o����ƥ]�˰_�Ӷǵ�All.jsp�B�z
		request.setAttribute("allCompany",allCompany);
		request.getRequestDispatcher("frontend/AllCompany.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
