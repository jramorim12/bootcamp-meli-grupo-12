package com.danilopeixoto.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class GradeReportModel {
  @NotEmpty(message = "The name field is required.")
  @JsonProperty("name")
  private String name;

  @NotNull(message = "The grade field is required.")
  @Min(value = 0, message = "The grade field requires positive numbers.")
  @Max(value = 10, message = "The grade field must be less or equal 10.")
  @JsonProperty("grade")
  private Double averageGrade;

  @NotNull(message = "The status field is required.")
  @JsonProperty("status")
  private CourseApprovalStatus status;

  public GradeReportModel() {
  }

  public GradeReportModel(String name, Double averageGrade, CourseApprovalStatus status) {
    this.name = name;
    this.averageGrade = averageGrade;
    this.status = status;
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
}
