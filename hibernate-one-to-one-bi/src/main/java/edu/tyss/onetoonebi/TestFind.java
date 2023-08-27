package edu.tyss.onetoonebi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestFind {
	
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("onetoonebi");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Engine e=em.find(Engine.class, 101);
		if(e!=null)
		{
			System.out.println("===============Engine=========");
			System.out.println("Engine Id:"+e.getId());
			System.out.println("Engine Name:"+e.getType());
			System.out.println("Engine CC:"+e.getCc());
			
			Car c=e.getCar();
			System.out.println("=======CAR=======");
			System.out.println("ID:"+c.getId());
			System.out.println("Name:"+c.getName());
			System.out.println("Cost:"+c.getCost());
		}
	}

}
