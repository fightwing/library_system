package com.rain.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.rain.bean.BookBean;
import com.rain.bean.Donation;
import com.rain.util.DBUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DonationDao {
	
	public int donate(String donator, String phonenumber, String bookname, String booknumber){
		int tag=0;
		Connection conn = DBUtil.getConnectDb();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		System.out.println("Get Connection");
		
		String sql="insert into donate(donater,phonenumber,bookname,booknum) values(?,?,?,?)";
		int booknumber1=Integer.parseInt(booknumber);
		
		
		try {
			  ps=conn.prepareStatement(sql);
			  ps.setString(1,donator);
			  ps.setString(2,phonenumber);
			  ps.setString(3,bookname);
			  ps.setInt(4,booknumber1);
			  
			  tag=ps.executeUpdate();
			  
		}catch(SQLException e){
			e.printStackTrace();
			
		}finally {
			DBUtil.CloseDB(rs,ps,conn);
		}
		
		
		return tag;
	}





	public ArrayList<Donation> get_donationInfo(){
		ArrayList<Donation> tag_Array = new ArrayList<Donation>();
		Connection conn = DBUtil.getConnectDb();
		String sql = "select * from donate";
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				Donation tag = new Donation();
				tag.setDid(rs.getInt("did"));
				tag.setName(rs.getString("donater"));
				tag.setBookname(rs.getString("bookname"));
				tag.setBooknumber(rs.getInt("booknum"));
				tag_Array.add(tag);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.CloseDB(rs, stm, conn);
		}
		return tag_Array;
	}
}