package com.danilopeixoto.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class RoomResponse {
  @NotEmpty(message = "The name field is required.")
  @JsonProperty("name")
  private String name;

  @NotNull(message = "The area field is required.")
  @Min(value = 0, message = "The area field requires positive numbers.")
  @JsonProperty("area")
  private Double area;

  public RoomResponse() {
  }

  public RoomResponse(String name, Double area) {
    this.name = name;
    this.area = area;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getArea() {
    return this.area;
  }

  public void setArea(Double area) {
    this.area = area;
  }
}
