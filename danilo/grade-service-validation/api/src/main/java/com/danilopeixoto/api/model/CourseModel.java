package com.danilopeixoto.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

public class CourseModel {
  @Length(min = 8, max = 50, message = "The name field length must be between 8 and 50.")
  @Pattern(regexp = "[a-zA-z]+", message = "The name field allows characters from a to z.")
  @NotEmpty(message = "The name field is required.")
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
