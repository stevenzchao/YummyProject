package com.yummyproject.Dao;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import com.yummyproject.Bean.YummyBean;


public class YummyDAOImpl implements YummyDAO {
	
	private Connection conektYummy() {//連線池
		try{
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/servdb"); 
			return ds.getConnection();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (NamingException e) {
				e.printStackTrace();
			}
			return null;
	}
	
	@Override
	public YummyBean FindUser(YummyBean yb) {//綁定帳密做查詢
		String sql="SELECT [Account],[Password],[RealName],[NickName],[PhoneNumber],[BirthDay],[ProtraitName],[UserProtrait],[Sex],[District],[YummyPoint],[Level_ID]"
			      +"FROM [PepperNoodles].[dbo].[AccountMember] WHERE [Account]= ? and [Password]= ?";
		try(Connection conn = conektYummy()){
			try (PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1,yb.getAccount());
				pstmt.setString(2,yb.getPassword());
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					yb = new YummyBean();
					yb.setAccount(rs.getString("Account"));
					yb.setPassword(rs.getString("Password"));
					yb.setRealName(rs.getString("RealName"));
					yb.setNickName(rs.getString("NickName"));
					yb.setPhoneNumber(rs.getString("PhoneNumber"));
					yb.setBirthDay(rs.getString("BirthDay"));
					yb.setUserProtrait(rs.getBytes("UserProtrait"));
					yb.setSex(rs.getString("Sex"));
					yb.setDistrict(rs.getString("District"));
					if (rs.getString("YummyPoint")==null) {
						yb.setYummyPoint(0);
					}else {
						yb.setYummyPoint(Integer.parseInt(rs.getString("YummyPoint")));
					}
					yb.setLevel_ID(rs.getString("Level_ID"));
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return yb;
	}




	@Override
	public int updateFile(String Account,YummyBean yb) {
		int result = 0;
		String sql ="UPDATE PepperNoodles.[dbo].[AccountMember]"
				   + "SET [RealName] = '"+yb.getRealName()
				   + "',[NickName] ='"+yb.getNickName()
				   + "',[PhoneNumber] ='"+yb.getPhoneNumber()
				   + "',[BirthDay] ='"+yb.getBirthDay()
				   + "',[District] ='"+yb.getDistrict()
				   + "'WHERE[Account]='"+Account+"'";
		try(Connection conn = conektYummy()){
			try (PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.executeUpdate();
				result = 1;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}




	@Override
	public YummyBean Find_one_User(String Account) {
		String sql="SELECT [Account],[Password],[RealName],[NickName],[PhoneNumber],[BirthDay],[UserProtrait],[Sex],[District],[YummyPoint],[Level_ID] FROM [PepperNoodles].[dbo].[AccountMember]"
				  +"WHERE [Account]=?";
		YummyBean yb = null;
		try(Connection conn = conektYummy()){
			try (PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1, Account);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					yb = new YummyBean();
					yb.setAccount(rs.getString("Account"));
					yb.setPassword(rs.getString("Password"));
					yb.setRealName(rs.getString("RealName"));
					yb.setNickName(rs.getString("NickName"));
					yb.setPhoneNumber(rs.getString("PhoneNumber"));
					yb.setBirthDay(rs.getString("BirthDay"));
					yb.setUserProtrait(rs.getBytes("UserProtrait"));
					yb.setSex(rs.getString("Sex"));
					yb.setDistrict(rs.getString("District"));
					yb.setYummyPoint(Integer.parseInt(rs.getString("YummyPoint")));
					yb.setLevel_ID(rs.getString("Level_ID"));
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return yb;
		
	}

	@Override
	public YummyBean uploadImg(YummyBean yb) {
		String sql = "UPDATE [PepperNoodles].[dbo].[AccountMember] SET [ProtraitName] =?,[UserProtrait] =? WHERE [Account] =?";
		try(Connection conn = conektYummy()){
			try(PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1, yb.getProtraitName());				
				pstmt.setBytes(2, yb.getUserProtrait());
				pstmt.setString(3, yb.getAccount());
				pstmt.execute();
				System.out.print("==++");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		} 
		return yb;
	}

	@Override
	public YummyBean addUser(YummyBean cus) {
		String sql = "INSERT INTO [PepperNoodles].[dbo].[AccountMember]([Account],[Password],[RealName],[NickName],[PhoneNumber]) VALUES (?,?,?,?,?)";
		try(Connection conn = conektYummy()){
			try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, cus.getAccount());				
			pstmt.setString(2, cus.getPassword());
			pstmt.setString(3, cus.getRealName());
			pstmt.setString(4, cus.getNickName());
			pstmt.setString(5, cus.getPhoneNumber());
			pstmt.executeUpdate();
		}
	}catch (SQLException e) {
		e.printStackTrace();
	} 
	 return cus;
	}







	
	
}//end
