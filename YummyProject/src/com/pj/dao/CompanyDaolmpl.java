package com.pj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import com.pj.bean.CompanyBean;

public class CompanyDaolmpl implements CompanyDao {
	
	//新增資料
	@Override
	public void addCompany(CompanyBean company) {
		try {
			//連線SQL
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn = ds.getConnection();
			System.out.println("連線成功");
			//動態SQL指令，增加每一筆資料
			String addSql = "INSERT INTO [PepperNoodles].[dbo].[company]([companyName],[companyMail],[companyPwd],[companyContactPperson],[companyPhone],[companyLevel]) VALUES (?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(addSql);
			pstmt.setString(1, company.getCompanyName());
			pstmt.setString(2, company.getCompanyMail());
			pstmt.setString(3, company.getCompanyPwd());
			pstmt.setString(4, company.getCompanyContactPperson());
			pstmt.setString(5, company.getCompanyPhone());
			pstmt.setString(6, "C");
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();

		} catch (Exception e) {
			System.out.println("連線失敗");
			e.printStackTrace();
		} 
	}
	@Override
	public List<CompanyBean> getAllCompany() {
		//建立物件集合
		List<CompanyBean> findAllCompany = new ArrayList<CompanyBean>();
		try {
			//連線SQL
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn = ds.getConnection();
				
			//SQL指令查詢整個Table
			String getAllSql = "SELECT *  FROM [PepperNoodles].[dbo].[company] ";
			PreparedStatement pstmt = conn.prepareStatement(getAllSql);
			ResultSet rs = pstmt.executeQuery();
			//只要下一筆有資料就進行處理
			while (rs.next()) {
				//建立單筆物件，把取得的資料放進物件
				CompanyBean Company=new CompanyBean();
				Company.setCompanyID(Integer.parseInt(rs.getString(1)));
				Company.setCompanyName(rs.getString(2));
				Company.setCompanyMail(rs.getString(3));
				Company.setCompanyPwd(rs.getString(4));
				Company.setCompanyContactPperson(rs.getString(5));
				Company.setCompanyPhone(rs.getString(6));
				Company.setCompanyLevel(rs.getString(7));
				//將單筆物件加入集合
				findAllCompany.add(Company);
			}	
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return findAllCompany;
	}
	@Override
	public CompanyBean logInCompany(CompanyBean company) {
		CompanyBean findCompany = new CompanyBean();
		try {
			//連線SQL
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn = ds.getConnection();
			System.out.println("連線成功");
			//動態SQL指令，增加每一筆資料
			String logInCompany = "SELECT [companyID],[companyName],[companyMail],[companyPwd],[companyContactPperson],[companyPhone],[companyLevel] FROM [PepperNoodles].[dbo].[company]"
								+ "WHERE [companyMail] =? And [companyPwd] = ?";
			PreparedStatement pstmt = conn.prepareStatement(logInCompany);
			pstmt.setString(1, company.getCompanyMail());
			pstmt.setString(2, company.getCompanyPwd());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				// 找到的資料裝入物件內
				findCompany.setCompanyID(Integer.parseInt(rs.getString(1)));
				findCompany.setCompanyName(rs.getString(2));
				findCompany.setCompanyMail(rs.getString(3));
				findCompany.setCompanyPwd(rs.getString(4));
				findCompany.setCompanyContactPperson(rs.getString(5));
				findCompany.setCompanyPhone(rs.getString(6));
				findCompany.setCompanyLevel(rs.getString(7));
				
//				System.out.println(rs.getString(1));
//				System.out.println(rs.getString(2));
//				System.out.println(rs.getString(3));
//				System.out.println(rs.getString(4));
//				System.out.println(rs.getString(5));
//				System.out.println(rs.getString(6));
//				System.out.println(rs.getString(7));
				
			}
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("連線失敗");
			e.printStackTrace();
		}
		return findCompany; 
	}
	
}
