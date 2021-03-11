package com.pj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pj.bean.MenuBean;
import com.pj.dao.MenuDaolmpl;

@WebServlet("/GetUpdateMenu")
public class GetUpdateMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MenuDaolmpl Menu = new MenuDaolmpl();
		//取得用戶端傳來的數字
		int seq = Integer.parseInt(request.getParameter("menu_seq"));
		
		HttpSession session=request.getSession();
		int sessionid = (int) session.getAttribute("id");
		System.out.println("更新中的企業ID:"+sessionid);
		
		//用數字呼叫selectMenuSeq取得單筆物件值
		MenuBean updateMenuSeq = Menu.selectMenuSeq(seq);
		//把取得的值包裝起來
		request.setAttribute("updateMenuSeq",updateMenuSeq);
		request.getRequestDispatcher("/frontend/UpdateMenu.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
