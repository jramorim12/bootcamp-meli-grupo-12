package com.danilopeixoto.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class StudentModel {
  @NotEmpty(message = "The name field is required.")
  @JsonProperty("name")
  private String name;

  @Valid
  @NotNull(message = "The courses field is required.")
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
