package com.pj.bean;

public class MenuBean  implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer menu_seq; //���Ǹ�
	private int company_id; //���~ID
	private String name; //��W
	private byte[] img;  //�Ϥ�
	private Integer price;  //����
	private String menu_type;  //����
	private String Best_selling; //�O�_�����P
	private String remark; //��⻡��
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
