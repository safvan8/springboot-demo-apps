package in.ineuron.targets;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "com.bike")
public class Bike
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
		System.out.println("Bike.class loading..........");
	}

	public Bike()
	{
		System.out.println("Bike: Zero  arg constrcutor");
	}

	@Override
	public String toString()
	{
		return "Bike [company=" + company + ", type=" + type + "]";
	}
}
