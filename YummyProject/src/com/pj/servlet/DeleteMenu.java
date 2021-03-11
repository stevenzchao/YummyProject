package com.pj.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pj.bean.MenuBean;
import com.pj.dao.MenuDaolmpl;

@WebServlet("/DeleteMenu")
public class DeleteMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MenuDaolmpl Menu = new MenuDaolmpl();
		int seq = Integer.parseInt(request.getParameter("menu_seq"));
		Menu.deleteMenu(seq);
		
		HttpSession session=request.getSession();
		int sessionid = (int) session.getAttribute("id");
		MenuDaolmpl Menuall =new MenuDaolmpl();
		List<MenuBean> allMenu = Menuall.getAllMenu(sessionid);
		request.setAttribute("allMenu", allMenu);
		
		request.getRequestDispatcher("/frontend/Menu.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
