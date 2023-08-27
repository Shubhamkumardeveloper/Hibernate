package edu.tyss.pancard.view;

import java.util.Scanner;

import edu.tyss.pancard.controller.PersonController;
import edu.tyss.pancard.model.Pancard;
import edu.tyss.pancard.model.Person;

public class Person_Pancard_View {
	public Person eneterDataForPerson(Scanner read)
	{
		System.out.println("Enter Person Id");
		int person_Id=read.nextInt();
		System.out.println("Enter Person name:");
		read.nextLine();
		String person_name=read.nextLine();
		System.out.println("Enter person Address:");
		String address=read.nextLine();
		System.out.println("Enter person Phone Number:");
		long phoneNumber=read.nextLong();
		System.out.println("Enter Pincode:");
		long pincode=read.nextLong();
		Person person=new Person();
		person.setP_id(person_Id);
		person.setP_name(person_name);
		person.setAddress(address);
		person.setPhoneNumber(phoneNumber);
		person.setPincode(pincode);
		return person;
	}
	
	public Pancard enterDataForPancard(Scanner read)
	{
		System.out.println("Enter pancard id:");
		int pancardId=read.nextInt();
		System.out.println("Enter pancard Number:");
		read.nextLine();
		String pancardNumber=read.nextLine();
		System.out.println("Enter full name:");
		String full_name=read.nextLine();
		System.out.println("Enter Permanent Address:");
		String permanentAdd=read.nextLine();
		Pancard pancard=new Pancard();
		pancard.setPancard_id(pancardId);
		pancard.setPancard_number(pancardNumber);
		pancard.setFull_name(full_name);
		pancard.setPermanent_address(permanentAdd);
		return pancard;
	}
	public void displayPersonPancard(Person p)
	{
		System.out.println("===============");
		System.out.println("Id:"+p.getP_id());
		System.out.println("Name:"+p.getP_name());
		System.out.println("Address:"+p.getAddress());
		System.out.println("Phone Number:"+p.getPhoneNumber());
		System.out.println("Pincode:"+p.getPincode());
		System.out.println("================");
		Pancard pancard=p.getPancard();
			System.out.println("=====================");
			System.out.println("Id:"+pancard.getPancard_id());
			System.out.println("pan no:"+pancard.getPancard_number());
			System.out.println("full name:"+pancard.getFull_name());
			System.out.println("Permanent Add:"+pancard.getPermanent_address());
			System.out.println("=====================");
	}
	
	public static void main(String[] args) {
		Scanner read=new Scanner(System.in);
		PersonController pController=new PersonController();
		Person_Pancard_View pView=new Person_Pancard_View();
		while(true)
		{
			System.out.println("Enter the choice:");
			System.out.println("1.save\n2.find\n3.update\n4.delete\n5.exit\n");
			int choice=read.nextInt();
			switch (choice) {
			case 1:
				Person person=pView.eneterDataForPerson(read);
				Pancard pancard=pView.enterDataForPancard(read);
				person.setPancard(pancard);
				pController.savePerson(person,pancard);
				System.out.println("Data inserted..");
				break;
			case 2:
				System.out.println("Enter Person id:");
				int pid=read.nextInt();
				Person p=pController.findPersonById(pid);
//				System.out.println(p);
				if(p!=null)
					pView.displayPersonPancard(p);
				else
					System.out.println("Record Not Found");
				
				break;
			case 3:
				System.out.println("Enter pid:");
				int p_id=read.nextInt();
				System.out.println("Enter phone Number");
				long phoneNumber=read.nextLong();
				boolean b=pController.updateCarById(p_id,phoneNumber);
				if(b)
					System.out.println("Record Updated..");
				else
					System.out.println("Record Not found");
				break;
			case 4:
				System.out.println("Enter Person Id:");
				int p__id=read.nextInt();
				boolean b1=pController.deleteCarById(p__id);
				if(b1)
					System.out.println("Record Deleted..");
				else
					System.out.println("Record Not found");
				break;
			case 5:
				System.out.println("Thank you..");
				return;

			default:
				break;
			}
		}
		
	
	}

}
