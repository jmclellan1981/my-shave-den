package com.myshaveden.registration;

import java.util.Locale;

import org.springframework.context.ApplicationEvent;

import com.myshaveden.viewmodels.AppUserModel;

public class OnRegistrationCompleteEvent extends ApplicationEvent {
  private static final long serialVersionUID = 9006664514484001994L;
  private String appUrl;
  private Locale locale;
  private AppUserModel user;

  public OnRegistrationCompleteEvent(AppUserModel newUser, Locale locale, String appUrl) {
    super(newUser);
    this.user = newUser;
    this.locale = locale;
    this.appUrl = appUrl;
  }

  public String getAppUrl() {
    return appUrl;
  }

  public void setAppUrl(String appUrl) {
    this.appUrl = appUrl;
  }

  public Locale getLocale() {
    return locale;
  }

  public void setLocale(Locale locale) {
    this.locale = locale;
  }

  public AppUserModel getUser() {
    return user;
  }

  public void setUser(AppUserModel user) {
    this.user = user;
  }

}
