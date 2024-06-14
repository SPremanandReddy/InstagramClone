package com.ig;
import java.sql.SQLException;
import java.util.Scanner;

public class InstagramSignUp {
	public static void main(String[] args) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the options\n 1. SignUp\n 2. SignIn");
		int option = sc.nextInt();
		sc.nextLine();
		switch(option) {
		case 1:{
			SignUp(sc);
			break;
		}
		case 2: {
			SignIn(sc);
			break;
		}
		default:{
			System.out.println("It is not valid option, try again");
			break;
		}
			
		}
		
		
	}
	
	public static void SignUp(Scanner sc) throws SQLException {

		System.out.println("Hello, INSTAGRAM has started");
		
		System.out.println("Enter your first Name: ");
		String fname = sc.nextLine();
		
		System.out.println("Enter your last name: ");
		String lname = sc.nextLine();
		
		System.out.println("Enter your email id: ");
		String email = sc.nextLine();
		
		System.out.println("Enter your username: ");
		String username = sc.nextLine();
		
		System.out.println("Enter the password: ");
		String password = sc.nextLine();
		
		
		System.out.println("Enter the confirmed password:");
		String confirmedPassword = sc.nextLine();
		
		if(password.equals(confirmedPassword)) {
			userInstaDetails instaUserData = new userInstaDetails(fname,lname,email,username,password,confirmedPassword);
			//System.out.println("Hey, You entered details well");
			System.out.println(InstaDbUtil.SignUpInstagramUser(instaUserData));
		}else {
			System.out.println("Password and confirmed password both are not same, yayy!!");
		}
		
	}

	public static void SignIn(Scanner sc) throws SQLException{
		System.out.println("Enter the username: ");
		String username = sc.nextLine();
		System.out.println("Enter the password: ");
		String password = sc.nextLine();
		
		boolean isValidate = InstaDbUtil.ValidateUserLogin(username,password);
		if(isValidate) {
			System.out.println("Welcome to Instagram "+username);
		}else {
			System.out.println("Invalid credentials, please try again");
		}
		}
	
}
