package edu.tyss.foodapp.Staff_controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.tyss.foodapp.model.Food_Order;
import edu.tyss.foodapp.model.User;

public class Staff_Controller {
	
	static EntityManagerFactory emf=Persistence.createEntityManagerFactory("food");
	static EntityManager em=emf.createEntityManager();
	static EntityTransaction et=em.getTransaction();
	static Scanner read=new Scanner(System.in);
	
	public static Food_Order createFoodOrder()
	{
		Food_Order fo=new Food_Order();
		System.out.println("Enter the food status:");
		read.nextLine();
		fo.setStatus(read.nextLine());
		System.out.println("Enter total Food Order Price:");
		fo.setTotalPrice(read.nextDouble());
		System.out.println("Enter customer Name:");
		read.nextLine();
		fo.setCustomerName(read.nextLine());
		System.out.println("Enter Conatact Number:");
		fo.setContactNumber(read.nextLong());
		
		return fo;
	}
	
	public static List<Food_Order> listOfFoodOrder()
	{
		List<Food_Order> fl=new ArrayList<Food_Order>();
		System.out.println("enter the noOfFoodOrder:");
		int noOfFoodOrder=read.nextInt();
		for(int i=0;i<noOfFoodOrder;i++)
		{
			Food_Order f=createFoodOrder();
			fl.add(f);
		}
		return fl;
	}
	
	public static void saveStaff()
	{
		//staff Details...
		User u=new User();
		System.out.println("Enter Staff name:");
		u.setName(read.nextLine());
		System.out.println("Enter Staff Email:");
		u.setEmail(read.nextLine());
		System.out.println("Enter staff Password:");
		u.setPassword(read.nextLine());
		u.setRole("Staff");
		
		List<Food_Order> fl=listOfFoodOrder();
		for(Food_Order f:fl)
			f.setUser(u);
		
		u.setFood_Orders(fl);
		
		et.begin();
		em.persist(u);
		et.commit();
	}
	
	public static void main(String[] args) {
		saveStaff();
	}

}
