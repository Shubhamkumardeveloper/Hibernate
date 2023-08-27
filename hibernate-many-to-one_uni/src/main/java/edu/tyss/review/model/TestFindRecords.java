package edu.tyss.review.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestFindRecords {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("manyToOne");
		EntityManager em=emf.createEntityManager();
		
		Review r=em.find(Review.class,1);
		if(r!=null)
		{
			System.out.println("==========Review:============");
			System.out.println("Id:"+r.getId());
			System.out.println("Message"+r.getMessage());
			System.out.println("Heading"+r.getHeading());
			System.out.println("==============================");
			Product p= r.getProduct();
			System.out.println("============Product=============");
			System.out.println("Id:"+p.getId());
			System.out.println("Name:"+p.getName());
			System.out.println("Cost:"+p.getCost());
			System.out.println("================================");
		}
		else
			System.out.println("Record not found...");
		
	}

}
