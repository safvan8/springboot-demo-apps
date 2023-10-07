package com.safvan.config;

import javax.jms.ConnectionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

@Configuration
@EnableJms // Enables Spring's JMS support
public class MessagingListnerConfiguration {

	@Autowired
	ConnectionFactory connectionFactory;

	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
		// Create and configure a JMS listener container factory
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();

		// Set the JMS ConnectionFactory for the listener container factory
		factory.setConnectionFactory(connectionFactory);

		/**
		 * Set the concurrency setting for message listeners . Here, we configure it as
		 * "1-1," which means one message listener per container . You can adjust the
		 * concurrency settings as per your requirements
		 * 
		 * The "1-1" setting is useful for cases where you want to ensure that messages
		 * are processed in order, one at a time. If you need more concurrent
		 * processing, / you can adjust this setting accordingly.
		 */
		factory.setConcurrency("1-1");
		return factory;
	}

}
