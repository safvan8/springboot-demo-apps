package com.safvan.receiver;

import javax.jms.JMSException;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import com.safvan.model.Product;

@Component
public class MessageReceiver
{
	private static final String MESSAGE_QUEUE = "message_queue";

	@JmsListener(destination = MESSAGE_QUEUE)
	public void receiveMessage(final Message<Product> message)
			throws JMSException
	{
		// Retrieve message headers
		MessageHeaders headers = message.getHeaders();
		System.out.println("headers = " + headers);

		// Retrieve the message payload (in this case, a Product object)
		Product product = message.getPayload();
		System.out.println("product = " + product);
	}
}
