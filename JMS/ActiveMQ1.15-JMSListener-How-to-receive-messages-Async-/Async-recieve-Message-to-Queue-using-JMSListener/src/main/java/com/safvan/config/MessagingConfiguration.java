package com.safvan.config;

import java.util.Arrays;

import javax.jms.ConnectionFactory;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;

import com.safvan.receiver.MessageReceiver;

@Configuration
public class MessagingConfiguration {
    // Define constants for broker URL and message queue name
    private static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";
    private static final String MESSAGE_QUEUE = "message_queue";

    @Autowired
    MessageReceiver messageReceiver; // Inject the message receiver

    // Configure the JMS connection factory
    @Bean
    public ConnectionFactory connectionFactory() {
        // Create an ActiveMQ connection factory
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        
        // Set the broker URL (ActiveMQ server URL)
        connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
        
        // Specify trusted packages (used for message serialization)
        connectionFactory.setTrustedPackages(Arrays.asList("com.safvan"));
        
        return connectionFactory;
    }

    // Configure the message listener container
    @Bean
    public MessageListenerContainer getContainer() {
        // Create a message listener container
        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
        
        // Set the JMS connection factory
        container.setConnectionFactory(connectionFactory());
        
        // Specify the destination name (message queue)
        container.setDestinationName(MESSAGE_QUEUE);
        
        // Set the message listener (messageReceiver)
        container.setMessageListener(messageReceiver);
        
        return container;
    }

    // Configure the JmsTemplate for sending messages
    @Bean
    public JmsTemplate jmsTemplate() {
        // Create a JmsTemplate for message sending
        JmsTemplate template = new JmsTemplate();
        
        // Set the JMS connection factory
        template.setConnectionFactory(connectionFactory());
        
        // Set the default destination name (message queue)
        template.setDefaultDestinationName(MESSAGE_QUEUE);
        
        return template;
    }

    // Configure the message converter (SimpleMessageConverter)
    @Bean
    MessageConverter converter() {
        // Create a message converter (SimpleMessageConverter)
        return new SimpleMessageConverter();
    }
}
