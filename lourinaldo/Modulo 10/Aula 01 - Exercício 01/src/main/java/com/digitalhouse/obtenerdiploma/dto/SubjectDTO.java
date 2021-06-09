package com.digitalhouse.obtenerdiploma.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class SubjectDTO {

  @NotNull(message = "The subject must not be empty!")
  @Pattern(regexp = "^[\\p{L}\\s]{8,50}")
  private String subject;

  @NotNull
  @Max(value = 10)
  @Min(value = 0)
  private Integer note;

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public Integer getNote() {
    return note;
  }

  public void setNote(Integer note) {
    this.note = note;
  }

}
