package com.myshaveden.domain;

import javax.persistence.Entity;

@Entity
public class LookupType extends BaseEntity {
  private String typeName;
  private String typeDescription;

  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }

  public String getTypeDescription() {
    return typeDescription;
  }

  public void setTypeDescription(String typeDescription) {
    this.typeDescription = typeDescription;
  }

}
