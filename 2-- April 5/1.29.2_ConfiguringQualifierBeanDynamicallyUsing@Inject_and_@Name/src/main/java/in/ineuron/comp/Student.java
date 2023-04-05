package in.ineuron.comp;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.ImportResource;

import in.ineuron.dependent.ICourseMaterial;

@Named("std")
@ImportResource("in/ineuron/cfg/applicationContext.xml") // importing XML
public class Student
{
	// field,constructor, setter level injection is possible
	@Inject
	@Named("CourseIdAlias") // passing alias name from XML
	private ICourseMaterial material;

	// getter for displaying injected course
	public ICourseMaterial getMaterial()
	{
		return material;
	}

	static
	{
		System.out.println("Student.class file is loading...");
	}

	public Student()
	{
		System.out.println("Student Object is instantiated...");
	}

}
