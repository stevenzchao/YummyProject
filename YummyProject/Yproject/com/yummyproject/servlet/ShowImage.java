package com.yummyproject.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/ShowImage")
public class ShowImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acc=request.getParameter("imgaccount");
//		String acc = "youngCaptain@gamil.com";
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT top(1) [UserProtrait] FROM [PepperNoodles].[dbo].[AccountMember] WHERE [Account]=?");
			pstmt.setString(1, acc);
			ResultSet rs = pstmt.executeQuery();
			byte[] file = null;
			response.setContentType("image/*");
			ServletOutputStream writer = response.getOutputStream();
			if (rs.next()) {
				BufferedInputStream bis = new BufferedInputStream(rs.getBinaryStream(1));
				file = new byte[1024];
				int length;
				while ((length = bis.read(file)) != -1) {
					writer.write(file);
				}
				bis.close();
			}
			rs.close();
			pstmt.close();
			conn.close();
			// 當要跳出視窗給User下載時才用以下敘述
			// response.addHeader("Content-Disposition ","attachment; filename=one.jpg");
			writer.flush();
			writer.close();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
