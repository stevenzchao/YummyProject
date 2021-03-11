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
	
	//�s�W���
	@Override
	public void addCompany(CompanyBean company) {
		try {
			//�s�uSQL
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn = ds.getConnection();
			System.out.println("�s�u���\");
			//�ʺASQL���O�A�W�[�C�@�����
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
			System.out.println("�s�u����");
			e.printStackTrace();
		} 
	}
	@Override
	public List<CompanyBean> getAllCompany() {
		//�إߪ��󶰦X
		List<CompanyBean> findAllCompany = new ArrayList<CompanyBean>();
		try {
			//�s�uSQL
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn = ds.getConnection();
				
			//SQL���O�d�߾��Table
			String getAllSql = "SELECT *  FROM [PepperNoodles].[dbo].[company] ";
			PreparedStatement pstmt = conn.prepareStatement(getAllSql);
			ResultSet rs = pstmt.executeQuery();
			//�u�n�U�@������ƴN�i��B�z
			while (rs.next()) {
				//�إ߳浧����A����o����Ʃ�i����
				CompanyBean Company=new CompanyBean();
				Company.setCompanyID(Integer.parseInt(rs.getString(1)));
				Company.setCompanyName(rs.getString(2));
				Company.setCompanyMail(rs.getString(3));
				Company.setCompanyPwd(rs.getString(4));
				Company.setCompanyContactPperson(rs.getString(5));
				Company.setCompanyPhone(rs.getString(6));
				Company.setCompanyLevel(rs.getString(7));
				//�N�浧����[�J���X
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
			//�s�uSQL
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/servdb");
			Connection conn = ds.getConnection();
			System.out.println("�s�u���\");
			//�ʺASQL���O�A�W�[�C�@�����
			String logInCompany = "SELECT [companyID],[companyName],[companyMail],[companyPwd],[companyContactPperson],[companyPhone],[companyLevel] FROM [PepperNoodles].[dbo].[company]"
								+ "WHERE [companyMail] =? And [companyPwd] = ?";
			PreparedStatement pstmt = conn.prepareStatement(logInCompany);
			pstmt.setString(1, company.getCompanyMail());
			pstmt.setString(2, company.getCompanyPwd());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				// ��쪺��ƸˤJ����
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
			System.out.println("�s�u����");
			e.printStackTrace();
		}
		return findCompany; 
	}
	
}
