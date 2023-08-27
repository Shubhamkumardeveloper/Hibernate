package edu.tyss.foodapp.View;

import java.util.Scanner;

import edu.tyss.foodapp.model.User;

public class FoodAppView {
	static Scanner read=new Scanner(System.in);
	
	public  User enterUserDetails()
	{
		System.out.println("Enter User Name:");
		String name=read.nextLine();
		System.out.println("Enter User Email:");
		String email=read.nextLine();
		System.out.println("Enter User password:");
		String password=read.nextLine();
		System.out.println("Enter User role:");
		String role=read.nextLine();
		
		User user=new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setRole(role);
		
		return user;
	}
}
