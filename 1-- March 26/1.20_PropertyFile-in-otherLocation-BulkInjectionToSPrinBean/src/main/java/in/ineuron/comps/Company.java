package in.ineuron.comps;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("in/ineuron/commons/input.properties")
@ConfigurationProperties(prefix = "org.infy")
public class Company
{
	// bean properties
	private String name;
	private String type;
	private String location;

	// setters are mandatory for injection , otherwise nothing will be injected
	public void setName(String name)
	{
		System.out.println("Company.setName()");
		this.name = name;
	}

	public void setType(String type)
	{
		System.out.println("Company.setType()");
		this.type = type;
	}

	public void setLocation(String location)
	{
		System.out.println("Company.setLocation()");
		this.location = location;
	}

	// setter and constructor for tracing
	static
	{
		System.out.println("Company.class file is loading...........");
	}

	public Company()
	{
		System.out.println("Company Object instantaited....................");
	}

	@Override
	public String toString()
	{
		return "Company [name=" + name + ", type=" + type + ", location=" + location + "]";
	}
}
