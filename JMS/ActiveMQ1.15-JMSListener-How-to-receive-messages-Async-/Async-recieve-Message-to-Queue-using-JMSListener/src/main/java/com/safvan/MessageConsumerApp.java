package com.safvan;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.safvan.config.AppConfig;

public class MessageConsumerApp
{

	public static void main(String[] args)
	{
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		try
		{
			Thread.sleep(6000000); // to hold application for receiving messages, to show app is runnig
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		((AbstractApplicationContext) context).close();
	}

}
