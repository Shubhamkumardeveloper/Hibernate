package edu.tyss.pancard.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.tyss.pancard.model.Pancard;
import edu.tyss.pancard.model.Person;

public class PersonController {
	
	
		 private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pancard");
		 private static EntityManager em = emf.createEntityManager();
		 private static EntityTransaction et=em.getTransaction();
	

	
	public static void savePerson(Person person,Pancard pancard)
	{
		et.begin();
		em.persist(person);
		em.persist(pancard);
		et.commit();
	}
	
	public Person findPersonById(int p_id)
	{	
		et.begin();
		Person p=em.find(Person.class, p_id);
		et.commit();
		return p;
	}
	
	public boolean updateCarById(int p_id,long phoneNumber) {
		Person person=em.find(Person.class,p_id);
		if (person != null) {
			person.setPhoneNumber(phoneNumber);
			et.begin();
			em.merge(person);
			et.commit();
			return true;
		}
		return false;
	}
	
	public  boolean deleteCarById(int p_id) {
		Person person=em.find(Person.class,p_id);
		//Life Cycle of HiberNate
		if (person!= null) {
			et.begin();
			em.remove(person);
			et.commit();
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		Person p=new Person();
		p.setP_id(105);
		p.setP_name("Shubham kumar");
		p.setPhoneNumber(8789982015l);
		p.setPincode(813209);
		p.setAddress("shermari");
		
		Pancard pan=new Pancard();
		pan.setPancard_id(5);
		pan.setFull_name("shubham");
		pan.setPancard_number("1234sd");
		pan.setPermanent_address("shermari");
		
		p.setPancard(pan);
		
		savePerson(p,pan);
//		Person per=em.find(Person.class, 10);
//		System.out.println(findPersonById(105));
//		updateCarById(104, 987665433);
//		deleteCarById(105);
	}
}
