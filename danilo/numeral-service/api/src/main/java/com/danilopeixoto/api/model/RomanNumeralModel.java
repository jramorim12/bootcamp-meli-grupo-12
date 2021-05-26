package com.danilopeixoto.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class RomanNumeralModel {
  @NotNull(message = "The value field is required.")
  @JsonProperty("value")
  private String value;

  public RomanNumeralModel() {
  }

  public RomanNumeralModel(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
