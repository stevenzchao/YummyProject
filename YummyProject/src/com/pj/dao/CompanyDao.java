package com.pj.dao;

import java.util.List;

import com.pj.bean.CompanyBean;

public interface CompanyDao {
	
	public void addCompany(CompanyBean companyName); //�s�W
	public List<CompanyBean> getAllCompany(); //��ܥ������~�|��
	public CompanyBean logInCompany(CompanyBean companyName); //���~�n��
}


