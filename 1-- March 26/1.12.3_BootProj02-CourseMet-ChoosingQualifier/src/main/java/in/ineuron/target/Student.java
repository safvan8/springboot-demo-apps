package in.ineuron.target;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

import in.ineuron.dependent.ICourseMeterial;

//Target class
@Component("tr")

// importing the xml file 
@ImportResource(value = "in/ineuron/cfg/applicationContext.xml")
public class Student
{
	// HAS-A variable
	@Autowired
	@Qualifier("courseAlias") // passing alias name as qualifier
	private ICourseMeterial courseMeterial;

	// checking which object is injected by printing
	public void displayMeterial()
	{
		System.out.println("Student class displayMeterial() method called.............");
		courseMeterial.getCourseDetails();
	}

	// static block and Constructor
	static
	{
		System.out.println("Student.class file is loading");
	}

	public Student()
	{
		System.out.println("Student :: Zero paaram constructor");
	}
}
