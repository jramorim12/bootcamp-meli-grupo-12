package com.danilopeixoto.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CourseModel {
  @NotEmpty(message = "The name field is required.")
  @JsonProperty("name")
  private String name;

  @NotNull(message = "The grade field is required.")
  @Min(value = 0, message = "The grade field requires positive numbers.")
  @Max(value = 10, message = "The grade field must be less or equal 10.")
  @JsonProperty("grade")
  private Double grade;

  public CourseModel() {
  }

  public CourseModel(String name, Double grade) {
    this.name = name;
    this.grade = grade;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getGrade() {
    return this.grade;
  }

  public void setGrade(Double grade) {
    this.grade = grade;
  }
}
