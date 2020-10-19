package com.myshaveden.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.myshaveden.services.AppUserService;

@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {
  @Autowired
  AppUserService userService;

  @Value("app.email.key")
  private String emailKey;

  @Override
  public void onApplicationEvent(OnRegistrationCompleteEvent event) {

    this.confirmRegistration(event);

  }

  private void confirmRegistration(OnRegistrationCompleteEvent event) {

  }

}
