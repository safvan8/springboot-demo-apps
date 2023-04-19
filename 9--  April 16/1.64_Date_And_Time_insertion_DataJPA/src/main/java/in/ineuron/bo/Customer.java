package in.ineuron.bo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Customer
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cid;
	private String cadderss;
	private String cname;

	// date and Time insertion
	private LocalDateTime dob;

	private LocalDate doj;

	private LocalTime joiningTime;

	public Customer()
	{
		System.out.println("Customer zero arg constrcutor used internally.......");
	}

	public Customer(String cadderss, String cname, LocalDateTime dob, LocalDate doj, LocalTime joiningTime)
	{

		this.cadderss = cadderss;
		this.cname = cname;
		this.dob = dob;
		this.doj = doj;
		this.joiningTime = joiningTime;
	}

	public Integer getCid()
	{
		return cid;
	}

	public void setCid(Integer cid)
	{
		this.cid = cid;
	}

	public String getCadderss()
	{
		return cadderss;
	}

	public void setCadderss(String cadderss)
	{
		this.cadderss = cadderss;
	}

	public String getCname()
	{
		return cname;
	}

	public void setCname(String cname)
	{
		this.cname = cname;
	}

	public LocalDateTime getDob()
	{
		return dob;
	}

	public void setDob(LocalDateTime dob)
	{
		this.dob = dob;
	}

	public LocalDate getDoj()
	{
		return doj;
	}

	public void setDoj(LocalDate doj)
	{
		this.doj = doj;
	}

	public LocalTime getJoiningTime()
	{
		return joiningTime;
	}

	public void setJoiningTime(LocalTime joiningTime)
	{
		this.joiningTime = joiningTime;
	}

	@Override
	public String toString()
	{
		return "Customer [cid=" + cid + ", cadderss=" + cadderss + ", cname=" + cname + ", dob=" + dob + ", doj=" + doj
				+ ", joiningTime=" + joiningTime + "]";
	}

}
