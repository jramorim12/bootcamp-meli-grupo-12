package com.danilopeixoto.api.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Validated
@Getter
@Setter
@ConfigurationProperties(prefix = "api")
@Configuration
public class APIConfiguration {
  @NotBlank(message = "The version field is required.")
  private String version;

  @NotBlank(message = "The hostname field is required.")
  private String hostname;

  @NotNull(message = "The port field is required.")
  @Min(value = 0, message = "The port field requires positive integers.")
  private Integer port;

  @NotNull(message = "The secure field is required.")
  private Boolean secure;
}
