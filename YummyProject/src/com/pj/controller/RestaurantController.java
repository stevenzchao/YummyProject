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
		request.setCharacterEncoding("UTF-8");// �HUTF-8�ӵo�e�ШD
		response.setCharacterEncoding("UTF-8");
		Enumeration<String> names = request.getParameterNames();
		HttpSession session = request.getSession();

//		�P�_client�ݬO�_���ǨӰѼ�

		if (names.hasMoreElements()) {
//			�C�X�Ĥ@���Ѽ����� ���w��reqtype
			String reqtype = names.nextElement();
//			�}�l�P�_�����O���@��
			if (reqtype.equals("readRAll")) {
				System.out.println("ok! reqtype is " + reqtype);
				List<RestaurantBean> RAll = new Restaurantdaoimpl().readAll();
//				System.out.println("controller="+RestAll);//�T�wcontroller���Y��
				request.setAttribute("RAll", RAll);// �浹JSP
				request.getRequestDispatcher("/frontend/readRAll.jsp").forward(request, response);
			}

			else if (reqtype.equals("companyID")) {
				System.out.println("ok! reqtype is " + reqtype);
				int cID = Integer.parseInt(request.getParameter("companyID"));
				// �Τ�n�J�NID�]�isession
				session.setAttribute("cID", cID);

				List<RestaurantBean> RAll = new Restaurantdaoimpl().readAllbyCID(cID);
//				System.out.println("controller="+RestAll);//�T�wcontroller���Y��
				request.setAttribute("RAll", RAll);// �浹JSP
				request.getRequestDispatcher("/frontend/readRAll.jsp").forward(request, response);
			} else if (reqtype.equals("newRName")) {
				request.setCharacterEncoding("UTF-8");// �HUTF-8�ӵo�e�ШD
				response.setCharacterEncoding("UTF-8");
				System.out.println("ok! reqtype is " + reqtype);

				// ���oclient�ݿ�J�� �ë����ܼƤ�K�ǤJDAO
				String RName = request.getParameter("newRName");
				String RAddress = request.getParameter("newRAddress");
				String RLong = request.getParameter("newRLong");
				String RLati = request.getParameter("newRLati");
				String RHashtag = request.getParameter("newRHashtag");
				String RContact = request.getParameter("newRContact");
				String RWebsite = request.getParameter("newRWebsite");
//				�\�U"�Ӥ�"��������getPart��client�ݶǨӪ��ɮ�(�Ӥ�)
				Part part = request.getPart("newRPhoto");
//				�N��part�ɮ��নbyte[]�H�K��JDAO��
				InputStream is = part.getInputStream();
				byte[] RPhoto = new byte[is.available()];
				is.read(RPhoto, 0, RPhoto.length);

				String companyID = request.getParameter("newcompanyID");

//				�N��ƥᵹDAO �s�W�i��Ʈw
				new Restaurantdaoimpl().newR(RName, RAddress, RLong, RLati, RHashtag, RContact, RWebsite, RPhoto,
						companyID);
//				�s�W���I�sreadAll��client

				try {
					int idcheck = (int) session.getAttribute("cID");
					System.out.print("�ثe����ID��" + idcheck);
					List<RestaurantBean> RAll = new Restaurantdaoimpl().readAllbyCID(idcheck);
//					System.out.println("controller="+RestAll);//�T�wcontroller���Y��
					request.setAttribute("RAll", RAll);// �浹JSP
					request.getRequestDispatcher("/frontend/readRAll.jsp").forward(request, response);
				} catch (NullPointerException e) {
					System.out.print("�ثe����ID�������w");
					List<RestaurantBean> RAll = new Restaurantdaoimpl().readAll();
					request.setAttribute("RAll", RAll);// �浹JSP
					request.getRequestDispatcher("/frontend/readRAll.jsp").forward(request, response);
				} 
				

			}
			// �S�Ψ�
			else if (reqtype.equals("readRID")) {
				System.out.println("ok! reqtype is " + reqtype);
				// ���oclient�ݿ�J�� �ë����ܼƤ�K�ǤJDAO
				String RID = request.getParameter("readRID");
//				�N��ƥᵹDAO ���^�@��Bean �N��Bean set�irequest�̭�
				RestaurantBean readRBean = new Restaurantdaoimpl().readR(RID);
				System.out.println("controller=" + readRBean);// �T�wcontroller���Y��
				request.setAttribute("readRBean", readRBean);
				request.getRequestDispatcher("/frontend/readR.jsp").forward(request, response);
			}
//			--------��s----------
			else if (reqtype.equals("readupdateRID")) {
				System.out.println("ok! reqtype is " + reqtype);
				String RUID = request.getParameter("readupdateRID");
//				�N����諸�\�UID�ᵹ�d��DAO �Ϥ��Ǧ^�@��Bean
				RestaurantBean readRBean = new Restaurantdaoimpl().readR(RUID);
				request.setAttribute("readRBean", readRBean);
				request.getRequestDispatcher("/frontend/updateR.jsp").forward(request, response);
			} else if (reqtype.equals("updateRID")) {
				System.out.println("ok! reqtype is " + reqtype);
				// ���oclient�ݿ�J�� �ë����ܼƤ�K�ǤJDAO
				String RID = request.getParameter("updateRID");
				String RName = request.getParameter("updateRName");
				String RAddress = request.getParameter("updateRAddress");
				String RLong = request.getParameter("updateRLong");
				String RLati = request.getParameter("updateRLati");
				String RHashtag = request.getParameter("updateRHashtag");
				String RContact = request.getParameter("updateRContact");
				String RWebsite = request.getParameter("updateRWebsite");
//				�\�U"�Ӥ�"��������getPart��client�ݶǨӪ��ɮ�(�Ӥ�)
				Part part = request.getPart("updateRPhoto");
//				�N��part�ɮ��নbyte[]�H�K��JDAO��
				InputStream is = part.getInputStream();
				byte[] RPhoto = new byte[is.available()];
				is.read(RPhoto, 0, RPhoto.length);
//				�N��ƥᵹupdateDAO �Ϥ���s��Ʈw 
				new Restaurantdaoimpl().updateR(RID, RName, RAddress, RLong, RLati, RHashtag, RContact, RWebsite,
						RPhoto);
//				��s���I�sreadAll��client �P�_���� �Y�����������w �C�X�Ҧ� �Ysession������ �ΦC�X�Ө������\�U
				try {
					int idcheck = (int) session.getAttribute("cID");
					System.out.print("�ثe����ID��" + idcheck);
					List<RestaurantBean> RAll = new Restaurantdaoimpl().readAllbyCID(idcheck);
//					System.out.println("controller="+RestAll);//�T�wcontroller���Y��
					request.setAttribute("RAll", RAll);// �浹JSP
					request.getRequestDispatcher("/frontend/readRAll.jsp").forward(request, response);
				} catch (NullPointerException e) {
					System.out.print("�ثe����ID�������w");
					List<RestaurantBean> RAll = new Restaurantdaoimpl().readAll();
					request.setAttribute("RAll", RAll);// �浹JSP
					request.getRequestDispatcher("/frontend/readRAll.jsp").forward(request, response);
				} 
			}

			else if (reqtype.equals("deleteRID")) {
				System.out.println("ok! reqtype is " + reqtype);
				// ���oclient�ݿ�J�� �ë����ܼƤ�K�ǤJDAO
				String RID = request.getParameter("deleteRID");
//				�N��ƥᵹdeleteDAO ��Ʈw�R�� ��return�@��int ��s�R������
				int updatecount = new Restaurantdaoimpl().deleteEmp(RID);
				System.out.print("�w�R��" + updatecount + "�����");
				try {
					int idcheck = (int) session.getAttribute("cID");
					System.out.print("�ثe����ID��" + idcheck);
					List<RestaurantBean> RAll = new Restaurantdaoimpl().readAllbyCID(idcheck);
//					System.out.println("controller="+RestAll);//�T�wcontroller���Y��
					request.setAttribute("RAll", RAll);// �浹JSP
					request.getRequestDispatcher("/frontend/readRAll.jsp").forward(request, response);
				} catch (NullPointerException e) {
					System.out.print("�ثe����ID�������w");
					List<RestaurantBean> RAll = new Restaurantdaoimpl().readAll();
					request.setAttribute("RAll", RAll);// �浹JSP
					request.getRequestDispatcher("/frontend/readRAll.jsp").forward(request, response);
				} 
			}
			// ����r�d�ߥ�
			else if (reqtype.equals("Rkeyword")) {
				System.out.println("ok! reqtype is " + reqtype);
				// ���oclient�ݿ�J�� �ë����ܼƤ�K�ǤJDAO
				String keyword = request.getParameter("Rkeyword");
				
				try {
					int idcheck = (int) session.getAttribute("cID");
					System.out.print("�ثe����ID��" + idcheck);
					List<RestaurantBean> RAll = new Restaurantdaoimpl().RkeywordbyCID(idcheck,keyword);
//					System.out.println("controller="+RestAll);//�T�wcontroller���Y��
					request.setAttribute("RAll", RAll);// �浹JSP
					request.getRequestDispatcher("/frontend/readRAll.jsp").forward(request, response);
				} catch (NullPointerException e) {
					System.out.print("�ثe����ID�������w");
					List<RestaurantBean> RAll = new Restaurantdaoimpl().Rkeyword(keyword);
					request.setAttribute("RAll", RAll);// �浹JSP
					request.getRequestDispatcher("/frontend/readRAll.jsp").forward(request, response);
				} 
				

			}
			// �NDB���Ϥ�write�iresponse�ᵹ�o�Xrequest��
			else if (reqtype.equals("RIDforimg")) {
//				���orequest����(�]�N�O�\�U�N��)
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
//				�N�Ϥ�(byte[])write���ݨD��
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
