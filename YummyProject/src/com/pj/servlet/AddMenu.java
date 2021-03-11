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


@WebServlet("/AddMenu")
@MultipartConfig
public class AddMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 轉碼
		MenuDaolmpl Menu = new MenuDaolmpl();
		MenuBean addMenu = new MenuBean();

		// 取得用戶端輸入的值
		String company_id = request.getParameter("companyId");
		String name = request.getParameter("menu_name");
		String menu_type = request.getParameter("menu_type");
		//
		Part part = request.getPart("img");
		InputStream in= part.getInputStream();
		byte[] buffer = new byte[in.available()];
		in.read(buffer,0,buffer.length);
		in.close();
//		byte[] img =buffer;
//		System.out.println(img.length);
//		System.out.println("ok");

		String price = request.getParameter("price");
		String best_selling = request.getParameter("top");
		String remark = request.getParameter("remark");
		
//		System.out.println("取值:"+company_id);
//		System.out.println("取值:"+name);
//		System.out.println("取值:"+menu_type);
//		System.out.println("取值:"+price);
//		System.out.println("取值:"+remark);
		
		// 將取到的值存入
		addMenu.setCompany_id(Integer.parseInt(company_id));
		addMenu.setName(name);
		addMenu.setMenu_type(menu_type);
		addMenu.setImg(buffer);
		addMenu.setPrice(Integer.parseInt(price));
		addMenu.setBest_selling(best_selling);
		addMenu.setRemark(remark);
		
//		System.out.println("Company"+addMenu.getCompany_id());
//		System.out.println("Company"+addMenu.getName());
//		System.out.println("Company"+addMenu.getImg());
//		System.out.println("Company"+addMenu.getPrice());
//		System.out.println("Company"+addMenu.getMenu_type());
//		System.out.println("Company"+addMenu.getBest_selling());
//		System.out.println("Company"+addMenu.getRemark());
		
		System.out.println(addMenu.getName());
		Menu.addMenu(addMenu);
		
		HttpSession session=request.getSession();
		int sessionid = (int) session.getAttribute("id");
		System.out.println("更新中的企業ID222222222:"+sessionid);
		
		MenuDaolmpl Menuall =new MenuDaolmpl();
		List<MenuBean> allMenu = Menuall.getAllMenu(sessionid);
		request.setAttribute("allMenu", allMenu);
		
		request.getRequestDispatcher("/frontend/Menu.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
