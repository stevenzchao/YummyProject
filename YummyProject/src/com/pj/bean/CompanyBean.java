package com.pj.bean;

public class CompanyBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer companyID; //企業會員id
	private String companyName; //企業名稱
	private String companyMail; //企業會員mail
	private String companyPwd; //企業會員密碼
	private String companyContactPperson; //聯絡人
	private String companyPhone;  //連絡電話
	private String companyLevel;//企業會員等級
	public Integer getCompanyID() {
		return companyID;
	}
	public void setCompanyID(Integer companyID) {
		this.companyID = companyID;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyMail() {
		return companyMail;
	}
	public void setCompanyMail(String companyMail) {
		this.companyMail = companyMail;
	}
	public String getCompanyPwd() {
		return companyPwd;
	}
	public void setCompanyPwd(String companyPwd) {
		this.companyPwd = companyPwd;
	}
	public String getCompanyContactPperson() {
		return companyContactPperson;
	}
	public void setCompanyContactPperson(String companyContactPperson) {
		this.companyContactPperson = companyContactPperson;
	}
	public String getCompanyPhone() {
		return companyPhone;
	}
	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}
	public String getCompanyLevel() {
		return companyLevel;
	}
	public void setCompanyLevel(String companyLevel) {
		this.companyLevel = companyLevel;
	}
	
}
