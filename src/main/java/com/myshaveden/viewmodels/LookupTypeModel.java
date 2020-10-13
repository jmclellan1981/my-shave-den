package com.myshaveden.viewmodels;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableLookupTypeModel.class)
@JsonDeserialize(as = ImmutableLookupTypeModel.class)
public abstract class LookupTypeModel {
  public abstract String typeName();

  public abstract String typeDescription();

  public abstract String id();

}
