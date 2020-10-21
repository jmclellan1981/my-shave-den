package com.myshaveden.viewmodels;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = LookupTypeModel.Builder.class)
public class LookupTypeModel {
  private final String typeName;
  private final String typeDescription;
  private final String id;

  private LookupTypeModel(String typeName, String typeDescription, String id) {
    this.typeName = typeName;
    this.typeDescription = typeDescription;
    this.id = id;
  }

  public String getTypeName() {
    return typeName;
  }

  public String typeDescription() {
    return typeDescription;
  }

  public String getId() {
    return id;
  }

  @JsonPOJOBuilder
  public static class Builder {
    private String typeName;
    private String typeDescription;
    private String id;

    public Builder withTypeName(String typeName) {
      this.typeName = typeName;
      return this;
    }

    public Builder withTypeDescription(String typeDescription) {
      this.typeDescription = typeDescription;
      return this;
    }

    public Builder withId(String id) {
      this.id = id;
      return this;
    }

    public LookupTypeModel build() {
      return new LookupTypeModel(typeName, typeDescription, id);
    }
  }

}
