package com.danilopeixoto.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LinkRequestModel {
  @NotBlank(message = "The URL field is required.")
  @JsonProperty("url")
  @URL(protocol = "https", message = "The URL field requires a valid URL.")
  private String url;

  @NotBlank(message = "The passcode field is required.")
  @Length(min = 8, message = "The passcode field requires a length greater than or equal to 8.")
  @JsonProperty("passcode")
  private String passcode;
}
