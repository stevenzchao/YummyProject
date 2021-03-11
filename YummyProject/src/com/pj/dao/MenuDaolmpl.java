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

//�s�W���
	@Override
	public void addMenu(MenuBean Menu) {
		try {
			// �s�uSQL
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn = ds.getConnection();
			System.out.println("�s�u���\");
			// �ʺASQL���O�A�W�[�C�@�����
			String addSql = "INSERT INTO [PepperNoodles].[dbo].[menu]([company_id],[name],[img],[price],[menu_type],[Best_selling],[remark]) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(addSql);
			
			System.out.println("��@:"+Menu.getCompany_id());
			System.out.println("��@:"+Menu.getName());
			System.out.println("��@:"+Menu.getImg());
			System.out.println("��@:"+Menu.getPrice());
			System.out.println("��@:"+Menu.getMenu_type());
			System.out.println("��@:"+Menu.getBest_selling());
			System.out.println("��@:"+Menu.getRemark());
			
			pstmt.setInt(1, Menu.getCompany_id());
			pstmt.setString(2, Menu.getName());
			pstmt.setBytes(3, Menu.getImg());
			pstmt.setInt(4, Menu.getPrice());
			pstmt.setString(5, Menu.getMenu_type());
			pstmt.setString(6, Menu.getBest_selling());
			pstmt.setString(7, Menu.getRemark());
			pstmt.executeUpdate();
			
			
			
			
			System.out.println("�`�@�s�W" + pstmt.getUpdateCount() + "�����");
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("�s�u����");
			e.printStackTrace();
		}
	}
//�ק���
	@Override
	public void updateMenu(MenuBean updateMenu) {
		try {
			// �s�uSQL
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn = ds.getConnection();
			// �ʺASQL���O�A�ΧǸ��ӧ�ݭn�ק諸���
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
//			System.out.println("�`�@��s" + pstmt.getUpdateCount() + "�����");
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//�R�����
	@Override
	public void deleteMenu(int menu_seq) {
		try {
			// �s�uSQL
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn = ds.getConnection();
			// �ʺASQL���O�A�ζǤJ���Ǹ��ӧ�ݧR������ƬO���@��
			String deletesql = "DELETE FROM [PepperNoodles].[dbo].[menu] WHERE [menu_seq] =?";
			PreparedStatement pstmt = conn.prepareStatement(deletesql);
			pstmt.setInt(1, menu_seq);
			pstmt.executeUpdate();
			System.out.println("�`�@�R��" + pstmt.getUpdateCount() + "�����");
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//�d�߳浧�����
	@Override
	public MenuBean selectMenuSeq(int menu_seq) {
		// �إߪ���
		MenuBean selectMenu = new MenuBean();
		try {
			// �s�uSQL
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn = ds.getConnection();
			// �ʺASQL�d�߭n�䪺�浧���
			String selectsql = "SELECT * FROM [PepperNoodles].[dbo].[menu] WHERE [menu_seq]=?";
			PreparedStatement pstmt = conn.prepareStatement(selectsql);
			pstmt.setInt(1, menu_seq);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
			// ��쪺��ƸˤJ����
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

//�Ω��aID�d�ߦۤv���a���Ҧ����
	@Override
	public List<MenuBean> getAllMenu(int companyId) {
		// �إߪ��󶰦X
		List<MenuBean> findAllMenu = new ArrayList<MenuBean>();
		// �إ߶Ƕi�Ӫ��Ѽ� (���~id)
		try {
			// �s�uSQL
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn = ds.getConnection();
			// SQL���O�d�߾��Table
			String getAllSql = "SELECT [menu_seq],[company_id],[name],[img],[price],[menu_type].type_name,[Best_selling],[remark] "
							 + "FROM [PepperNoodles].[dbo].[menu] INNER JOIN [PepperNoodles].[dbo].[menu_type] on menu.menu_type=menu_type.type_seq WHERE [company_id] = ?";
			PreparedStatement pstmt = conn.prepareStatement(getAllSql);
			pstmt.setInt(1, companyId);
			ResultSet rs = pstmt.executeQuery();
			// �u�n�U�@������ƴN�i��B�z
			MenuBean Menus = null;
			while (rs.next()) {
				// �إ߳浧����A����o����Ʃ�i����
				Menus = new MenuBean();
				Menus.setMenu_seq(Integer.parseInt(rs.getString(1)));
				Menus.setCompany_id(Integer.parseInt(rs.getString(2)));
				Menus.setName(rs.getString(3));
				Menus.setImg(rs.getBytes(4));
				Menus.setPrice(Integer.parseInt(rs.getString(5)));
				Menus.setMenu_type(rs.getString(6));
				Menus.setBest_selling(rs.getString(7));
				Menus.setRemark(rs.getString(8));
				// �N�浧����[�J���X
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
