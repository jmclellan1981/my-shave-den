package com.myshaveden.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LookupData extends BaseEntity {
  private String dataName;
  private String dataDescription;
  @ManyToOne
  @JoinColumn(name = "lookup_type_id", nullable = false)
  private LookupType lookupType;

  public String getDataName() {
    return dataName;
  }

  public void setDataName(String dataName) {
    this.dataName = dataName;
  }

  public String getDataDescription() {
    return dataDescription;
  }

  public void setDataDescription(String dataDescription) {
    this.dataDescription = dataDescription;
  }

  public LookupType getLookupType() {
    return lookupType;
  }

  public void setLookupType(LookupType lookupType) {
    this.lookupType = lookupType;
  }

}
