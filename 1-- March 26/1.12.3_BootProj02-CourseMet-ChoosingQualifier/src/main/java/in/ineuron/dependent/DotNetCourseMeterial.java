package in.ineuron.dependent;

import org.springframework.stereotype.Component;

@Component("net")
public class DotNetCourseMeterial implements ICourseMeterial
{
	@Override
	public void getCourseDetails()
	{
		System.out.println("Dot net course meterials......here");
	}
	
	// static block and Constructor
	static
	{
		System.out.println("DotNetCourseMeterial.class file is loading");
	}

	public DotNetCourseMeterial()
	{
		System.out.println("DotNetCourseMeterial :: Zero paaram constructor");
	}

}
