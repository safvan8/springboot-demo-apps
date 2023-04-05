package in.ineuron.dependent;

import javax.inject.Named;

@Named("dotNet") // as like @Component
public final class DotNetCourseMaterial implements ICourseMaterial
{
	static
	{
		System.out.println("DotNetCourseMaterial.class file is loading...");
	}

	public DotNetCourseMaterial()
	{
		System.out.println("DotNetCourseMaterial :: Zero param constructor...");
	}

	@Override
	public void getPurchasedMeterial()
	{
		System.out.println("Dotnet course metarails ...here");
	}
}
