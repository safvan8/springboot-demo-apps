package in.ineuron.bo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table
public class MarriageSeeker implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String address;

	@Lob
	private byte[] photo;

	private LocalDateTime dob;

	@Lob
	private char[] bioData;

	private Boolean indian;

	public MarriageSeeker()
	{

	}

	public MarriageSeeker(String name, String address, byte[] photo, LocalDateTime dob, char[] bioData, Boolean indian)
	{
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.photo = photo;
		this.dob = dob;
		this.bioData = bioData;
		this.indian = indian;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public byte[] getPhoto()
	{
		return photo;
	}

	public void setPhoto(byte[] photo)
	{
		this.photo = photo;
	}

	public LocalDateTime getDob()
	{
		return dob;
	}

	public void setDob(LocalDateTime dob)
	{
		this.dob = dob;
	}

	public char[] getBioData()
	{
		return bioData;
	}

	public void setBioData(char[] bioData)
	{
		this.bioData = bioData;
	}

	public Boolean getIndian()
	{
		return indian;
	}

	public void setIndian(Boolean indian)
	{
		this.indian = indian;
	}

	@Override
	public String toString()
	{
		return "MarriageSeeker [id=" + id + ", name=" + name + ", address=" + address + ", photo="
				+ Arrays.toString(photo) + ", dob=" + dob + ", bioData=" + Arrays.toString(bioData) + ", indian="
				+ indian + "]";
	}

}
