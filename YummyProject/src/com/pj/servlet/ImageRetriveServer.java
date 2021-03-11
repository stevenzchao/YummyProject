package com.pj.servlet;

import java.io.BufferedInputStream;
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

@WebServlet("/ImageRetriveServer")
public class ImageRetriveServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filename;
		if(request.getParameter("filename")!=null) {
			filename=request.getParameter("filename");
		}else if(request.getAttribute("filename")!=null) {
			filename=(String) request.getAttribute("filename");
		}else {
			filename="1";
		}
		//download
		
		System.out.println(filename);
				try {
					Context context=new InitialContext();
					DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
					Connection conn=ds.getConnection();
				    PreparedStatement pstmt = conn.prepareStatement("Select Top 1 RestaurantPhoto From [PepperNoodles].[dbo].[restaurant] where RestaurantID = ?" );
				    pstmt.setString(1,filename);
				    ResultSet rs  = pstmt.executeQuery();
				    byte[] file=null;
				    response.setContentType("image/*");
				    ServletOutputStream writer = response.getOutputStream();
				    if(rs.next()){
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
					writer.flush();
					writer.close();
				}catch(NamingException e){
					e.printStackTrace();
				} 
				catch(SQLException e){
					e.printStackTrace();
				}			
			}
		
		


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
