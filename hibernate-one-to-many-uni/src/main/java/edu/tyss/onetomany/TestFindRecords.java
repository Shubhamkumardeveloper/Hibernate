package edu.tyss.onetomany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestFindRecords {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("bank");
		EntityManager em=emf.createEntityManager();
		
		Bank bank=em.find(Bank.class,1);
		if(bank!=null)
		{
			System.out.println("========Bank Details.===========");
			System.out.println("Bank Id:"+bank.getId());
			System.out.println("Bank Name:"+bank.getName());
			System.out.println("Bank Ifsc:"+bank.getIfsc());
			List<Account> acount=bank.getAccounts();
			System.out.println("=================================");
			
			for (Account account : acount) 
			{
				System.out.println("========Account Details.===========");
				System.out.println("Id: "+account.getId());
				System.out.println("Number: "+account.getNumber());
				System.out.println("Balance: "+account.getBalance());
				System.out.println("=================================");
			}
			
		}
		else
			System.out.println("BANK RECORD NOT FOUND..");
	}

}
