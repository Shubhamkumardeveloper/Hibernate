package edu.tyss.universityapp.view;

import java.util.Scanner;

import edu.tyss.universityapp.controller.UniversityController;
import edu.tyss.universityapp.model.Student;
import edu.tyss.universityapp.model.University;

public class UniversityView {
	
	public University enterUniversityData(Scanner read)
	{
		System.out.println("Enter University id:");
		int uid=read.nextInt();
		System.out.println("Enter University Name:");
		read.nextLine();
		String universityName=read.nextLine();
		System.out.println("Enter University Reg. Number:");
		String universityRegNo=read.nextLine();
		University university=new University(uid, universityName, universityRegNo);
		return university;
	}
	
	public Student enterStudentData(Scanner read)
	{		
		System.out.println("Enter Student Id:");
		int sid=read.nextInt();
		System.out.println("Enter Student Name:");
		read.nextLine();
		String name=read.nextLine();
		System.out.println("Enter Student Address:");
		String address=read.nextLine();
		System.out.println("Enter Student Email:");
		String email=read.nextLine();
		System.out.println("Enter Student PhoneNumber:");
		long phoneNumber=read.nextLong();
		Student student=new Student(sid, name, address, email, phoneNumber);
		return student;
	}
	public static void main(String[] args) {
		UniversityController uController=new UniversityController();
//		uController.save();
//		System.out.println(uController.find(101));
//		System.out.println(uController.update(1000, "ss@gmail.com"));
//		System.out.println(uController.delete(101));
	}

}
