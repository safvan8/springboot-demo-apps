package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.ineuron.targets.Bike;
import in.ineuron.targets.Car;

@SpringBootApplication
public class TestApp
{
	public static void main(String[] args)
	{
		ApplicationContext appContxt = SpringApplication.run(TestApp.class, args);
		Car car = appContxt.getBean(Car.class);
		Bike bike = appContxt.getBean(Bike.class);
		
		System.out.println(car);
		System.out.println(bike);
	}
}
