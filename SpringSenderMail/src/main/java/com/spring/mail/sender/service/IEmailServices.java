package com.spring.mail.sender.service;

import java.io.File;

public interface IEmailServices {

    void sendEmail(String[] toUser, String subject, String message);
    void sendEmailWithFile(String[] toUser, String subject, String message, File file);

}
