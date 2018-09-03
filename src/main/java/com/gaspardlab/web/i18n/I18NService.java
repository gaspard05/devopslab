package com.gaspardlab.web.i18n;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class I18NService {

    @Autowired
    private MessageSource messageSource;

    /**
     *
     * @param messageId
     * @return
     */
    public String getMessage(String messageId){
        Locale locale = LocaleContextHolder.getLocale();
        return getMessage(messageId, locale);
    }

    /**
     *
     * @param messageId The key to the message id and locale
     * @param locale The Locale
     * @return Return a message for the given message id and locale
     */
    public String getMessage(String messageId, Locale locale){
        return messageSource.getMessage(messageId,null, locale);
    }

}
