package com.pj.dao;

import java.util.List;

import com.pj.bean.MenuBean;

public interface MenuDao {
	public void addMenu(MenuBean name); //�s�W
	public void updateMenu(MenuBean seq); //�ק�
	public void deleteMenu(int seq); //�R��
	public MenuBean selectMenuSeq(int seq); //�ΧǸ����o�ӵ������
	public List<MenuBean> getAllMenu(int company_id); //�̩��aID�d�߸ө��������
}
