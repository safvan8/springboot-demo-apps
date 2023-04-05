package in.ineuron.comp;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import in.ineuron.dependent.ICourseMaterial;

@Named("std")
public class Student
{
	// field,setter,constructor level injection is possible
	// but we need to write annotation on setter and constructor for that
	@Autowired
	@Qualifier("dotNet")
	private ICourseMaterial material;

	public void setMaterial(ICourseMaterial material)
	{
		System.out.println("Setter injection-----");
		this.material = material;
	}

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
