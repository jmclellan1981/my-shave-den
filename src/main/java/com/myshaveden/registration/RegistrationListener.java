package com.myshaveden.registration;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.myshaveden.services.AppUserService;
import com.myshaveden.viewmodels.AppUserModel;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {
  @Autowired
  AppUserService userService;
  @Autowired
  JavaMailSender mailSender;
  @Value("app.email.key")
  private String emailKey;

  @Override
  public void onApplicationEvent(OnRegistrationCompleteEvent event) {
    try {
      this.confirmRegistration(event);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  private void confirmRegistration(OnRegistrationCompleteEvent event) throws IOException {
    AppUserModel user = event.getUser();
    // String token = UUID.randomUUID().toString();
    String subject = "Test Email";
    String message = "This is a test";
    Email from = new Email("noreply@my-shave-den.herokuapp.com");
    Email to = new Email(user.getEmail());
    Content content = new Content("text/plain", message);
    Mail mail = new Mail(from, subject, to, content);
    SendGrid sg = new SendGrid(emailKey);
    Request request = new Request();
    try {
      request.setMethod(Method.POST);
      request.setEndpoint("mail/send");
      request.setBody(mail.build());
      Response response = sg.api(request);

    } catch (IOException ex) {
      throw ex;
    }
  }

}
