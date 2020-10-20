package com.myshaveden.viewmodels;

import java.time.LocalDateTime;

public class BaseModel {
  private String id;
  private LocalDateTime dateCreated;
  private LocalDateTime dateModified;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public LocalDateTime getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(LocalDateTime dateCreated) {
    this.dateCreated = dateCreated;
  }

  public LocalDateTime getDateModified() {
    return dateModified;
  }

  public void setDateModified(LocalDateTime dateModified) {
    this.dateModified = dateModified;
  }

}
