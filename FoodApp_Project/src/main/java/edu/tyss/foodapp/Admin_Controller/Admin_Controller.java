package edu.tyss.foodapp.Admin_Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.tyss.foodapp.model.Branch;
import edu.tyss.foodapp.model.Food_Product;
import edu.tyss.foodapp.model.Menu;
import edu.tyss.foodapp.model.User;

public class Admin_Controller {
	
	static EntityManagerFactory emf=Persistence.createEntityManagerFactory("food");
	static EntityManager em=emf.createEntityManager();
	static EntityTransaction et=em.getTransaction();
	static Scanner read=new Scanner(System.in);
	
	public static Food_Product enterFoodProductDetails()
	{
		Food_Product fProduct=new Food_Product();
		read.nextLine();
		System.out.println("Enter food Name:");
		fProduct.setName(read.nextLine());
		System.out.println("Enter food Type:");
		System.out.println("1.VEG\n2.NON_VEG");
		int choice=read.nextInt();
		switch (choice) {
		case 1:
			fProduct.setType("VEG");
			break;
		case 2:
			fProduct.setType("NON_VEG");
			break;
		default:
			break;
		}
		System.out.println("Enter something about Food:");
		read.nextLine();
		fProduct.setAbout(read.nextLine());
		System.out.println("Enter availability");
		System.out.println("1.YES\n2.NO");
		int choice1=read.nextInt();
		switch (choice1) {
		case 1:
			fProduct.setAvailability("YES");
			break;
		case 2:
			fProduct.setAvailability("NO");
			break;
		default:
			break;
		}
		System.out.println("Enter food price:");
		fProduct.setPrice(read.nextDouble());
		
		return fProduct;
	}
	
	public static List<Food_Product> listOfFoodProduct()
	{
		List<Food_Product> fl=new ArrayList<Food_Product>();
		System.out.println("Enter the no of food product");
		int noOfFood=read.nextInt();
		for(int i=0;i<noOfFood;i++)
		{
			Food_Product fp=enterFoodProductDetails();
			fl.add(fp);
		}
		return fl;
//		System.out.println(fl);
		
	}
	
	public static Menu createMenu()
	{
		Menu m=new Menu();
		List<Food_Product> fl=listOfFoodProduct();
		for(Food_Product f:fl)
			f.setMenu(m);
		m.setFood_Products(fl);
		return m;
		
	}
	
	public static Branch createBranch()
	{
		Branch b=new Branch();
		System.out.println("Enter the branch Name:");
		read.nextLine();
		b.setName(read.nextLine());
		System.out.println("Enter the branch Address:");
		b.setAddress(read.nextLine());
		System.out.println("Enter the branch PhoneNumber:");
		b.setPhoneNumber(read.nextLong());
		System.out.println("Enter the branch Email:");
		read.nextLine();
		b.setEmail(read.nextLine());
		return b;
	}
	
	public static List<Branch> listOfBranch()
	{
		List<Branch> bl=new ArrayList<Branch>();
		System.out.println("Enter the numberOfBranch:");
		int noOfBranch=read.nextInt();
		for(int i=0;i<noOfBranch;i++)
		{
			Branch b=createBranch();
			bl.add(b);
		}
		
		return bl;
	}
	public static void saveAdmin()
	{
		User u=new User();
		System.out.println("Enter Admin name:");
		u.setName(read.nextLine());
		System.out.println("Enter Admin Email:");
		u.setEmail(read.nextLine());
		System.out.println("Enter Admin Password:");
		u.setPassword(read.nextLine());
		u.setRole("Admin");
		//menu
		Menu m=createMenu();
		m.setUser(u);
		u.setMenu(m);
		//list of branch
		List<Branch> bl=listOfBranch();
		for(Branch b:bl)
			b.setUser(u);
		u.setBranchs(bl);
		
		et.begin();
		em.persist(u);
		et.commit();
		
	}
	
	public static void main(String[] args) {
//		enterFoodProductDetails();
//		listOfFoodProduct();
		saveAdmin();
	}
	

}
