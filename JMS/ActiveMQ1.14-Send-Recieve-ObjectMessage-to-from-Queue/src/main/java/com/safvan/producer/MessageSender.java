package com.safvan.producer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.safvan.model.Product;

@Component
public class MessageSender
{
	@Autowired
	JmsTemplate jmsTemplate;

	public void sendMessage(final Product product)
	{
		// Use the JmsTemplate to send a JMS message
		jmsTemplate.send(new MessageCreator()
		{
			public Message createMessage(Session session) throws JMSException
			{
				// Create an ObjectMessage and set the product as its payload
				ObjectMessage objectMessage = session.createObjectMessage(product);
				return objectMessage;
			}
		});
	}
}
