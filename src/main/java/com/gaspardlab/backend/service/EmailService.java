package com.gaspardlab.backend.service;

import com.gaspardlab.web.domain.frontend.FeedbackPojo;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    /**
     * Sends an email with the content in Feedback POJO.
     * @param feedback The feedback POJO
     */
    void sendFeedbackEmail(FeedbackPojo feedback);

    /**
     * Sends an email with the content of the Simple Mail Message object
     * @param message The object containing the email content
     */
    void sendGenericEmailMessage(SimpleMailMessage message);
}
