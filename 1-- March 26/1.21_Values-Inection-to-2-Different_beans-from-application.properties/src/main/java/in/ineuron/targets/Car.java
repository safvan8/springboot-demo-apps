package in.ineuron.targets;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "com.car")
public class Car
{
	private String company;
	private String type;

	// setters for injection
	public void setCompany(String company)
	{
		this.company = company;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	// constructor and static block
	static
	{
		System.out.println("Car.class loadig..........");
	}

	public Car()
	{
		System.out.println("Car: Zero  arg constrcutor");
	}

	@Override
	public String toString()
	{
		return "Car [company=" + company + ", type=" + type + "]";
	}
}
