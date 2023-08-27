package edu.tyss.collegeApp.View;

import java.util.Scanner;

public class CarView {
	public static void main(String[] args) {
		Scanner read=new Scanner(System.in);
		while(true)
		{
			System.out.println("Enter choice:");
			System.out.println("1.add car\n2.find car By car Id:\n3.Update car Price By car Id:\n4.Delete car By Car Id:\n5.Exit");
			int choice=read.nextInt();
			switch (choice) {
			case 1:
				System.out.println(choice);
				break;
			case 2:
				System.out.println(choice);
				break;
			case 3:
				System.out.println(choice);
				break;
			case 4:
				System.out.println(choice);
				break;
			case 5:
				System.out.println(choice);
				return;
			default:
				break;
			}
		}
	}

}
