package com.yummyproject.Bean;


public class YummyBean implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private String Account;
	private String Password;
	private String RealName;
	private String NickName;
	private String PhoneNumber;
	private String BirthDay;
	private String ProtraitName;
	private byte[] UserProtrait;
	private String Sex;
	private String District;
	private int YummyPoint;
	private String Code;
	private String Level_ID;
	
	public YummyBean() {super();}
	
	public String getProtraitName() {return ProtraitName;}
	public String getAccount() {return Account;}
	public String getPassword() {return Password;}
	public String getRealName() {return RealName;}
	public String getNickName() {return NickName;}
	public String getPhoneNumber() {return PhoneNumber;}
	public String getBirthDay() {return BirthDay;}
	public byte[] getUserProtrait() {return UserProtrait;}
	public String getSex() {return Sex;}
	public String getDistrict() {return District;}
	public int getYummyPoint() {return YummyPoint;}
	public String getLevel_ID() {return Level_ID;}
	
	public void setProtraitName(String protraitName) {ProtraitName = protraitName;}
	public void setAccount(String account) {this.Account = account;}
	public void setPassword(String password) {this.Password = password;}
	public void setRealName(String realName) {this.RealName = realName;}
	public void setNickName(String nickName) {this.NickName = nickName;}
	public void setPhoneNumber(String phoneNumber) {this.PhoneNumber = phoneNumber;}
	public void setBirthDay(String birthDay) {this.BirthDay = birthDay;}
	public void setUserProtrait(byte[] userProtrait) {this.UserProtrait = userProtrait;}
	public void setSex(String sex) {this.Sex = sex;}
	public void setDistrict(String district) {this.District = district;}
	public void setYummyPoint(int yummyPoint) {this.YummyPoint = yummyPoint;}
	public void setLevel_ID(String level_ID) {this.Level_ID = level_ID;}
	
	
	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public String toString(){
		return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s%n",
				Account,Password,RealName,NickName, 
				PhoneNumber,BirthDay,UserProtrait,
				Sex,District,YummyPoint,Level_ID);
		}
	
}
