package edu.tyss.one_to_oneApp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestFind {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("one");
		EntityManager em=emf.createEntityManager();
		
		Car car=em.find(Car.class,4);
		System.out.println("===================");
		System.out.println("Id:"+car.getId());
		System.out.println("Name:"+car.getName());
		System.out.println("Cost:"+car.getCost());
		
		Engine engine=car.getEngine();
		System.out.println("=============");
		System.out.println("id:"+engine.getId());
		System.out.println("Type:"+engine.getName());
		System.out.println("cc:"+engine.getCc());
	}

}
