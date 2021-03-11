package com.pj.dao;

import java.util.List;

import com.pj.bean.MenuBean;

public interface MenuDao {
	public void addMenu(MenuBean name); //新增
	public void updateMenu(MenuBean seq); //修改
	public void deleteMenu(int seq); //刪除
	public MenuBean selectMenuSeq(int seq); //用序號取得該筆菜單資料
	public List<MenuBean> getAllMenu(int company_id); //依店家ID查詢該店全部菜單
}
