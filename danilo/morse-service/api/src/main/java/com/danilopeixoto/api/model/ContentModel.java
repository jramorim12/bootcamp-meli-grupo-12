package com.danilopeixoto.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

public class ContentModel {
  @NotEmpty(message = "The content field is required.")
  @JsonProperty("content")
  private String content;

  public ContentModel() {
  }

  public ContentModel(String content) {
    this.content = content;
  }

  public String getContent() {
    return this.content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
