package in.ineuron.dependent;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//Dependent Class
@Component("item")
public class ItemsInfo
{
	// Injecting values from properties file
	@Value("${restaurant.info.idlyPrice}")
	public float idlyPrice;

	@Value("${restaurant.info.dosaPrice}")
	public float dosaPrice;

	@Value("${restaurant.info.vadaPrice}")
	public float vadaPrice;

	@Override
	public String toString()
	{
		return "ItemsInfo [idlyPrice=" + idlyPrice
			+ ", dosaPrice=" + dosaPrice + ", vadaPrice=" + vadaPrice + "]";
	}
}
