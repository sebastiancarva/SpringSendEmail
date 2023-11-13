package com.spring.mail.sender.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {
    @Value("${email.sender}")
    private String emailUser;
    @Value("${email.password}")
    private String emailPassword;
    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        //Los correos se mandan por un protocolo SMTP pero aqui no se lo indica
        mailSender.setHost("smtp.gmail.com");
        // Puerto Por defecto para el protocolo smtp
        mailSender.setPort(587);
        mailSender.setUsername(emailUser);
        mailSender.setPassword(emailPassword);

        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.transport.protocol","smtp"); //Aqui si se lo indica el protocolo
        properties.put("mail.smtp.auth","true"); //habilitamos la authenticacion
        properties.put("mail.smtp.starttls.enable","true"); // habilitamos el cifrado entre la comunicacion de la app y el correo para la seguridad
        properties.put("mail.debug","true");

        return mailSender;
    }

}
