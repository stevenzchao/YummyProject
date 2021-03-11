package com.yummyproject.Dao;

import java.io.File;


import com.yummyproject.Bean.YummyBean;

public interface YummyDAO {
	//jpg
	public YummyBean uploadImg(YummyBean yb);
	
	//cud
	public int updateFile(String Account,YummyBean yb);
	
	//r
	public YummyBean FindUser(YummyBean yb) ;
	
	public YummyBean Find_one_User(String Account) ;
	
	public YummyBean addUser(YummyBean cus);
}
