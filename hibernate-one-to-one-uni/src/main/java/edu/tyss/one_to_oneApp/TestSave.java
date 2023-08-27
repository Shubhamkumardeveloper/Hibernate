package edu.tyss.one_to_oneApp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSave {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("one");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		//create an object for car
		Car car=new Car();
		car.setId(5);
		car.setName("MAHENDRA");
		car.setCost(20000);
		
		//create engine Object
		
		Engine engine=new Engine();
		engine.setId(105);
		engine.setName("K3");
		engine.setCc(14555);
		
		car.setEngine(engine);
		
		et.begin();
		
		em.persist(car);
		em.persist(engine);
		
		et.commit();
		System.out.println("Inserted..");
		
	}

}
