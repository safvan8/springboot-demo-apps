package com.safvan.config;

import javax.jms.ConnectionFactory;

import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
@ComponentScan(basePackages = "com.safvan")
public class JMSConfiguration {

    // This configuration class sets up and configures JMS listeners and message converters.
    @Bean
    public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
            DefaultJmsListenerContainerFactoryConfigurer configurer) {
        
    	// Create a JmsListenerContainerFactory bean for configuring JMS listeners.
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        
        // Configure the factory with the given ConnectionFactory and container properties.
        configurer.configure(factory, connectionFactory);
        
        // Return the configured factory.
        return factory;
    }

    @Bean
    public MessageConverter jacksonJmsMessageConverter() {
    	
        // Create a Jackson-based MessageConverter for converting messages to and from JSON format.
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        
        // Set the target message type to TEXT, meaning the payload of the message will be in text format.
        converter.setTargetType(MessageType.TEXT);
        
        // Set the type ID property name. This is used to indicate the Java class of the message payload.
        converter.setTypeIdPropertyName("_type");
        
        // Return the configured message converter.
        return converter;
    }
}
