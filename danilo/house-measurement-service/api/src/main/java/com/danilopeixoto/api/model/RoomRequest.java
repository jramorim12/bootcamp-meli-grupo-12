package com.danilopeixoto.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class RoomRequest {
  @NotEmpty(message = "The name field is required.")
  @JsonProperty("name")
  private String name;

  @NotNull(message = "The width field is required.")
  @Min(value = 0, message = "The width field requires positive numbers.")
  @JsonProperty("width")
  private Double width;

  @NotNull(message = "The length field is required.")
  @Min(value = 0, message = "The length field requires positive numbers.")
  @JsonProperty("length")
  private Double length;

  public RoomRequest() {
  }

  public RoomRequest(String name, Double width, Double length) {
    this.name = name;
    this.width = width;
    this.length = length;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getWidth() {
    return this.width;
  }

  public void setWidth(Double width) {
    this.width = width;
  }

  public Double getLength() {
    return this.length;
  }

  public void setLength(Double length) {
    this.length = length;
  }
}
