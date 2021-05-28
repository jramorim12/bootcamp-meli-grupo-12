package com.danilopeixoto.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class AgeResponse {
  @NotNull(message = "The birth date field is required.")
  @JsonProperty("birth_date")
  private LocalDate birthDate;

  @NotNull(message = "The age field is required.")
  @Min(value = 0, message = "The age field requires positive integers.")
  @JsonProperty("age")
  private Integer age;

  public AgeResponse() {
  }

  public AgeResponse(LocalDate birthDate, Integer age) {
    this.birthDate = birthDate;
    this.age = age;
  }

  public LocalDate getBirthDate() {
    return this.birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public Integer getAge() {
    return this.age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }
}
