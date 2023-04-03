package in.ineuron.comps;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//Target class
@Component
@ConfigurationProperties(prefix = "org.ineuron")
public class Employee
{
	private String name;
	private String salary;

	// HAS-A reference variable
	private Account account;

	// setters for injection
	public void setName(String name)
	{
		System.out.println("Employee.setName()");
		this.name = name;
	}

	public void setSalary(String salary)
	{
		System.out.println("Employee.setSalary()");
		this.salary = salary;
	}

	public void setAccount(Account account)
	{
		System.out.println("Employee.setAccount()");
		this.account = account;
	}

	static
	{
		System.out.println("Employee.class file is loading........");
	}

	public Employee()
	{
		System.out.println("Employee : Zero param constrcutor............");
	}

	@Override
	public String toString()
	{
		return "Employee [name=" + name + ", salary=" + salary + ", account=" + account + "]";
	}
}
