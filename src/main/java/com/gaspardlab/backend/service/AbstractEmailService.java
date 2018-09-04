package com.gaspardlab.backend.service;

import com.gaspardlab.web.domain.frontend.FeedbackPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

public abstract class AbstractEmailService implements EmailService {

    @Value("${default.to.address}")
    private String defaultToAddress;

    /**
     * Create a Simple Mail Message from a feedback Pojo.
     * @param feedback The feedback Pojo
     * @return
     */
    protected SimpleMailMessage prepareSimpleMailMessageFromFeedbackPojo(FeedbackPojo feedback){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(defaultToAddress);
        message.setFrom(feedback.getEmail());
        message.setSubject("[DevOpsLab]: Feedback received from " +feedback.getFirstName() + " " +
                feedback.getLastName() + "!");
        message.setText(feedback.getFeedback());
        return message;
    }

    @Override
    public void sendFeedbackEmail(FeedbackPojo feedback) {
        sendGenericEmailMessage(prepareSimpleMailMessageFromFeedbackPojo(feedback));
    }
}
