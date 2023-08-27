package edu.tyss.Counrty_States;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.w3c.dom.ls.LSInput;


public class CountryController {
	
	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("onetomany");
	private EntityManager em=emf.createEntityManager();
	private EntityTransaction et=em.getTransaction();
	
	public void saveCounty()
	{
		Country c=new Country();
		c.setId(1);
		c.setName("India");
		c.setCountryCode("+91");
		c.setCountryLanguage("Hindi");
		
		State s1=new State();
		s1.setId(101);
		s1.setName("Bihar");
		s1.setStateCode("1001");
		s1.setStateLanguage("Hindi");
		
		State s2=new State();
		s2.setId(102);
		s2.setName("UP");
		s2.setStateCode("1002");
		s2.setStateLanguage("Bhojpuri");
		List<State> states=new ArrayList<State>();
		
		states.add(s1);
		states.add(s2);

		c.setStates(states);
		et.begin();
		em.persist(c);
		em.persist(s1);
		em.persist(s2);
		et.commit();
	}
	
	public void find()
	{
		Country c=em.find(Country.class,"+91");
		if(c!=null)
		{
			System.out.println(c);
			List<State> states=c.getStates();
			for(State s:states)
				System.out.println(s);
		}
		else
			System.out.println("Record Not Found");
	}
	
	public void update()
	{
		Country c=em.find(Country.class,"+91");
		if(c!=null)
		{
			c.setCountryLanguage("English");
			et.begin();
			em.merge(c);
			et.commit();
			
		}
		else
			System.out.println("Record Not Found");
	}
	
	public void delete()
	{
		Country c=em.find(Country.class,"+91");
		if(c!=null)
		{
			List<State> s=c.getStates();
			Iterator<State> i=s.iterator();
			while(i.hasNext())
			{
				State s1=i.next();
				if(s1.getStateCode().equalsIgnoreCase("1002"))
				{
					i.remove();
					et.begin();
					em.remove(s1);
					et.commit();
				}
			}
			
		}
	}
	
}
