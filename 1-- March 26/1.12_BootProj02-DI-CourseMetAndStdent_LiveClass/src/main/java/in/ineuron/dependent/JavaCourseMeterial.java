package in.ineuron.dependent;

import org.springframework.stereotype.Component;

@Component("java")
public class JavaCourseMeterial implements ICourseMeterial
{
	@Override
	public void getCourseDetails()
	{
		System.out.println("Learning java");
		System.out.println("java is Powerfull and Simple.......");
		System.out.println("Java is platform dependent");
	}
	
	// static block and Constructor
	static
	{
		System.out.println("JavaCourseMeterial.class file is loading");
	}

	public JavaCourseMeterial()
	{
		System.out.println("JavaCourseMeterial :: Zero paaram constructor");
	}

}
