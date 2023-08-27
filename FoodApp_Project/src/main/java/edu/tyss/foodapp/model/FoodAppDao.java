package edu.tyss.foodapp.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.text.html.HTMLDocument.Iterator;

public class FoodAppDao {
	
	private  EntityManagerFactory emf=Persistence.createEntityManagerFactory("food");
	private  EntityManager em=emf.createEntityManager();
	private  EntityTransaction et=em.getTransaction();

	public  void saveUser()
	{
		User u=new User();
		u.setName("shubham kumar");
		u.setEmail("s@gmail.com");
		u.setPassword("1234");
		u.setRole("Manager");
		
		User u1=new User();
		u1.setName("suhani kumar");
		u1.setEmail("s@gmail.com");
		u1.setPassword("1234");
		u1.setRole("staff");
//		
//		User u2=new User();
//		u2.setName("Anjesh kumar");
//		u2.setEmail("s@gmail.com");
//		u2.setPassword("1234");
//		u2.setRole("staff");
		
		Menu m=new Menu();
		
		Food_Product f1=new Food_Product();
		f1.setName("RICE");
		f1.setType("VEG");
		f1.setAbout("kdhf");
		f1.setAvailability("Yes");
		f1.setPrice(100);
		f1.setMenu(m);
		
		Food_Product f2=new Food_Product();
		f2.setName("Dal");
		f2.setType("VEG");
		f2.setAbout("kdhf");
		f2.setAvailability("Yes");
		f2.setPrice(100);
		f2.setMenu(m);
		
		List<Food_Product> fp=Arrays.asList(f1,f2);
		m.setFood_Products(fp);
		m.setUser(u);
		u.setMenu(m);
		//branch
		Branch b1=new Branch();
		b1.setName("BTM Branch");
		b1.setAddress("BTM layout");
		b1.setPhoneNumber(8789982015l);
		b1.setEmail("btm@gmail.com");
		b1.setUser(u);
		
		Branch b2=new Branch();
		b2.setName("BTM Branch");
		b2.setAddress("BTM layout");
		b2.setPhoneNumber(8789982015l);
		b2.setEmail("btm@gmail.com");
		b2.setUser(u);
		
		List<Branch> bl=Arrays.asList(b1,b2);
		u.setBranchs(bl);
		
		//foodorder
		Food_Order fo=new Food_Order();
		fo.setStatus("Ready");
		fo.setTotalPrice(1000);
		fo.setCustomerName("Shubham kumar");
		fo.setContactNumber(878987728l);
		fo.setUser(u1);
		
		Food_Order fo1=new Food_Order();
		fo1.setStatus("Ready");
		fo1.setTotalPrice(1000);
		fo1.setCustomerName("sudhanshu kumar");
		fo1.setContactNumber(878987728l);
		fo1.setUser(u1);
		
		List<Food_Order> fl=Arrays.asList(fo,fo1);
		u.setFood_Orders(fl);
		
		Item i=new Item();
		i.setPoductId(101);
		i.setName("Special Item");
		i.setType(" VEG");
		i.setQuantity(2);
		i.setPrice(200);
		i.setFood_Order(fo);
		
		Item i1=new Item();
		i1.setPoductId(101);
		i1.setName("Special Item");
		i1.setType("NON VEG");
		i1.setQuantity(2);
		i1.setPrice(200);
		i1.setFood_Order(fo1);
		
		et.begin();
		em.persist(u);
		em.persist(i);
		em.persist(i1);
		et.commit();
	}
	
	public void findUser()
	{
		User u=em.find(User.class,2);
		if(u!=null)
		{
			System.out.println("======================User:==========================");
			System.out.println("Id:"+u.getId());
			System.out.println("Name:"+u.getName());
			System.out.println("Email:"+u.getEmail());
			System.out.println("Role:"+u.getRole());
			System.out.println("=======================================================");
			System.out.println("======================User:==========================");
			List<Food_Order> f=u.getFood_Orders();
			for(Food_Order fo :f)
			{
				System.out.println("======================Food Order:==========================");
				System.out.println("Id:"+fo.getId());
				System.out.println("Status:"+fo.getStatus());
				System.out.println("TotalPrice:"+fo.getTotalPrice());
				System.out.println("OrderCreatedTime:"+fo.getOrderCreatedTime());
				System.out.println("OrderDeliveryTime:"+fo.getOrderDeliverTime());
				System.out.println("CustomerName:"+fo.getCustomerName());
				System.out.println("ContactNumber:"+fo.getContactNumber());
				System.out.println("=======================================================");
			}
		}
	}
	
	public void update()
	{
		User u=em.find(User.class,2);
		if(u!=null)
		{
			u.setRole("Manager");
			et.begin();
			em.merge(u);
			et.commit();
		}
	}
	
	public void delete()
	{
		User u=em.find(User.class,2);
		if(u!=null)
		{
			List<Food_Order> f=u.getFood_Orders();
			java.util.Iterator<Food_Order> i=f.iterator();
			while(i.hasNext())
			{
				Food_Order f1=i.next();
				if(f1.getStatus().equalsIgnoreCase("NotReady"))
				{
					i.remove();
					et.begin();
					em.remove(f1);
					et.commit();
				}
			}
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		FoodAppDao fdao=new FoodAppDao();
//		fdao.saveUser();
//		fdao.findUser();
//		fdao.update();
//		fdao.delete();
	}

}
