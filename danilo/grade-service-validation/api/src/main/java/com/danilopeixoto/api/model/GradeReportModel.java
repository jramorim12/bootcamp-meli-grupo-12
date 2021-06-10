package com.danilopeixoto.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

public class GradeReportModel {
  @Length(min = 8, max = 50, message = "The name field length must be between 8 and 50.")
  @Pattern(regexp = "[a-zA-z]+", message = "The name field allows characters from a to z.")
  @NotEmpty(message = "The name field is required.")
  private String name;

  @NotNull(message = "The grade field is required.")
  @Min(value = 0, message = "The grade field requires positive numbers.")
  @Max(value = 10, message = "The grade field must be less or equal 10.")
  @JsonProperty("grade")
  private Double averageGrade;

  @NotNull(message = "The status field is required.")
  @JsonProperty("status")
  private CourseApprovalStatus status;

  @Valid
  @NotNull(message = "The courses field is required.")
  @JsonProperty("courses")
  private List<CourseModel> courses;

  public GradeReportModel() {
  }

  public GradeReportModel(String name, Double averageGrade, CourseApprovalStatus status, List<CourseModel> courses) {
    this.name = name;
    this.averageGrade = averageGrade;
    this.status = status;
    this.courses = courses;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getAverageGrade() {
    return this.averageGrade;
  }

  public void setAverageGrade(Double averageGrade) {
    this.averageGrade = averageGrade;
  }

  public CourseApprovalStatus getStatus() {
    return this.status;
  }

  public void setStatus(CourseApprovalStatus status) {
    this.status = status;
  }

  public List<CourseModel> getCourses() {
    return this.courses;
  }

  public void setCourses(List<CourseModel> courses) {
    this.courses = courses;
  }
}
