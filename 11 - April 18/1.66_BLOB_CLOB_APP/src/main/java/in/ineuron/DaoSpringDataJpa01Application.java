package in.ineuron;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.bo.MarriageSeeker;
import in.ineuron.service.IMatrimonyServiceMgnt;

@SpringBootApplication
public class DaoSpringDataJpa01Application
{

	public static void main(String[] args) throws Exception
	{
		ApplicationContext factory = SpringApplication.run(DaoSpringDataJpa01Application.class, args);

		IMatrimonyServiceMgnt service = factory.getBean(IMatrimonyServiceMgnt.class);

//		Scanner scanner = new Scanner(System.in);
//
//		System.out.print("Enter the name :: ");
//		String name = scanner.next();
//
//		System.out.print("Enter the address :: ");
//		String address = scanner.next();
//
//		System.out.print("Enter the photoPath :: ");
//		String photoPath = scanner.next();
//
//		System.out.print("Enter the bioDataPath :: ");
//		String bioDataPath = scanner.next();
//
//		System.out.print("Is the person Indian :: ");
//		Boolean indian = scanner.nextBoolean();
//
//		// To read image
//		// Create an input stream to read the photo file specified by `photoPath`
//		InputStream inputStream = new FileInputStream(photoPath);
//		byte[] photoData = new byte[inputStream.available()];
//		// Read the available bytes from the input stream into `photoData`
//		inputStream.read(photoData);
//
//		// to read bioData to a char[]
//		File file = new File(bioDataPath);
//		Reader reader = new FileReader(file);
//		char[] bioDataContent = new char[(int) file.length()];
//		// Read the characters from the `Reader` into `bioDataContent`
//		reader.read(bioDataContent);
//
//		
//		
//		MarriageSeeker seeker = new MarriageSeeker(name, address, photoData, LocalDateTime.of(1993, 1, 3, 20, 15),
//				bioDataContent, indian);
//		System.out.println(service.registerMarriageSeeker(seeker));
//		inputStream.close();
//		reader.close();
//		scanner.close();

		
//   -- un comment below for retrieval
		Optional<MarriageSeeker> optional = service.searchSeekerById(2L);
		if (optional.isPresent())
		{
			MarriageSeeker seeker = optional.get();
			System.out.println(
					seeker.getId() + " " + seeker.getName() + " " + seeker.getAddress() + " " + seeker.getIndian());

			OutputStream os = new FileOutputStream("retrieve_image.jpg");
			os.write(seeker.getPhoto());
			os.flush();

			Writer writer = new FileWriter("retrive_biodata.txt");
			writer.write(seeker.getBioData());
			writer.flush();

			os.close();
			writer.close();

			System.out.println("LOBS are retrieved...");

		} else
		{
			System.out.println("Record not available");
		}
		((ConfigurableApplicationContext) factory).close();
	}
}
