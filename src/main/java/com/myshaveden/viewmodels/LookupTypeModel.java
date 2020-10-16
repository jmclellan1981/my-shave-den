package com.myshaveden.viewmodels;

public class LookupTypeModel {
  private String typeName;
  private String typeDescription;
  private String id;

  private LookupTypeModel() {

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

  public static class Builder {
    private LookupTypeModel model = new LookupTypeModel();

    public Builder withTypeName(String typeName) {
      model.typeName = typeName;
      return this;
    }

    public Builder withTypeDescription(String typeDescription) {
      model.typeDescription = typeDescription;
      return this;
    }

    public Builder withId(String id) {
      model.id = id;
      return this;
    }

    public LookupTypeModel build() {
      return model;
    }
  }

}
