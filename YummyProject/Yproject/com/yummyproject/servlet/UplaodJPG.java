package com.yummyproject.servlet;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.yummyproject.Bean.YummyBean;
import com.yummyproject.Dao.YummyDAOImpl;

@WebServlet("/UplaodJPG")
@MultipartConfig
public class UplaodJPG extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
		String account = request.getParameter("account");
		Part filePart = request.getPart("file");
		String filename = getSubmittedFileName(filePart);
		InputStream in = filePart.getInputStream();
		byte[] buffer = new byte[in.available()];
		in.read(buffer, 0, in.available());
		in.close();
		YummyBean yb = new YummyBean();
		yb.setAccount(account);
		yb.setProtraitName(filename);
		yb.setUserProtrait(buffer);
		YummyDAOImpl yImpl = new YummyDAOImpl();
		yImpl.uploadImg(yb);
		System.out.print("==");
		YummyBean ybupdate = yImpl.Find_one_User(account);
		HttpSession session = request.getSession();
		session.setAttribute("queryResult", ybupdate);
		response.sendRedirect("com.yproject.jsp/edit.jsp");
	}

	private String getSubmittedFileName(Part part) {
		String header = part.getHeader("Content-Disposition");
		int slashIndx = header.lastIndexOf("\\");
		String filename;
		if (slashIndx != -1) {
			filename = header.substring(slashIndx+1,header.length()-1);
		}else {
			int idx = header.indexOf("filename");
			filename = header.substring(idx+10,header.length()-1);
		}
		return filename;
	}//getSubmittedFileName

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
