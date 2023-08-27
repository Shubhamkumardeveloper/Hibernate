package edu.tyss.countryApp.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.tyss.countryApp.View.CountryView;
import edu.tyss.countryApp.model.Country;
import edu.tyss.countryApp.model.State;

public class CountryController {
	
	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("country");
	private EntityManager em=emf.createEntityManager();
	private EntityTransaction et=em.getTransaction();
	
	Scanner read=new Scanner(System.in);
	CountryView cv=new CountryView();
	
	public void saveCounty()
	{
		Country country=cv.enterCounrtyData(read);
		State state1=cv.enterStateData(read);
		State state2=cv.enterStateData(read);
//		State state3=cv.enterStateData(read);
		List<State> states=new ArrayList<State>();
		states.add(state1);
		states.add(state2);
//		states.add(state3);
		country.setStates(states);
		et.begin();
		em.persist(country);
		em.persist(state1);
		em.persist(state2);
//		em.persist(state3);
		et.commit();
	}
	
	public Country find(String countryCode)
	{
		Country country=em.find(Country.class,countryCode);
		if(country!=null)
		{
			return country;
		}
		return null;
	}
	
	public void update(String countryCode,String StateCode,String newSateLanguage)
	{
		Country country=em.find(Country.class,countryCode);
		if(country!=null)
		{
			List<State> listOfState=country.getStates();
			for(State s:listOfState)
			{
				if(s.getStateCode().equalsIgnoreCase(StateCode))
				{
					s.setStateLanguage(newSateLanguage);
					et.begin();
					em.merge(s);
					et.commit();
				}
			}
		}
	}
	
	public void delete(String countryCode,String StateCode)
	{
		Country country=em.find(Country.class,countryCode);
		if(country!=null)
		{
			List<State> listOfState=country.getStates();
			Iterator<State> i=listOfState.iterator();
			while(i.hasNext())
			{
				State s=i.next();
				if(s.getStateCode().equalsIgnoreCase(StateCode))
				{
					i.remove();
					et.begin();
					em.remove(s);
					et.commit();
				}
			}
		}
		
	}

}
