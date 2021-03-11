package com.pj.bean;

public class MenuBean  implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer menu_seq; //菜單序號
	private int company_id; //企業ID
	private String name; //菜名
	private byte[] img;  //圖片
	private Integer price;  //價格
	private String menu_type;  //類型
	private String Best_selling; //是否為熱銷
	private String remark; //菜色說明
	public Integer getMenu_seq() {
		return menu_seq;
	}
	public void setMenu_seq(Integer menu_seq) {
		this.menu_seq = menu_seq;
	}
	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getImg() {
		return img;
	}
	public void setImg(byte[] img) {
		this.img = img;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getMenu_type() {
		return menu_type;
	}
	public void setMenu_type(String menu_type) {
		this.menu_type = menu_type;
	}
	public String getBest_selling() {
		return Best_selling;
	}
	public void setBest_selling(String best_selling) {
		Best_selling = best_selling;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	

}
