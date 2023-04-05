package in.ineuron;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.comp.BillGenerator;

@SpringBootApplication
public class TestApp
{
	public static void main(String[] args) throws Exception
	{
		ApplicationContext context = SpringApplication.run(TestApp.class, args);

		System.out.println("Beans info are :: " + Arrays.toString(context.getBeanDefinitionNames()));
		System.out.println();
		// Checking the contents of billGenerator
		BillGenerator billGenerator = context.getBean(BillGenerator.class);
		System.out.println(billGenerator);

		((ConfigurableApplicationContext) context).close();
	}
}
