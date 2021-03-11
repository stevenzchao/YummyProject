package com.pj.bean;

public class RestaurantBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private String RestaurantID;
	private String RestaurantName;
	private String RestaurantAddress;
	private String RestaurantLong;
	private String RestaurantLati;
	private String RestaurantHashtag;
	private String RestaurantContact;
	private String RestaurantWebsite;
	private byte[] RestaurantPhoto;
	private String companyID;
	private int updatecount;
	public String getRestaurantID() {
		return RestaurantID;
	}
	public void setRestaurantID(String restaurantID) {
		RestaurantID = restaurantID;
	}
	public String getRestaurantName() {
		return RestaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		RestaurantName = restaurantName;
	}
	public String getRestaurantAddress() {
		return RestaurantAddress;
	}
	public void setRestaurantAddress(String restaurantAddress) {
		RestaurantAddress = restaurantAddress;
	}
	public String getRestaurantLong() {
		return RestaurantLong;
	}
	public void setRestaurantLong(String restaurantLong) {
		RestaurantLong = restaurantLong;
	}
	public String getRestaurantLati() {
		return RestaurantLati;
	}
	public void setRestaurantLati(String restaurantLati) {
		RestaurantLati = restaurantLati;
	}
	public String getRestaurantHashtag() {
		return RestaurantHashtag;
	}
	public void setRestaurantHashtag(String restaurantHashtag) {
		RestaurantHashtag = restaurantHashtag;
	}
	public String getRestaurantContact() {
		return RestaurantContact;
	}
	public void setRestaurantContact(String restaurantContact) {
		RestaurantContact = restaurantContact;
	}
	public String getRestaurantWebsite() {
		return RestaurantWebsite;
	}
	public void setRestaurantWebsite(String restaurantWebsite) {
		RestaurantWebsite = restaurantWebsite;
	}
	public byte[] getRestaurantPhoto() {
		return RestaurantPhoto;
	}
	public void setRestaurantPhoto(byte[] restaurantPhoto) {
		RestaurantPhoto = restaurantPhoto;
	}
	public String getCompanyID() {
		return companyID;
	}
	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}
	public int getUpdatecount() {
		return updatecount;
	}
	public void setUpdatecount(int updatecount) {
		this.updatecount = updatecount;
	}


	
	






}
