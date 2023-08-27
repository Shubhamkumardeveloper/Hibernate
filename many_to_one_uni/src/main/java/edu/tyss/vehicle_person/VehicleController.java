package edu.tyss.vehicle_person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



public class VehicleController {
	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("manytoone");
	private EntityManager em=emf.createEntityManager();
	private EntityTransaction et=em.getTransaction();
	
	public void save()
	{
		Person p=new Person(101,"Shubham");
		Vehicle v1=new Vehicle(1001, "car","Bh123", p);
		Vehicle v2=new Vehicle(1002, "bike","Bh1234", p);
		
		
		et.begin();
		em.persist(p);
		em.persist(v2);
		em.persist(v2);
		et.commit();
		
	}
	
	public void find()
	{
		Vehicle v=em.find(Vehicle.class, 1001);
		System.out.println(v);
		
	}

	public void update()
	{
		Vehicle v=em.find(Vehicle.class, 1001);
		v.setNumber("11111");
		et.begin();
		em.merge(v);
		et.commit();
	}
	public void delete()
	{
		Vehicle v=em.find(Vehicle.class, 1001);
		et.begin();
		em.remove(v);
		et.commit();
	}
	

}
