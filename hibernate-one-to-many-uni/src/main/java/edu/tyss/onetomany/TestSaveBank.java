package edu.tyss.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveBank {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("bank");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Bank sbi=new Bank();
		sbi.setId(1);
		sbi.setName("SBI");
		sbi.setIfsc("SBI123");
		
		Account ac1=new Account();
		ac1.setId(102);
		ac1.setNumber(98765654);
		ac1.setBalance(50000);
		
		Account ac2=new Account();
		ac2.setId(202);
		ac2.setNumber(98765654);
		ac2.setBalance(60000);
		
		Account ac3=new Account();
		ac3.setId(302);
		ac3.setNumber(98765654);
		ac3.setBalance(70000);
		
		List<Account> accounts=new ArrayList<Account>();
		accounts.add(ac1);
		accounts.add(ac2);
		accounts.add(ac3);
		
		sbi.setAccounts(accounts);
		et.begin();
		em.persist(sbi);
		em.persist(ac1);
		em.persist(ac2);
		em.persist(ac3);
		et.commit();
		System.out.println("RECORD SAVED");
		
	}

}
