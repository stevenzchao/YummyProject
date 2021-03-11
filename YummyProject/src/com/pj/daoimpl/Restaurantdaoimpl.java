package com.pj.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.pj.bean.RestaurantBean;
import com.pj.dao.RestaurantDao;

public class Restaurantdaoimpl implements RestaurantDao {
	RestaurantBean Restaurant = new RestaurantBean();
	List<RestaurantBean> Restaurants = new ArrayList<>();
	int updatecount;

	@Override
	public List<RestaurantBean> readAll() {
		String SQL = "USE PepperNoodles SELECT * FROM [PepperNoodles].[dbo].restaurant ";
		try {
			System.out.println("*****");
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			ResultSet rs = pstmt.executeQuery();
			RestaurantBean restaurant = null;
			while (rs.next()) {
				restaurant = new RestaurantBean();
				restaurant.setRestaurantID(rs.getString("RestaurantID"));
				restaurant.setRestaurantName(rs.getString("RestaurantName"));
				restaurant.setRestaurantAddress(rs.getString("RestaurantAddress"));
				restaurant.setRestaurantLong(rs.getString("Longitude"));
				restaurant.setRestaurantLati(rs.getString("Latitude"));
				restaurant.setRestaurantContact(rs.getString("RestaurantContact"));
				restaurant.setRestaurantWebsite(rs.getString("RestaurantWebsite"));
				restaurant.setRestaurantHashtag(rs.getString("RestaurantHashtag"));
				restaurant.setRestaurantPhoto(rs.getBytes("RestaurantPhoto"));
				restaurant.setCompanyID(rs.getString("companyID"));
				System.out.println(restaurant.getCompanyID());
				Restaurants.add(restaurant);
			}
			conn.close();
		} catch (Exception e) {

		}
		return Restaurants;
	}

	@Override
	public List<RestaurantBean> readAllbyCID(int CID) {
		String SQL = "use PepperNoodles select * from [PepperNoodles].[dbo].restaurant where companyID=?";
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, CID);
			ResultSet rs = pstmt.executeQuery();
			System.out.print("++");
			RestaurantBean restaurant = null;
			while (rs.next()) {
				restaurant = new RestaurantBean();
				restaurant.setRestaurantID(rs.getString("RestaurantID"));
				restaurant.setRestaurantName(rs.getString("RestaurantName"));
				restaurant.setRestaurantAddress(rs.getString("RestaurantAddress"));
				restaurant.setRestaurantLong(rs.getString("Longitude"));
				restaurant.setRestaurantLati(rs.getString("Latitude"));
				restaurant.setRestaurantContact(rs.getString("RestaurantContact"));
				restaurant.setRestaurantWebsite(rs.getString("RestaurantWebsite"));
				restaurant.setRestaurantHashtag(rs.getString("RestaurantHashtag"));
				restaurant.setRestaurantPhoto(rs.getBytes("RestaurantWebsite"));
				restaurant.setCompanyID(rs.getString("companyID"));
				Restaurants.add(restaurant);
			}
			conn.close();
//			System.out.println("Dao=" + Restaurants); //蝣箏�AO���
		} catch (Exception e) {

		}
		return Restaurants;
	}
	
	@Override
	public RestaurantBean newR(String RName, String RAddress, String RLong, String RLati, String RHashtag,
			String RContact, String RWebsite, byte[] RPhoto, String companyID) {
		String SQL = "use PepperNoodles insert into Restaurant([RestaurantName],[RestaurantAddress],[RestaurantHashtag],[RestaurantContact],[RestaurantWebsite],[RestaurantPhoto],[companyID],[Longitude],[Latitude])"
				+ "values(?,?,?,?,?,?,?,?,?)";
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL);
//			insert�脰��澈
			pstmt.setString(1, RName);
			pstmt.setString(2, RAddress);
			pstmt.setString(3, RHashtag);
			pstmt.setString(4, RContact);
			pstmt.setString(5, RWebsite);
			pstmt.setBytes(6, RPhoto);
			pstmt.setString(7, companyID);
			pstmt.setString(8, RLong);
			pstmt.setString(9, RLati);
			pstmt.execute();
//			��噶��憓����bean鋆⊿ ���ontroller隞乩噶�蝯匡SP憿舐內蝯圭lient
			Restaurant.setRestaurantName(RName);
			Restaurant.setRestaurantAddress(RAddress);
			Restaurant.setRestaurantHashtag(RHashtag);
			Restaurant.setRestaurantContact(RContact);
			Restaurant.setRestaurantWebsite(RWebsite);
			Restaurant.setRestaurantPhoto(RPhoto);
			Restaurant.setCompanyID(companyID);
			Restaurant.setRestaurantLong(RLong);
			Restaurant.setRestaurantLati(RLati);
			conn.close();
		} catch (Exception e) {

		}

		return Restaurant;
	}

	@Override
	public void updateR(String RestaurantID, String RName, String RAddress, String RLong, String RLati,
			String RHashtag, String RContact, String RWebsite, byte[] RPhoto) {

		try {
			System.out.print("-1=����" + RPhoto[0]);
			String SQL = "use PepperNoodles update Restaurant set RestaurantName=?, RestaurantAddress=?, Longitude=?, Latitude=?,RestaurantHashtag=?, RestaurantContact=?,RestaurantWebsite=? ,RestaurantPhoto=? where RestaurantID=?";
			// ��蝺��
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL);
//					update�脰��澈
			pstmt.setString(1, RName);
			pstmt.setString(2, RAddress);
			pstmt.setString(3, RLong);
			pstmt.setString(4, RLati);
			pstmt.setString(5, RHashtag);
			pstmt.setString(6, RContact);
			pstmt.setString(7, RWebsite);
			pstmt.setBytes(8, RPhoto);
			pstmt.setString(9, RestaurantID);
			pstmt.execute();

//					��噶��憓����bean鋆⊿ ���ontroller隞乩噶�蝯匡SP憿舐內蝯圭lient
			Restaurant.setRestaurantID(RestaurantID);

			conn.close();
		} catch (IndexOutOfBoundsException | SQLException | NamingException e) {
			System.out.println("瘝��");
			e.printStackTrace();
			try {
			String SQL = "use PepperNoodles update Restaurant set RestaurantName=?, RestaurantAddress=?, Longitude=?, Latitude=?,RestaurantHashtag=?, RestaurantContact=?,RestaurantWebsite=? where RestaurantID=?";
			// ��蝺��
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL);
//					update�脰��澈
			pstmt.setString(1, RName);
			pstmt.setString(2, RAddress);
			pstmt.setString(3, RLong);
			pstmt.setString(4, RLati);
			pstmt.setString(5, RHashtag);
			pstmt.setString(6, RContact);
			pstmt.setString(7, RWebsite);
			pstmt.setString(8, RestaurantID);
			pstmt.execute();

//					��噶��憓����bean鋆⊿ ���ontroller隞乩噶�蝯匡SP憿舐內蝯圭lient
			Restaurant.setRestaurantID(RestaurantID);
			conn.close();
			
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}}

	}

	@Override
	public RestaurantBean readR(String RestaurantID) {
		String SQL = "use PepperNoodles select * from Restaurant where RestaurantID=? ";
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, RestaurantID);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				Restaurant.setRestaurantID(rs.getString("RestaurantID"));
				Restaurant.setRestaurantName(rs.getString("RestaurantName"));
				Restaurant.setRestaurantAddress(rs.getString("RestaurantAddress"));
				Restaurant.setRestaurantLong(rs.getString("Longitude"));
				Restaurant.setRestaurantLati(rs.getString("Latitude"));
				Restaurant.setRestaurantHashtag(rs.getString("RestaurantHashtag"));
				Restaurant.setRestaurantContact(rs.getString("RestaurantContact"));
				Restaurant.setRestaurantWebsite(rs.getString("RestaurantWebsite"));
				Restaurant.setCompanyID(rs.getString("companyID"));

			}
			conn.close();
//			System.out.println("Dao=" + Restaurants); //蝣箏�AO���
		} catch (Exception e) {

		}
		return Restaurant;
	}

	@Override
	public int deleteEmp(String RestaurantID) {
		String SQL = "use PepperNoodles DELETE FROM Restaurant where RestaurantID=?";
		try {
			Connection conn;
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/servdb");
			conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, RestaurantID);
			pstmt.execute();
			updatecount = pstmt.getUpdateCount();// ����瘥

			conn.close();
		} catch (Exception e) {

		}

		return updatecount;
	}

	@Override
	public List<RestaurantBean> Rkeyword(String keyword) {
		String SQL = "use PepperNoodles select * from Restaurant where ( RestaurantName like '%'+?+'%' or RestaurantID like '%'+?+'%')";
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, keyword);
			pstmt.setString(2, keyword);
			ResultSet rs = pstmt.executeQuery();

			RestaurantBean restaurant = null;
			while (rs.next()) {
				restaurant = new RestaurantBean();
				restaurant.setRestaurantID(rs.getString("RestaurantID"));
				restaurant.setRestaurantName(rs.getString("RestaurantName"));
				restaurant.setRestaurantAddress(rs.getString("RestaurantAddress"));
				restaurant.setRestaurantContact(rs.getString("RestaurantContact"));
				restaurant.setRestaurantWebsite(rs.getString("RestaurantWebsite"));
				restaurant.setCompanyID(rs.getString("companyID"));

				Restaurants.add(restaurant);
			}
			conn.close();
//			System.out.println("Dao=" + Restaurants); //蝣箏�AO���
		} catch (Exception e) {

		}
		return Restaurants;
	}

	@Override
	public List<RestaurantBean> RkeywordbyCID(int CID,String keyword) {
		String SQL = "use PepperNoodles select * from Restaurant where companyID=? and ( RestaurantName like '%'+?+'%' or RestaurantID like '%'+?+'%')";
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, CID);
			pstmt.setString(2, keyword);
			pstmt.setString(3, keyword);
			ResultSet rs = pstmt.executeQuery();

			RestaurantBean restaurant = null;
			while (rs.next()) {
				restaurant = new RestaurantBean();
				restaurant.setRestaurantID(rs.getString("RestaurantID"));
				restaurant.setRestaurantName(rs.getString("RestaurantName"));
				restaurant.setRestaurantAddress(rs.getString("RestaurantAddress"));
				restaurant.setRestaurantContact(rs.getString("RestaurantContact"));
				restaurant.setRestaurantWebsite(rs.getString("RestaurantWebsite"));
				restaurant.setCompanyID(rs.getString("companyID"));

				Restaurants.add(restaurant);
			}
			conn.close();
//			System.out.println("Dao=" + Restaurants); //蝣箏�AO���
		} catch (Exception e) {

		}
		return Restaurants;
	}
	
	
	
	@Override
	public RestaurantBean RIDtoPhoto(String RestaurantID) {
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn = ds.getConnection();

			PreparedStatement pstmt = conn.prepareStatement(
					"use PepperNoodles Select Top 1 restaurantPhoto From restaurant Where restaurantID =?");
			pstmt.setString(1, RestaurantID);
			ResultSet rs = pstmt.executeQuery();
			byte[] img = null;
			if (rs.next()) {
				img = rs.getBytes(1);
			}
			rs.close();
			pstmt.close();
			conn.close();
			Restaurant.setRestaurantPhoto(img);

		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Restaurant;
	}





}
