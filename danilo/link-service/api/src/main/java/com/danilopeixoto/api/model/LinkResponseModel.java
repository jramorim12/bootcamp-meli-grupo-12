package com.danilopeixoto.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LinkResponseModel {
  @NotNull(message = "The id field is required.")
  @JsonProperty("id")
  private UUID id;

  @NotBlank(message = "The URL field is required.")
  @JsonProperty("url")
  @URL(protocol = "https", message = "The URL field requires a valid URL.")
  private String url;

  @NotBlank(message = "The redirect URL field is required.")
  @JsonProperty("redirect_url")
  @URL(protocol = "https")
  private String redirect_url;

  @NotNull(message = "The redirects field is required.")
  @Min(value = 0, message = "The redirects field requires positive integers.")
  @JsonProperty("redirects")
  private Integer redirects;
}
