package com.safvan.test;

import java.util.logging.Logger;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class MyLoggerExtension implements BeforeEachCallback, AfterEachCallback {
	private Logger logger;
	
	public MyLoggerExtension(String msg) {
		System.out.println(msg);
	}

	@Override
	public void beforeEach(ExtensionContext arg0) throws Exception {
		logger = Logger.getLogger(arg0.getClass().getName());
		logger.info("Inside BeforeEach in method: " + arg0.getDisplayName());
	}

	@Override
	public void afterEach(ExtensionContext arg0) throws Exception {
		logger.info("Inside AfterEach in method: " + arg0.getDisplayName());
		logger = null;
	}

}
