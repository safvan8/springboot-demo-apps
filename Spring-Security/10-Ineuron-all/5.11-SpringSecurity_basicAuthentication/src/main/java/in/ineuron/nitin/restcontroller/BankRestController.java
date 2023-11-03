package in.ineuron.nitin.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
public class BankRestController {

	@GetMapping("/")
	public String welcomePage() {
		return "Welcome to ICICI Bank";
	}
	
	@GetMapping("/transfer")
	public String fundTransfer() {
		return "Fund transfer initiated";
	}
	
	@GetMapping("/balance")
	public String checkBalance() {
		return "Balance amount is :: 10000INR";
	}
	
	@GetMapping("/about")
	public String aboutUs() {
		return "ICICI bank is managed by India Central Govt";
	}
}
