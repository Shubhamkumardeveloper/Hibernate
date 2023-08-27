package edu.tyss.State_Country;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StateController {
	
	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("manytoone");
	private EntityManager em=emf.createEntityManager();
	private EntityTransaction et=em.getTransaction();
	
	public void save()
	{
		Country c=new Country(101, "India", "hindi");
		State s1=new State(1, "bihar", "bhojpuri");
		s1.setCountry(c);
		State s2=new State(2, "jharkhand", "hindi");
		s2.setCountry(c);
		State s3=new State(3, "Dehli", "english");
		s3.setCountry(c);
		
		et.begin();
		em.persist(c);
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		et.commit();
		
	}
	
	public void find()
	{
		Country c=em.find(Country.class, 101);
		System.out.println(c);
		
	}

	public void update()
	{
		State s=em.find(State.class, 1);
		s.setLanguage("hindi");
		et.begin();
		em.merge(s);
		et.commit();
	}
	public void delete()
	{
		State s=em.find(State.class, 1);
		et.begin();
		em.remove(s);
		et.commit();
	}
}
