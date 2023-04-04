package in.ineuron.comps;

import org.springframework.stereotype.Component;

// Dependent class
@Component
public class Account
{
	private String accNo;
	private String branch;
	private String location;

	// setters for injection
	public void setAccNo(String accNo)
	{
		System.out.println("Account.setAccNo()");
		this.accNo = accNo;
	}

	public void setBranch(String branch)
	{
		System.out.println("Account.setBranch()");
		this.branch = branch;
	}

	public void setLocation(String location)
	{
		System.out.println("Account.setLocation()");
		this.location = location;
	}

	public String getAccNo()
	{
		return accNo;
	}

	public String getBranch()
	{
		return branch;
	}

	public String getLocation()
	{
		return location;
	}

	static
	{
		System.out.println("Account.class file is loading.........");
	}

	public Account()
	{
		System.out.println("Account :: zero param constructor");

	}

	@Override
	public String toString()
	{
		return "Account [accNo=" + accNo + ", branch=" + branch + ", Location=" + location + "]";
	}

}
