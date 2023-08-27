package edu.tyss.Person_Passport;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersonController {
	
	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("onetoone");
	private EntityManager em=emf.createEntityManager();
	private EntityTransaction et=em.getTransaction();
	
	public void save()
	{
		Person p=new Person();
		p.setId(1);
		p.setName("Shubham Kumar");
		p.setEmail("Shubu@gmail.com");
		
		Passport ps=new Passport();
		ps.setId(101);
		ps.setNationality("Indian");
		ps.setPassportNumber("Ind123");
		
		p.setPassport(ps);
		et.begin();
		em.persist(p);
		em.persist(ps);
		et.commit();
	}
	
	public void find()
	{
		Person p=em.find(Person.class,1);
		if(p!=null)
		{
			System.out.println("======Person======");
			System.out.println("Id:"+p.getId());
			System.out.println("name:"+p.getName());
			System.out.println("Email:"+p.getEmail());
			
			Passport ps=p.getPassport();
			System.out.println("======passport=====");
			System.out.println("Id:"+ps.getId());
			System.out.println("Number:"+ps.getPassportNumber());
			System.out.println("Nationality:"+ps.getPassportNumber());
			
		}
		else
			System.out.println("Record Not Found..");
	}
	
	public void update()
	{
		Person p=em.find(Person.class,1);
		if(p!=null)
		{
			Passport ps=p.getPassport();
			ps.setNationality("US");
			et.begin();
			em.merge(ps);
			et.commit();
			
		}
		else
			System.out.println("Record Not Found..");
	}
	
	public void delete()
	{
		Person p=em.find(Person.class,1);
		if(p!=null)
		{
		
			et.begin();
			em.remove(p);
			et.commit();
		}
		
	}

}
