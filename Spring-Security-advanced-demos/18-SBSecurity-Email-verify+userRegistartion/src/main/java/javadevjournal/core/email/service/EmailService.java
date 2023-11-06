package javadevjournal.core.email.service;

import javax.mail.MessagingException;

import javadevjournal.core.email.context.AbstractEmailContext;

public interface EmailService {

    void sendMail(final AbstractEmailContext email) throws MessagingException;
}
