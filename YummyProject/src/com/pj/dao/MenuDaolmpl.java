package com.pj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import com.pj.bean.MenuBean;

public class MenuDaolmpl implements MenuDao {

//新增菜單
	@Override
	public void addMenu(MenuBean Menu) {
		try {
			// 連線SQL
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn = ds.getConnection();
			System.out.println("連線成功");
			// 動態SQL指令，增加每一筆資料
			String addSql = "INSERT INTO [PepperNoodles].[dbo].[menu]([company_id],[name],[img],[price],[menu_type],[Best_selling],[remark]) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(addSql);
			
			System.out.println("實作:"+Menu.getCompany_id());
			System.out.println("實作:"+Menu.getName());
			System.out.println("實作:"+Menu.getImg());
			System.out.println("實作:"+Menu.getPrice());
			System.out.println("實作:"+Menu.getMenu_type());
			System.out.println("實作:"+Menu.getBest_selling());
			System.out.println("實作:"+Menu.getRemark());
			
			pstmt.setInt(1, Menu.getCompany_id());
			pstmt.setString(2, Menu.getName());
			pstmt.setBytes(3, Menu.getImg());
			pstmt.setInt(4, Menu.getPrice());
			pstmt.setString(5, Menu.getMenu_type());
			pstmt.setString(6, Menu.getBest_selling());
			pstmt.setString(7, Menu.getRemark());
			pstmt.executeUpdate();
			
			
			
			
			System.out.println("總共新增" + pstmt.getUpdateCount() + "筆資料");
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("連線失敗");
			e.printStackTrace();
		}
	}
//修改菜單
	@Override
	public void updateMenu(MenuBean updateMenu) {
		try {
			// 連線SQL
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn = ds.getConnection();
			// 動態SQL指令，用序號來抓需要修改的資料
			String updatesql = "UPDATE [PepperNoodles].[dbo].[menu] SET [name] =? ,[img] =? ,[price] =? ,[menu_type] =? ,[Best_selling] = ?, [remark] = ? WHERE [menu_seq] =?";
			PreparedStatement pstmt = conn.prepareStatement(updatesql);
			pstmt.setString(1, updateMenu.getName());
			pstmt.setBytes(2, updateMenu.getImg());
			pstmt.setInt(3, updateMenu.getPrice());
			pstmt.setString(4, updateMenu.getMenu_type());
			pstmt.setString(5, updateMenu.getBest_selling());
			pstmt.setString(6, updateMenu.getRemark());
			pstmt.setInt(7, updateMenu.getMenu_seq());
			System.out.print(updateMenu.getMenu_seq());
			pstmt.executeUpdate();
//			System.out.print("++++");
//			System.out.println("總共更新" + pstmt.getUpdateCount() + "筆資料");
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//刪除菜單
	@Override
	public void deleteMenu(int menu_seq) {
		try {
			// 連線SQL
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn = ds.getConnection();
			// 動態SQL指令，用傳入的序號來抓需刪除的資料是哪一筆
			String deletesql = "DELETE FROM [PepperNoodles].[dbo].[menu] WHERE [menu_seq] =?";
			PreparedStatement pstmt = conn.prepareStatement(deletesql);
			pstmt.setInt(1, menu_seq);
			pstmt.executeUpdate();
			System.out.println("總共刪除" + pstmt.getUpdateCount() + "筆資料");
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//查詢單筆菜單資料
	@Override
	public MenuBean selectMenuSeq(int menu_seq) {
		// 建立物件
		MenuBean selectMenu = new MenuBean();
		try {
			// 連線SQL
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn = ds.getConnection();
			// 動態SQL查詢要找的單筆資料
			String selectsql = "SELECT * FROM [PepperNoodles].[dbo].[menu] WHERE [menu_seq]=?";
			PreparedStatement pstmt = conn.prepareStatement(selectsql);
			pstmt.setInt(1, menu_seq);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
			// 找到的資料裝入物件內
				selectMenu.setMenu_seq(Integer.parseInt(rs.getString(1)));
				selectMenu.setCompany_id(Integer.parseInt(rs.getString(2)));
				selectMenu.setName(rs.getString(3));
				selectMenu.setImg(rs.getBytes(4));
				selectMenu.setPrice(Integer.parseInt(rs.getString(5)));
				selectMenu.setMenu_type(rs.getString(6));
				selectMenu.setBest_selling(rs.getString(7));
				selectMenu.setRemark(rs.getString(8));
			}
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return selectMenu;
	}

//用店家ID查詢自己店家的所有菜單
	@Override
	public List<MenuBean> getAllMenu(int companyId) {
		// 建立物件集合
		List<MenuBean> findAllMenu = new ArrayList<MenuBean>();
		// 建立傳進來的參數 (企業id)
		try {
			// 連線SQL
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn = ds.getConnection();
			// SQL指令查詢整個Table
			String getAllSql = "SELECT [menu_seq],[company_id],[name],[img],[price],[menu_type].type_name,[Best_selling],[remark] "
							 + "FROM [PepperNoodles].[dbo].[menu] INNER JOIN [PepperNoodles].[dbo].[menu_type] on menu.menu_type=menu_type.type_seq WHERE [company_id] = ?";
			PreparedStatement pstmt = conn.prepareStatement(getAllSql);
			pstmt.setInt(1, companyId);
			ResultSet rs = pstmt.executeQuery();
			// 只要下一筆有資料就進行處理
			MenuBean Menus = null;
			while (rs.next()) {
				// 建立單筆物件，把取得的資料放進物件
				Menus = new MenuBean();
				Menus.setMenu_seq(Integer.parseInt(rs.getString(1)));
				Menus.setCompany_id(Integer.parseInt(rs.getString(2)));
				Menus.setName(rs.getString(3));
				Menus.setImg(rs.getBytes(4));
				Menus.setPrice(Integer.parseInt(rs.getString(5)));
				Menus.setMenu_type(rs.getString(6));
				Menus.setBest_selling(rs.getString(7));
				Menus.setRemark(rs.getString(8));
				// 將單筆物件加入集合
				findAllMenu.add(Menus);
			}
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return findAllMenu;
	}
}
