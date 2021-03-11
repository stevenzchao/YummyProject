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
		request.setCharacterEncoding("UTF-8"); //��X
		//�إߪ���
		MenuDaolmpl Menu = new MenuDaolmpl();
		MenuBean updateMenu=new MenuBean();
		//������o���ȡA�åΦr�걵��
		
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
		//�����r��˨쪫��
		updateMenu.setMenu_seq(Integer.parseInt(menu_seq));
		updateMenu.setName(name);
		updateMenu.setMenu_type(type);
		updateMenu.setImg(buffer);
		updateMenu.setPrice(Integer.valueOf(price));
		updateMenu.setBest_selling(best_selling);
		updateMenu.setRemark(remark);
		//�Ϊ���I�supdateMenu��k�s�J���
		Menu.updateMenu(updateMenu);
		System.out.println("ok");
		//
		HttpSession session=request.getSession();
		int sessionid = (int) session.getAttribute("id");
		System.out.println("��s�������~ID222222222:"+sessionid);
		System.out.println("==");
		MenuDaolmpl Menuall =new MenuDaolmpl();
		List<MenuBean> allMenu = Menuall.getAllMenu(sessionid);
		
		request.setAttribute("allMenu", allMenu);
		request.getRequestDispatcher("/frontend/Menu.jsp").forward(request, response);//���୶���^�h�ݥ������
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
