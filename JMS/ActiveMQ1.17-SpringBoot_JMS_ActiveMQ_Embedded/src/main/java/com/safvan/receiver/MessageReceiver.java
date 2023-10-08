package com.safvan.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.safvan.model.Product;

@Component
public class MessageReceiver {
    // Define the name of the JMS queue or topic to listen to.
    private static final String MESSAGE_QUEUE = "message_queue";

    // Use the @JmsListener annotation to indicate that this method should listen for JMS messages
    // from the specified destination (queue or topic).
    @JmsListener(destination = MESSAGE_QUEUE)
    public void receiveMessage(Product product) {
        // This method will be invoked automatically when a JMS message arrives at the MESSAGE_QUEUE.
        
        // The Product parameter represents the deserialized content of the JMS message payload.
        
        // Print a message indicating that a message has been received and display the product details.
        System.out.println("Received " + product);
    }
}
