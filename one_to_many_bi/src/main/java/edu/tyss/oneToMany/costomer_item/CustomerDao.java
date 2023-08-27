package edu.tyss.oneToMany.costomer_item;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class CustomerDao {
	
	 private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("costom");
	 private static EntityManager em = emf.createEntityManager();
	 private static EntityTransaction et=em.getTransaction();
	 
	 public void save()
	 {
		 Customer c=new Customer();
		 c.setId(1);
		 c.setName("shubham kumar");
		 c.setAddress("shermari");
		 
		 Item i1=new Item();
		 i1.setId(101);
		 i1.setName("TV");
		 i1.setMrp(2000);
		 i1.setCustomer(c);
		 
		 Item i2=new Item();
		 i2.setId(102);
		 i2.setName("AC");
		 i2.setMrp(35000);
		 i2.setCustomer(c);
		 
		 Item i3=new Item();
		 i3.setId(103);
		 i3.setName("Washing mchine");
		 i3.setMrp(40000);
		 i3.setCustomer(c);
		 
		 List<Item> items=Arrays.asList(i1,i2,i3);
		 et.begin();
		 em.persist(c);
		 em.persist(i1);
		 em.persist(i2);
		 em.persist(i3);
		 et.commit();
	 }
	 
	 public void find()
	 {
		 Customer c=em.find(Customer.class,1);
		 if(c!=null)
		 {
			 System.out.println("====customer=====");
			 System.out.println("Id:"+c.getId());
			 System.out.println("Name:"+c.getName());
			 System.out.println("Address:"+c.getAddress());
			 
			 List<Item> items=c.getItems();
			 for(Item i:items)
			 {
				 System.out.println("=======items:======");
				 System.out.println("id:"+i.getId());
				 System.out.println("name:"+i.getName());
				 System.out.println("MRP:"+i.getMrp());
			 }
		 }
	 }
	 
	 public void update()
	 {
		 Item i=em.find(Item.class,101);
		 if(i!=null)
		 {
			 Customer c=i.getCustomer();
			 c.setAddress("Bangalore");
			 et.begin();
			 em.merge(c);
			 et.commit();
		 }
		 
	 }
	 
	 public void delete()
	 {
		 Customer c=em.find(Customer.class, 1);
		 
		 List<Item> items=c.getItems();
		 Iterator<Item> i=items.iterator();
		 while(i.hasNext())
		 {
			 Item it=i.next();
			 if(it.getId()==103)
			 {
				 i.remove();
				 et.begin();
				 em.remove(it);
				 et.commit();
			 }
		 }
		 
	 }

}
