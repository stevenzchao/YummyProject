package com.pj.dao;

import java.util.List;

import com.pj.bean.CompanyBean;

public interface CompanyDao {
	
	public void addCompany(CompanyBean companyName); //新增
	public List<CompanyBean> getAllCompany(); //顯示全部企業會員
	public CompanyBean logInCompany(CompanyBean companyName); //企業登陸
}


