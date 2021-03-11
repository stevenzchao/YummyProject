package com.pj.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj.bean.MenuBean;
import com.pj.dao.MenuDaolmpl;

@WebServlet("/ShowAllMenu")
public class ShowAllMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�إ߶��X,�M��getAlltraining����k�����System.out.println(companyId);
		MenuDaolmpl Menu =new MenuDaolmpl();
		int companyId = Integer.parseInt(request.getParameter("companyId"));
		List<MenuBean> allMenu = Menu.getAllMenu(companyId);
		//�N���o����ƥ]�˰_�Ӷǵ�All.jsp�B�z
		request.setAttribute("allMenu",allMenu);
		request.getRequestDispatcher("frontend/Menu.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
