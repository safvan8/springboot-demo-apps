package com.hubberspot.mockito.test_doubles.dummy;

public class DummyEmailService implements IEmailService {
	@Override
	public void sendEmail(String message) {
		throw new AssertionError("Method not implemented !!!");
	}
}
