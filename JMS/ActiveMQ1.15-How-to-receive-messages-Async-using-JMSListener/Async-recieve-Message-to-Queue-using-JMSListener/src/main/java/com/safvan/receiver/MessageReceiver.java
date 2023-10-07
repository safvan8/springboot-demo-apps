package com.safvan.receiver;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import com.safvan.model.Product;

@Component
public class MessageReceiver implements MessageListener {
    @Autowired
    JmsTemplate jmsTemplate; 
    
    @Autowired
    MessageConverter messageConverter;

    // This method is called by the message listener when a message is received
    public void onMessage(Message message) {
        try {
            // Convert the received JMS message to a Product object using the message converter
            Product product = (Product) messageConverter.fromMessage(message);

            System.out.println("------- Inside onMessage -------");
            // Process the received product
            System.out.println(product);
            System.out.println("------- Inside onMessage -------");
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}

