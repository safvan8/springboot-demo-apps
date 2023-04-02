package in.ineuron;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.controller.IEmployeeController;
import in.ineuron.vo.EmployeeVO;

@SpringBootApplication
public class BootProj03RealTimeDependecnyInjection
{

	public static void main(String[] args)
	{
		ConfigurableApplicationContext factory = SpringApplication.run(BootProj03RealTimeDependecnyInjection.class, args);

		// getting bean using default bean id
		IEmployeeController controller = factory.getBean("employeeControllerImpl", IEmployeeController.class);
		System.out.println(controller);

		Scanner sc = new Scanner(System.in);

		EmployeeVO vo = new EmployeeVO();

		System.out.println("Enter employee name :");
		vo.setEname(sc.nextLine());
		System.out.println("Enter employee address :");
		vo.setEaddress(sc.nextLine());
		System.out.println("Enter employee age :");
		vo.setEage(sc.next());

		controller.save(vo);

	}

}
