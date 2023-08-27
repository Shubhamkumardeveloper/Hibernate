package edu.tyss.companyApp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.tyss.companyApp.model.Company;
import edu.tyss.companyApp.model.Employee;

public class CompanyController {
	
	private static EntityManagerFactory emf=Persistence.createEntityManagerFactory("company");
	private static EntityManager em=emf.createEntityManager();
	private static EntityTransaction et=em.getTransaction();
	
	public  void save()
	{
		Company c=new Company();
		c.setId(101);
		c.setName("tyss");
		c.setGstNo("gst123");
		c.setReg_No("reg123");
		
		Employee e1=new Employee();
		e1.setId(1);
		e1.setName("SHUBHAM KUMAR");
		e1.setEmail("shubu@gmail.com");
		e1.setPassword("shub123");
		e1.setPhoneNumber(8789982015l);
		
		Employee e2=new Employee();
		e2.setId(2);
		e2.setName("sudhanshu");
		e2.setEmail("s@gmail.com");
		e2.setPassword("shub1234");
		e2.setPhoneNumber(8789982016l);
		
		List<Employee> emps=new ArrayList<Employee>();
		emps.add(e1);
		emps.add(e2);
		
		c.setEmployees(emps);
		et.begin();
		em.persist(c);
		em.persist(e1);
		em.persist(e2);
		et.commit();
	}
	
	public  void find()
	{
		Company c=em.find(Company.class, 101);
		System.out.println("======COMPANY======");
		System.out.println("Id:"+c.getId());
		System.out.println("name:"+c.getName());
		System.out.println("email:"+c.getGstNo());
		System.out.println("Reg.no:"+c.getReg_No());
		System.out.println("============");
		List<Employee> emps=c.getEmployees();
		for(Employee e:emps)
		{
			System.out.println("=========Employee:==========");
			System.out.println("ID:"+e.getId());
			System.out.println("Name:"+e.getName());
			System.out.println("Email:"+e.getEmail());
			System.out.println("Password:"+e.getPassword());
			System.out.println("PhoneNumber:"+e.getPhoneNumber());
			System.out.println("============================");
		}
	}
	
	public void update()
	{
		int emp_id=1;
		Company c=em.find(Company.class, 101);
		if(c!=null)
		{
			List<Employee> emps=c.getEmployees();
			for(Employee e:emps)
			{
				if(e.getId()==emp_id)
				{
					e.setPhoneNumber(99999999l);
					et.begin();
					em.merge(e);
					et.commit();
				}
				System.out.println("Updated");
					break;
			}
		}
	}
	
	public void delete()
	{
		Company c=em.find(Company.class, 101);
		if(c!=null)
		{
			c.setName("FIREFLINK");
			et.begin();
			em.remove(c);
			et.commit();
		}
	}
	

}
