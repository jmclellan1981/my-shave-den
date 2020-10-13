package com.myshaveden.domain;

import javax.persistence.Entity;

@Entity
public class MenuItem extends BaseEntity {
  private String path;
  private String action;
  private String title;

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

}
