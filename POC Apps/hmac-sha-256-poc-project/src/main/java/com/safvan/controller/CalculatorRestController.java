package com.safvan.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.safvan.entity.TestRequest;
import com.safvan.utils.HmacUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorRestController {

	@PostMapping("/add")
	public ResponseEntity<Integer> addition(@RequestBody TestRequest request, @RequestHeader("signature") String expectedSignature) throws JsonProcessingException {
		// Verify the authenticity of the request using HMAC-SHA256
		// Create an ObjectMapper to convert the request to JSON
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonRequest = objectMapper.writeValueAsString(request);
		System.out.println("recived JSON request : "+jsonRequest);

		// Replace "yourSecretKey" with your actual secret key used for HMAC
		String secretKey = "yourSecretKey";

		String calculatedSignature = HmacUtil.calculateHmacSHA256(secretKey, jsonRequest);

		System.out.println("Calculated Signature : " +  calculatedSignature);

		if (calculatedSignature.equals(expectedSignature)){
			System.out.println("Request received from a trusted source: VALID...........");
			return  ResponseEntity.ok(Integer.parseInt(request.getNum1())  +Integer.parseInt( request .getNum2()));
		}


		if (!calculatedSignature.equals(expectedSignature)) {
			// Signature does not match, reject the request
			System.out.println("INVALID Signature, request not authorized...........");
			return ResponseEntity.badRequest().build();
		}

		return  null;
//		int result = request.getNum1()+request.getNum2();


	}
}
