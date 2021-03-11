package com.pj.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.sql.DataSource;

import com.pj.bean.RestaurantBean;
import com.pj.daoimpl.Restaurantdaoimpl;

@WebServlet("/RestaurantController")
@MultipartConfig
public class RestaurantController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");// 以UTF-8來發送請求
		response.setCharacterEncoding("UTF-8");
		Enumeration<String> names = request.getParameterNames();
		HttpSession session = request.getSession();

//		判斷client端是否有傳來參數

		if (names.hasMoreElements()) {
//			列出第一筆參數類型 指定給reqtype
			String reqtype = names.nextElement();
//			開始判斷類型是哪一種
			if (reqtype.equals("readRAll")) {
				System.out.println("ok! reqtype is " + reqtype);
				List<RestaurantBean> RAll = new Restaurantdaoimpl().readAll();
//				System.out.println("controller="+RestAll);//確定controller有吃到
				request.setAttribute("RAll", RAll);// 交給JSP
				request.getRequestDispatcher("/frontend/readRAll.jsp").forward(request, response);
			}

			else if (reqtype.equals("companyID")) {
				System.out.println("ok! reqtype is " + reqtype);
				int cID = Integer.parseInt(request.getParameter("companyID"));
				// 用戶登入將ID設進session
				session.setAttribute("cID", cID);

				List<RestaurantBean> RAll = new Restaurantdaoimpl().readAllbyCID(cID);
//				System.out.println("controller="+RestAll);//確定controller有吃到
				request.setAttribute("RAll", RAll);// 交給JSP
				request.getRequestDispatcher("/frontend/readRAll.jsp").forward(request, response);
			} else if (reqtype.equals("newRName")) {
				request.setCharacterEncoding("UTF-8");// 以UTF-8來發送請求
				response.setCharacterEncoding("UTF-8");
				System.out.println("ok! reqtype is " + reqtype);

				// 取得client端輸入值 並指派變數方便傳入DAO
				String RName = request.getParameter("newRName");
				String RAddress = request.getParameter("newRAddress");
				String RLong = request.getParameter("newRLong");
				String RLati = request.getParameter("newRLati");
				String RHashtag = request.getParameter("newRHashtag");
				String RContact = request.getParameter("newRContact");
				String RWebsite = request.getParameter("newRWebsite");
//				餐廳"照片"的部分用getPart接client端傳來的檔案(照片)
				Part part = request.getPart("newRPhoto");
//				將此part檔案轉成byte[]以便丟入DAO裡
				InputStream is = part.getInputStream();
				byte[] RPhoto = new byte[is.available()];
				is.read(RPhoto, 0, RPhoto.length);

				String companyID = request.getParameter("newcompanyID");

//				將資料丟給DAO 新增進資料庫
				new Restaurantdaoimpl().newR(RName, RAddress, RLong, RLati, RHashtag, RContact, RWebsite, RPhoto,
						companyID);
//				新增完呼叫readAll給client

				try {
					int idcheck = (int) session.getAttribute("cID");
					System.out.print("目前身分ID為" + idcheck);
					List<RestaurantBean> RAll = new Restaurantdaoimpl().readAllbyCID(idcheck);
//					System.out.println("controller="+RestAll);//確定controller有吃到
					request.setAttribute("RAll", RAll);// 交給JSP
					request.getRequestDispatcher("/frontend/readRAll.jsp").forward(request, response);
				} catch (NullPointerException e) {
					System.out.print("目前身分ID為未指定");
					List<RestaurantBean> RAll = new Restaurantdaoimpl().readAll();
					request.setAttribute("RAll", RAll);// 交給JSP
					request.getRequestDispatcher("/frontend/readRAll.jsp").forward(request, response);
				} 
				

			}
			// 沒用到
			else if (reqtype.equals("readRID")) {
				System.out.println("ok! reqtype is " + reqtype);
				// 取得client端輸入值 並指派變數方便傳入DAO
				String RID = request.getParameter("readRID");
//				將資料丟給DAO 取回一個Bean 將此Bean set進request裡面
				RestaurantBean readRBean = new Restaurantdaoimpl().readR(RID);
				System.out.println("controller=" + readRBean);// 確定controller有吃到
				request.setAttribute("readRBean", readRBean);
				request.getRequestDispatcher("/frontend/readR.jsp").forward(request, response);
			}
//			--------更新----------
			else if (reqtype.equals("readupdateRID")) {
				System.out.println("ok! reqtype is " + reqtype);
				String RUID = request.getParameter("readupdateRID");
//				將欲更改的餐廳ID丟給查詢DAO 使之傳回一個Bean
				RestaurantBean readRBean = new Restaurantdaoimpl().readR(RUID);
				request.setAttribute("readRBean", readRBean);
				request.getRequestDispatcher("/frontend/updateR.jsp").forward(request, response);
			} else if (reqtype.equals("updateRID")) {
				System.out.println("ok! reqtype is " + reqtype);
				// 取得client端輸入值 並指派變數方便傳入DAO
				String RID = request.getParameter("updateRID");
				String RName = request.getParameter("updateRName");
				String RAddress = request.getParameter("updateRAddress");
				String RLong = request.getParameter("updateRLong");
				String RLati = request.getParameter("updateRLati");
				String RHashtag = request.getParameter("updateRHashtag");
				String RContact = request.getParameter("updateRContact");
				String RWebsite = request.getParameter("updateRWebsite");
//				餐廳"照片"的部分用getPart接client端傳來的檔案(照片)
				Part part = request.getPart("updateRPhoto");
//				將此part檔案轉成byte[]以便丟入DAO裡
				InputStream is = part.getInputStream();
				byte[] RPhoto = new byte[is.available()];
				is.read(RPhoto, 0, RPhoto.length);
//				將資料丟給updateDAO 使之更新資料庫 
				new Restaurantdaoimpl().updateR(RID, RName, RAddress, RLong, RLati, RHashtag, RContact, RWebsite,
						RPhoto);
//				更新完呼叫readAll給client 判斷身分 若身分為未指定 列出所有 若session有身分 及列出該身分的餐廳
				try {
					int idcheck = (int) session.getAttribute("cID");
					System.out.print("目前身分ID為" + idcheck);
					List<RestaurantBean> RAll = new Restaurantdaoimpl().readAllbyCID(idcheck);
//					System.out.println("controller="+RestAll);//確定controller有吃到
					request.setAttribute("RAll", RAll);// 交給JSP
					request.getRequestDispatcher("/frontend/readRAll.jsp").forward(request, response);
				} catch (NullPointerException e) {
					System.out.print("目前身分ID為未指定");
					List<RestaurantBean> RAll = new Restaurantdaoimpl().readAll();
					request.setAttribute("RAll", RAll);// 交給JSP
					request.getRequestDispatcher("/frontend/readRAll.jsp").forward(request, response);
				} 
			}

			else if (reqtype.equals("deleteRID")) {
				System.out.println("ok! reqtype is " + reqtype);
				// 取得client端輸入值 並指派變數方便傳入DAO
				String RID = request.getParameter("deleteRID");
//				將資料丟給deleteDAO 資料庫刪除 並return一個int 更新刪除筆數
				int updatecount = new Restaurantdaoimpl().deleteEmp(RID);
				System.out.print("已刪除" + updatecount + "筆資料");
				try {
					int idcheck = (int) session.getAttribute("cID");
					System.out.print("目前身分ID為" + idcheck);
					List<RestaurantBean> RAll = new Restaurantdaoimpl().readAllbyCID(idcheck);
//					System.out.println("controller="+RestAll);//確定controller有吃到
					request.setAttribute("RAll", RAll);// 交給JSP
					request.getRequestDispatcher("/frontend/readRAll.jsp").forward(request, response);
				} catch (NullPointerException e) {
					System.out.print("目前身分ID為未指定");
					List<RestaurantBean> RAll = new Restaurantdaoimpl().readAll();
					request.setAttribute("RAll", RAll);// 交給JSP
					request.getRequestDispatcher("/frontend/readRAll.jsp").forward(request, response);
				} 
			}
			// 關鍵字查詢用
			else if (reqtype.equals("Rkeyword")) {
				System.out.println("ok! reqtype is " + reqtype);
				// 取得client端輸入值 並指派變數方便傳入DAO
				String keyword = request.getParameter("Rkeyword");
				
				try {
					int idcheck = (int) session.getAttribute("cID");
					System.out.print("目前身分ID為" + idcheck);
					List<RestaurantBean> RAll = new Restaurantdaoimpl().RkeywordbyCID(idcheck,keyword);
//					System.out.println("controller="+RestAll);//確定controller有吃到
					request.setAttribute("RAll", RAll);// 交給JSP
					request.getRequestDispatcher("/frontend/readRAll.jsp").forward(request, response);
				} catch (NullPointerException e) {
					System.out.print("目前身分ID為未指定");
					List<RestaurantBean> RAll = new Restaurantdaoimpl().Rkeyword(keyword);
					request.setAttribute("RAll", RAll);// 交給JSP
					request.getRequestDispatcher("/frontend/readRAll.jsp").forward(request, response);
				} 
				

			}
			// 將DB的圖片write進response丟給發出request端
			else if (reqtype.equals("RIDforimg")) {
//				取得request的值(也就是餐廳代號)
				String RIDforimg = request.getParameter("RIDforimg");
				RestaurantBean RIDtoPhotoBean = new Restaurantdaoimpl().RIDtoPhoto(RIDforimg);
				byte[] img = null;
				response.setContentType("image/*");
				InputStream targetStream = new ByteArrayInputStream(RIDtoPhotoBean.getRestaurantPhoto());
			    ServletOutputStream writer = response.getOutputStream();
		    	BufferedInputStream bis = new BufferedInputStream(targetStream);
		    	img = new byte[1024];
		    	int length;
				while ((length = bis.read(img)) != -1) {
					writer.write(img);
				}
				bis.close();
				writer.flush();
				writer.close();
//				將圖片(byte[])write給需求端
				response.getOutputStream().flush();
				response.getOutputStream().close();

			} else {

				System.out.println("there are some reqs but not correct");
				System.out.print("reqtype is " + reqtype);

			}
		} else {

			response.getWriter().print("client  GG");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
