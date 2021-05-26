package com.danilopeixoto.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class DecimalNumberModel {
  @NotNull(message = "The value field is required.")
  @Min(value = 1, message = "The value field requires positive integers.")
  @Max(value = 3999, message = "The value field must be less than 4000.")
  @JsonProperty("value")
  private Integer value;

  public DecimalNumberModel() {
  }

  public DecimalNumberModel(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return this.value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }
}
