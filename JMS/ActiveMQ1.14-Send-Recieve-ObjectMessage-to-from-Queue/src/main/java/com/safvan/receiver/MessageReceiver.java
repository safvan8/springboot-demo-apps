package com.safvan.receiver;

import javax.jms.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import com.safvan.model.Product;

@Component
public class MessageReceiver
{
	@Autowired
	JmsTemplate jmsTemplate;
	@Autowired
	MessageConverter messageConverter;

	public Product receiveMessage()
	{
		try
		{
			/*
			 * Here we receive the message.
			 */
			Message message = jmsTemplate.receive();
			
			// Convert the received JMS message to a Product object using the messageConverter
			Product product = (Product) messageConverter.fromMessage(message);
			
			return product;
		}
		catch (Exception exe)
		{
			exe.printStackTrace();
		}

		return null;
	}
}
