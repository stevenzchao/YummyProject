package com.pj.bean;

public class CompanyBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer companyID; //���~�|��id
	private String companyName; //���~�W��
	private String companyMail; //���~�|��mail
	private String companyPwd; //���~�|���K�X
	private String companyContactPperson; //�p���H
	private String companyPhone;  //�s���q��
	private String companyLevel;//���~�|������
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
