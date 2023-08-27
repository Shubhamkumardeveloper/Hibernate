package edu.tyss.countryApp.View;

import java.util.List;
import java.util.Scanner;

import edu.tyss.countryApp.Controller.CountryController;
import edu.tyss.countryApp.model.Country;
import edu.tyss.countryApp.model.State;

public class CountryView {
	
	public Country enterCounrtyData(Scanner read)
	{
		System.out.println("Enter country id:");
		long id=read.nextLong();
		System.out.println("Enter country Name:");
		read.nextLine();
		String name=read.nextLine();
		System.out.println("Enter Country Code:");
		String countryCode=read.nextLine();
		System.out.println("Enter Country Language:");
		String countryLang=read.nextLine();
		Country country=new Country();
		country.setId(id);
		country.setName(name);
		country.setCountryCode(countryCode);
		country.setCountryLanguage(countryLang);
		return country;
	}
	
	public State enterStateData(Scanner read)
	{
		System.out.println("Enter state id:");
		long id=read.nextLong();
		System.out.println("Enter state name:");
		read.nextLine();
		String name=read.nextLine();
		System.out.println("Enter state code:");
		String stateCode=read.nextLine();
		System.out.println("Enter state language:");
		String stateLang=read.nextLine();
		State state=new State();
		state.setId(id);
		state.setName(name);
		state.setStateCode(stateCode);
		state.setStateLanguage(stateLang);
		return state;
	}
	
	public void displayCountryDetails(Country c)
	{
		System.out.println("==========Country Details:====================");
		System.out.println("Counrty code:"+c.getId());
		System.out.println("Counrty Name:"+c.getName());
		System.out.println("Country Code:"+c.getCountryCode());
		System.out.println("Country Language:"+c.getCountryLanguage());
		System.out.println("==============================================");
		List<State> listOfState=c.getStates();
		for(State s:listOfState)
		{
			System.out.println("===============State Details:===============");
			System.out.println("State Id:"+s.getId());
			System.out.println("State name:"+s.getName());
			System.out.println("State code:"+s.getStateCode());
			System.out.println("State language:"+s.getStateLanguage());
			System.out.println("============================================");
		}
	}
	
	public static void main(String[] args) {
		CountryController cc=new CountryController();
		CountryView cv=new CountryView();
		Scanner sc=new Scanner(System.in);
//		cc.saveCounty();
//		System.out.println("Enter country code to search:");
//		String countryCode=sc.nextLine();
//		Country c=cc.find(countryCode);
//		if(c!=null)
//		{
//			cv.displayCountryDetails(c);
//		}
//		else
//			System.out.println("Counry Not found....");
//		update(String countryCode,String StateCode,String newSateLanguage)
//		System.out.println("Enter country code:");
//		String countryCode=sc.nextLine();
//		System.out.println("Enter state code:");
//		String stateCode=sc.nextLine();
//		System.out.println("Enter new state language code:");
//		String newSateLang=sc.nextLine();
//		cc.update(countryCode, stateCode,newSateLang);
//		delete(String countryCode,String StateCode)
		System.out.println("Enter countryCode:");
		String countryCode=sc.nextLine();
		System.out.println("Enter state Code:");
		String stateCode=sc.nextLine();
		cc.delete(countryCode, stateCode);
	}

}
