package com.myshaveden.registration;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.myshaveden.services.AppUserService;
import com.myshaveden.viewmodels.AppUserModel;

@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {
  @Autowired
  AppUserService userService;
  @Autowired
  JavaMailSender mailSender;

  @Override
  public void onApplicationEvent(OnRegistrationCompleteEvent event) {
    this.confirmRegistration(event);
  }

  private void confirmRegistration(OnRegistrationCompleteEvent event) {
    AppUserModel user = event.getUser();
    String token = UUID.randomUUID().toString();
    String emailAddress = user.getEmail();
    String subject = "Test Email";
    String message = "This is a test";
    SimpleMailMessage email = new SimpleMailMessage();
    email.setTo(emailAddress);
    email.setSubject(subject);
    email.setText(message);
    mailSender.send(email);

  }

}
