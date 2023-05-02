package com.tesla.service;

import com.ineuron.dao.StudentDAO;

public class StudentService 
{
	public static void display()
	{
		System.out.println("StudentService disply method called............");
		StudentDAO.display();
	}

}
