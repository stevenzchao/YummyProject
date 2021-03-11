package com.pj.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.pj.bean.MenuBean;
import com.pj.dao.MenuDaolmpl;

@WebServlet("/UpdateMenu")
@MultipartConfig
public class UpdateMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //轉碼
		//建立物件
		MenuDaolmpl Menu = new MenuDaolmpl();
		MenuBean updateMenu=new MenuBean();
		//接住取得的值，並用字串接住
		
		String menu_seq = request.getParameter("menu_seq");
		String name = request.getParameter("menu_name");
		String type = request.getParameter("type");
		Part part = request.getPart("img");
		
		InputStream in= part.getInputStream();
		byte[] buffer = new byte[in.available()];
		in.read(buffer,0,buffer.length);
		in.close();
		String price = request.getParameter("price");
		String best_selling = request.getParameter("top");
		String remark = request.getParameter("remark");
		//接住的字串裝到物件內
		updateMenu.setMenu_seq(Integer.parseInt(menu_seq));
		updateMenu.setName(name);
		updateMenu.setMenu_type(type);
		updateMenu.setImg(buffer);
		updateMenu.setPrice(Integer.valueOf(price));
		updateMenu.setBest_selling(best_selling);
		updateMenu.setRemark(remark);
		//用物件呼叫updateMenu方法存入資料
		Menu.updateMenu(updateMenu);
		System.out.println("ok");
		//
		HttpSession session=request.getSession();
		int sessionid = (int) session.getAttribute("id");
		System.out.println("更新中的企業ID222222222:"+sessionid);
		System.out.println("==");
		MenuDaolmpl Menuall =new MenuDaolmpl();
		List<MenuBean> allMenu = Menuall.getAllMenu(sessionid);
		
		request.setAttribute("allMenu", allMenu);
		request.getRequestDispatcher("/frontend/Menu.jsp").forward(request, response);//跳轉頁面回去看全部資料
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
