package com.pj.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class MapDAOimple {	
	
	public String singlejson(int id){
		String str="[";
		try {
			System.out.println("ok");
			
			String sqlselect="SELECT [RestaurantID],[RestaurantName],[RestaurantAddress],[RestaurantHashtag],[RestaurantContact],[RestaurantWebsite]"
					+ ",[companyID],[Longitude],[Latitude] FROM [PepperNoodles].[dbo].[restaurant] where RestaurantID = ?";
			Context context=new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn=ds.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sqlselect);
			pstmt.setInt(1, id);
     		ResultSet rs = pstmt.executeQuery();                         
     		
     		ResultSetMetaData rsmd = rs.getMetaData();
     		int columnCount = rsmd.getColumnCount();
     		boolean camma=false;
     		while (rs.next()) {
     		      // Represent a row in DB. Key: Column name, Value: Column value
     			if(camma==false) {
     				str+="{";
     			}else {
     				str+=",{";
     			}
     			
     		      for (int i = 1; i <= columnCount; i++) {
     		           if(i>1) {
     		        	  str+=",";
     		           }
     		           String colName = rsmd.getColumnName(i);
     		           String colVal = rs.getString(i);
     		          
     		           str+="\""+colName+"\""+":"+"\""+colVal+"\"";
     		      }
     		     str+="}";
     		     camma=true;
     		}
     		
     		str+="]";
			pstmt.close();
			conn.close();
			
			
		
		}catch (SQLException e) {e.printStackTrace();} catch (NamingException e) {
			e.printStackTrace();
			System.out.println("GG");
		}
		
		return str;
	}
	
	public String cityjson(String city){

		String str="[";
		try {			
			
			String sqlselect="SELECT [RestaurantID],[RestaurantName],[RestaurantAddress],[RestaurantHashtag],[RestaurantContact],[RestaurantWebsite],[companyID],[Longitude],[Latitude] FROM [PepperNoodles].[dbo].[restaurant] where [RestaurantAddress] like '%'+?+'%'";
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
			System.out.println("ok0");
			Connection conn = ds.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sqlselect);
			System.out.println("ok1");
     		pstmt.setString(1,city);
     		ResultSet rs = pstmt.executeQuery();              
     		System.out.println("ok2");
     		
     		ResultSetMetaData rsmd = rs.getMetaData();
     		int columnCount = rsmd.getColumnCount();
     		boolean camma=false;
     		while (rs.next()) {
     		      // Represent a row in DB. Key: Column name, Value: Column value
     			if(camma==false) {
     				str+="{";
     			}else {
     				str+=",{";
     			}
     			
     		      for (int i = 1; i <= columnCount; i++) {
     		           if(i>1) {
     		        	  str+=",";
     		           }
     		           String colName = rsmd.getColumnName(i);
     		           String colVal = rs.getString(i);
     		          
     		           str+="\""+colName+"\""+":"+"\""+colVal+"\"";
     		      }
     		     str+="}";
     		     camma=true;
     		}
     		
     		str+="]";
			pstmt.close();
			conn.close();
			
			
		
		}catch (SQLException e) {e.printStackTrace();} catch (NamingException e) {
			e.printStackTrace();
			System.out.println("GG");
		}
		
		return str;
	}
	
	public String alljson(){
//		List<Cbean> cityArr=new ArrayList<Cbean>();
		String str="[";
		try {
			System.out.println("ok");
			
			String sqlselect="SELECT TOP(100) *FROM [PepperNoodles].[dbo].[restaurant]";
			Context context=new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn=ds.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sqlselect);

     		ResultSet rs = pstmt.executeQuery();                         
     		
     		ResultSetMetaData rsmd = rs.getMetaData();
     		int columnCount = rsmd.getColumnCount();
     		boolean camma=false;
     		while (rs.next()) {
     		      // Represent a row in DB. Key: Column name, Value: Column value
     			if(camma==false) {
     				str+="{";
     			}else {
     				str+=",{";
     			}
     			
     		      for (int i = 1; i <= columnCount; i++) {
     		           if(i>1) {
     		        	  str+=",";
     		           }
     		           String colName = rsmd.getColumnName(i);
     		           String colVal = rs.getString(i);
     		          
     		           str+="\""+colName+"\""+":"+"\""+colVal+"\"";
     		      }
     		     str+="}";
     		     camma=true;
     		}
     		
     		str+="]";
			pstmt.close();
			conn.close();
			
			
		
		}catch (SQLException e) {e.printStackTrace();} catch (NamingException e) {
			e.printStackTrace();
			System.out.println("GG");
		}
		
		return str;
	}
	
	public String centerSelect(double lng,double lat){
//		List<Cbean> cityArr=new ArrayList<Cbean>();
		String str="[";
		try {
			System.out.println("ok");
			
			String sqlselect="SELECT *FROM [PepperNoodles].[dbo].[restaurant] where abs(Longitude-?)<0.01 and abs(Latitude-?)<0.01";
			Context context=new InitialContext();
			
			DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn=ds.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sqlselect);
			pstmt.setDouble(1, lng);
			pstmt.setDouble(2, lat);
			
     		ResultSet rs = pstmt.executeQuery();     
     		
     		
     		ResultSetMetaData rsmd = rs.getMetaData();
     		int columnCount = rsmd.getColumnCount();
     		boolean camma=false;
     		while (rs.next()) {
     		      // Represent a row in DB. Key: Column name, Value: Column value
     			if(camma==false) {
     				str+="{";
     			}else {
     				str+=",{";
     			}
     			
     		      for (int i = 1; i <= columnCount; i++) {
     		           if(i>1) {
     		        	  str+=",";
     		           }
     		           String colName = rsmd.getColumnName(i);
     		           String colVal = rs.getString(i);
     		          
     		           str+="\""+colName+"\""+":"+"\""+colVal+"\"";
     		      }
     		     str+="}";
     		     camma=true;
     		}
     		
     		str+="]";
			pstmt.close();
			conn.close();
			
			
		
		}catch (SQLException e) {e.printStackTrace();} catch (NamingException e) {
			e.printStackTrace();
			System.out.println("GG");
		}
		
		return str;
	}
	
}
