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
public class MessagingConfiguration {

	// Define the default broker URL and the name of the message queue
	private static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";
	private static final String MESSAGE_QUEUE = "message_queue";

	// Autowire the MessageReceiver bean (assuming it's defined elsewhere)
	@Autowired
	MessageReceiver messageReceiver;

	// Configure the JMS connection factory
	@Bean
	public ConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();

		// Set the broker URL to the default value
		connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);

		// Configure trusted packages to prevent deserialization issues
		connectionFactory.setTrustedPackages(Arrays.asList("com.safvan"));

		return connectionFactory;
	}

	/*
	 * Configure the JmsTemplate bean, which is used for sending messages.
	 */
	@Bean
	public JmsTemplate jmsTemplate() {
		JmsTemplate template = new JmsTemplate();

		// Set the connection factory to use for sending messages
		template.setConnectionFactory(connectionFactory());

		// Set the default destination name (queue) for sending messages
		template.setDefaultDestinationName(MESSAGE_QUEUE);

		return template;
	}

	// Configure the message converter for converting messages to a simpler format
	@Bean
	MessageConverter converter() {
		return new SimpleMessageConverter();
	}
}
