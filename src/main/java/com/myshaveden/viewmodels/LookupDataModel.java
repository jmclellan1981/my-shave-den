package com.myshaveden.viewmodels;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = LookupDataModel.Builder.class)
public class LookupDataModel {
  private final String dataName;
  private final String dataDescription;
  private final LookupTypeModel lookupType;

  private LookupDataModel(String dataName, String dataDescription, LookupTypeModel lookupType) {
    this.dataName = dataName;
    this.dataDescription = dataDescription;
    this.lookupType = lookupType;
  }

  @JsonPOJOBuilder
  public static class Builder {
    private String dataName;
    private String dataDescription;
    private LookupTypeModel lookupTypeModel;

    public Builder withDataName(String dataName) {
      this.dataName = dataName;
      return this;
    }

    public Builder withDataDescription(String dataDescription) {
      this.dataDescription = dataDescription;
      return this;
    }

    public Builder withLookupTypeModel(LookupTypeModel lookupTypeModel) {
      this.lookupTypeModel = lookupTypeModel;
      return this;
    }

    public LookupDataModel build() {
      return new LookupDataModel(dataName, dataDescription, lookupTypeModel);
    }
  }

  public String getDataName() {
    return dataName;
  }

  public String getDataDescription() {
    return dataDescription;
  }

  public LookupTypeModel getLookupType() {
    return lookupType;
  }

}
