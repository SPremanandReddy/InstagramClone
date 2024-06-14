package com.ig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
public class InstaDbUtil {
		
	public static String SignUpInstagramUser(userInstaDetails userdata) throws SQLException {
		
		Connection connection = DriverManager.getConnection(Constants.DBURL,Constants.DBUSERNAME,Constants.DBPASSWORD);
		System.out.println("Connection to the database has been established");
		PreparedStatement pst  = connection.prepareStatement("Insert into INSTAGRAM values (?,?,?,?,?,?)");
		pst.execute("use mydb");
		pst.setString(1, userdata.getFname());
		pst.setString(2, userdata.getLname());
		pst.setString(3, userdata.getEmailid());
		pst.setString(4, userdata.getUsername());
		pst.setString(5, userdata.getPassword());
		pst.setString(6, userdata.getConfirmedpassword());
		int noOfRowsEffected = pst.executeUpdate();
		System.out.println(noOfRowsEffected+" rows are effected in instagram database.");
		return "SignUp is Successfull, yayy!!"; 
	}

	public static boolean ValidateUserLogin(String username, String password) throws SQLException {
		Connection connection =DriverManager.getConnection(Constants.DBURL,Constants.DBUSERNAME,Constants.DBPASSWORD);
		PreparedStatement pst=connection.prepareStatement("select count(*) from Instagram where username=? and password=?");
		PreparedStatement pst1 = connection.prepareStatement("Update Instagram set failed_count=failed_count+1 where username=?");
		PreparedStatement pst2 = connection.prepareStatement("select * from instagram where username=?");
		pst.execute("use mydb");
		pst.setString(1, username);
		pst.setString(2, password);
		ResultSet rs=pst.executeQuery();
		pst1.setString(1, username);
		int rowseffected = pst1.executeUpdate();
		pst2.setString(1, username);
		ResultSet rs2 = pst2.executeQuery();
		while(rs2.next()){
			if(rs2.getInt(7)>=Constants.MAX_COUNT) {
				System.out.println("Hi"+rs2.getString(1)+" Your account is blocked for 24 hours, please try again later");
			}
			return true;
		}
		while(rs.next()) {
			int result = rs.getInt(1);
			if(result>0) {
				System.out.println("Hurrah!! Authentication is successful");
				return true;
			}
			return false;
		}
		return false;
	}
}
