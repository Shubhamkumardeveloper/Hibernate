package edu.tyss.carapp.view;

import java.util.Scanner;

import edu.tyss.carapp.Controller.CarController;
import edu.tyss.carapp.model.Car;

public class CarView {

	public static Car enterCarData(Scanner read) {
		System.out.println("Enter Car Id:");
		int carId = read.nextInt();
		System.out.println("Enter Car Name:");
		read.nextLine();
		String name = read.nextLine();
		System.out.println("Enter Car company:");
		String company = read.nextLine();
		System.out.println("Enter Car Number:");
		String carNumber = read.nextLine();
		System.out.println("Enter Car Price:");
		long price = read.nextLong();

		Car car = new Car();

		car.setCarId(carId);
		car.setCarName(name);
		car.setCarCompany(company);
		car.setCarNumber(carNumber);
		car.setCarPrice(price);

		return car;
	}
	
	public static void displayResultCar(Car car)
	{
		System.out.println("=================Car Record..=====================");
		System.out.println("Car Id:"+car.getCarId());
		System.out.println("Car Name:"+car.getCarName());
		System.out.println("Car Company:"+car.getCarCompany());
		System.out.println("Car Number:"+car.getCarNumber());
		System.out.println("Car Price:"+car.getCarPrice());
		System.out.println("==================================================");
	}

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		CarController cc = new CarController();
		while (true) {
			System.out.println("Enter choice:");
			System.out.println(
					"1.add car\n2.find car By car Id:\n3.Update car Price By car Id:\n4.Delete car By Car Id:\n5.Exit");
			int choice = read.nextInt();
			switch (choice) {
			case 1:
				Car car = enterCarData(read);
				cc.addCar(car);
				System.out.println("Car added..." + car.getCarCompany());
				break;
			case 2:
				System.out.println("Enter the care Id");
				Car resultCar = cc.findCarByCarId(read.nextInt());
				if(resultCar!=null)
					displayResultCar(resultCar);
				else
					System.out.println("Car Record Not Found..");
				break;
			case 3:
				System.out.println("Enter car Id:");
				int carId=read.nextInt();
				System.out.println("Enter Update Price:");
				int uPrice=read.nextInt();
				boolean b=cc.updateCarById(carId,uPrice);
				if(b)
					System.out.println("Updated..");
				else
					System.out.println("Record Not Found...");
				break;
			case 4:
				System.out.println("Enter Car Id");
				int carid_=read.nextInt();
				boolean b1=cc.deleteCarById(carid_);
				if(b1)
					System.out.println("Car Deleted....");
				else
					System.out.println("Record Not Found...");
				break;
			case 5:
				System.out.println("=====================THANK YOU===================");
				return;
			default:
				System.out.println("WORONG CHOICE..... CHOOSE VALID CHOICE......");
				break;
			}
		}
	}

}
