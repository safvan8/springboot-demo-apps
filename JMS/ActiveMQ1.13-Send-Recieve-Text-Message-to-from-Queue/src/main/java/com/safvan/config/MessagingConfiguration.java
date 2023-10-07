package com.safvan.config;

import java.util.Arrays;

import javax.jms.ConnectionFactory;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;

import com.safvan.receiver.MessageReceiver;

@Configuration
public class MessagingConfiguration
{

	// Define the default broker URL and the name of the message queue
	private static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";
	private static final String MESSAGE_QUEUE = "message_queue";

	// Autowire the MessageReceiver bean (assuming it's defined elsewhere)
	@Autowired
	MessageReceiver messageReceiver;

	// Configure the JMS connection factory
	@Bean
	public ConnectionFactory connectionFactory()
	{
		// Create an ActiveMQ connection factory
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		
		// Set the broker URL for connecting to the JMS broker
		connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
		
		// Specify trusted packages to avoid classloading issues during deserialization
		connectionFactory.setTrustedPackages(Arrays.asList("com.safvan"));
		
		return connectionFactory;
	}

	/*
	 * Define a JmsTemplate bean, which simplifies sending JMS messages.
	 */
	@Bean
	public JmsTemplate jmsTemplate()
	{
		// Create a JmsTemplate
		JmsTemplate template = new JmsTemplate();
		
		// Set the connection factory to be used by the JmsTemplate
		template.setConnectionFactory(connectionFactory());
		
		// Set the default destination name (queue) for sending messages
		template.setDefaultDestinationName(MESSAGE_QUEUE);
		
		return template;
	}

	// Configure a message converter for message serialization and deserialization
	@Bean
	MessageConverter converter()
	{
		// Use a SimpleMessageConverter for basic message conversion
		return new SimpleMessageConverter();
	}

}
