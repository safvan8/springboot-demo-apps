package in.ineuron;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.service.IEmployeeMangementService;

public class JdbcTemplateDirectMethodTest {
	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"in/ineuron/cfg/applicationContext.xml");

		IEmployeeMangementService service = applicationContext.getBean(IEmployeeMangementService.class);

		try {
			int recordCount = service.fetchEmpsCount();
			System.out.println("No of records are :: " + recordCount);

			String name = service.getEmployeeNameByNo(5);
			System.out.println("Employee name is :: " + name);

			Map<String, Object> empDetails = service.getEmployeeDetailsByNo(10);
			System.out.println("Employee Details are :: " + empDetails);

			System.out.println("----------------------------------------------");
			
			service.getEmployeeDeatilsByDesignation("batsman", "allrounder").forEach(System.out::println);

			System.out.println("*********************************************");
			
			int rowAffected = service.insertEmp("Mayers", 24, "LSG", "allrounder", 3000);
			System.out.println("No of records affected are :: " + rowAffected);

			System.out.println("#####################################################");
			
			int rowForUpdation = service.addBonusToEmpByDesg("batsman", 1000);
			System.out.println("No of rows affected is ::" + rowForUpdation);

		} catch (Exception e) {
			System.out.println("Exception handled..........");
			e.printStackTrace();
		}
		((ConfigurableApplicationContext) applicationContext).close();

	}
}
