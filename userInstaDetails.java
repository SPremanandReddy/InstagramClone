package com.ig;

public class userInstaDetails {
	private static String fname;
	private static String lname;
	private static String emailid;
	private static String username;
	private static String password;
	private static String confirmedpassword;
	
	public static String getFname() {
		return fname;
	}
	public static void setFname(String fname) {
		userInstaDetails.fname = fname;
	}
	public static String getLname() {
		return lname;
	}
	public static void setLname(String lname) {
		userInstaDetails.lname = lname;
	}
	public static String getEmailid() {
		return emailid;
	}
	public static void setEmailid(String emailid) {
		userInstaDetails.emailid = emailid;
	}
	public static String getUsername() {
		return username;
	}
	public static void setUsername(String username) {
		userInstaDetails.username = username;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		userInstaDetails.password = password;
	}
	public static String getConfirmedpassword() {
		return confirmedpassword;
	}
	public static void setConfirmedpassword(String confirmedpassword) {
		userInstaDetails.confirmedpassword = confirmedpassword;
	}
	public userInstaDetails() {
	}
	public userInstaDetails(String fname, String lname, String email, String username, String password, String confirmedPassword) {
		this.fname = fname;
		this.lname = lname;
		this.emailid = email;
		this.username = lname;
		this.password = password;
		this.confirmedpassword  = confirmedPassword;
		//System.out.println("User Details has been created");
	}
	
}
