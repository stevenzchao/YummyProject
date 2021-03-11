package com.pj.dao;

import java.util.List;

import com.pj.bean.RestaurantBean;

public interface RestaurantDao {
	public RestaurantBean readR(String RestaurantID);
	public List<RestaurantBean> readAll();
	public List<RestaurantBean> readAllbyCID(int CID);
	public RestaurantBean newR(String RName,String RAddress,String RLong,String RLati,String RHashtag
			,String RContact,String RWebsite,byte[] RPhoto,String companyID);
	public void updateR(String RestaurantID,String RName,String RAddress,String RLong,String RLati,String RHashtag
			,String RContact,String RWebsite ,byte[] RPhoto);
	public List<RestaurantBean> Rkeyword(String keyword);
	public List<RestaurantBean> RkeywordbyCID(int CID,String keyword);
	public int deleteEmp(String RestaurantID);
	public RestaurantBean RIDtoPhoto(String RestaurantID);


}
