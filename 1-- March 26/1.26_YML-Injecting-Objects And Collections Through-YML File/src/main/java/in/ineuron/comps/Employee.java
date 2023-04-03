package in.ineuron.comps;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//Target class
@Component
@ConfigurationProperties(prefix = "emp.info")
public class Employee
{
	private String name;
	private String salary;

	// HAS - A variable -dependent object 
	private Account account;
	
	// array of String objects
	private String skillSet[];
	// List of String Objects
	private List<String> projectNames;
	// Set of String Objects
	private Set<String> mobileNumbers;
	// Map
	private Map<String, Object> idDetails;

	public void setName(String name)
	{
		this.name = name;
	}

	public void setSalary(String salary)
	{
		this.salary = salary;
	}

	
	public void setAccount(Account account)
	{
		this.account = account;
	}

	public void setSkillSet(String[] skillSet)
	{
		this.skillSet = skillSet;
	}

	public void setProjectNames(List<String> projectNames)
	{
		this.projectNames = projectNames;
	}

	public void setMobileNumbers(Set<String> mobileNumbers)
	{
		this.mobileNumbers = mobileNumbers;
	}

	public void setIdDetails(Map<String, Object> idDetails)
	{
		this.idDetails = idDetails;
	}

	// Constructor and static block for tracing
	static
	{
		System.out.println("Employee.class file is loading........");
	}

	public Employee()
	{
		System.out.println("Employee : Zero param constrcutor............");
	}

	// to display all employee details
	public void displayEmplDetails()
	{
		System.out.println("Employee name: " + name);
		System.out.println("Employee Salary: " + salary);
		System.out.println("---------------------------------------");
		System.out.println("Account num:"+account.getAccNo());
		System.out.println("Account branch: "+account.getBranch());
		System.out.println("Account location:"+account.getLocation());
		System.out.println("---------------------------------------");
		
		
		System.out.println("Employee Skills: " + Arrays.toString(skillSet));
		System.out.println("Employee Project Names: " + projectNames);
		System.out.println("Employee Mob.Numbers: " + mobileNumbers);
		System.out.println("Employee ID Details: " + idDetails);
	}

}
