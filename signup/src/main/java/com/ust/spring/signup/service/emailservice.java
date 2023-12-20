package com.ust.spring.signup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class emailservice {
    @Autowired
    private JavaMailSender jms;

    public void send(String to,String subject, String body){

        SimpleMailMessage msg=new SimpleMailMessage();
        msg.setTo(to);
        msg.setReplyTo("ajaycshenoy@gmail.com");
        msg.setSubject(subject);
        msg.setText(body);
        jms.send(msg);
    }
}
