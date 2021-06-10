package com.danilopeixoto.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

public class StudentModel {
  @Length(min = 8, max = 50, message = "The name field length must be between 8 and 50.")
  @Pattern(regexp = "[a-zA-z]+", message = "The name field allows characters from a to z.")
  @NotEmpty(message = "The name field is required.")
  @JsonProperty("name")
  private String name;

  @Valid
  @NotNull(message = "The courses field is required.")
  @JsonProperty("courses")
  private List<CourseModel> courses;

  public StudentModel() {
  }

  public StudentModel(String name, List<CourseModel> courses) {
    this.name = name;
    this.courses = courses;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<CourseModel> getCourses() {
    return this.courses;
  }

  public void setCourses(List<CourseModel> courses) {
    this.courses = courses;
  }
}
