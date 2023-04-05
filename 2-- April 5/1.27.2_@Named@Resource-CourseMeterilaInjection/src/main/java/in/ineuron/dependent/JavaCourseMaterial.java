package in.ineuron.dependent;

import javax.inject.Named;

@Named("java")
public final class JavaCourseMaterial implements ICourseMaterial
{
	static
	{
		System.out.println("JavaCourseMaterial.class file is loading...");
	}

	public JavaCourseMaterial()
	{
		System.out.println("JavaCourseMaterial:: Zero param constructor...");
	}

	@Override
	public void getPurchasedMeterial()
	{
		System.out.println("Java course meterials......here");
	}
}
