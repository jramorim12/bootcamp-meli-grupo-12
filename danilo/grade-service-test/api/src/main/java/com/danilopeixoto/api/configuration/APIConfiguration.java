package com.danilopeixoto.api.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Validated
@ConfigurationProperties(prefix = "api")
@Configuration
public class APIConfiguration {
  @NotEmpty(message = "The version field is required.")
  private String version;

  @NotNull(message = "The grade approved threshold field is required.")
  @Min(value = 0, message = "The grade approved threshold field requires positive numbers.")
  @Max(value = 10, message = "The grade approved threshold field must be less or equal 10.")
  private Double gradeApprovedThreshold;

  public String getVersion() {
    return this.version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public Double getGradeApprovedThreshold() {
    return this.gradeApprovedThreshold;
  }

  public void setGradeApprovedThreshold(Double gradeApprovedThreshold) {
    this.gradeApprovedThreshold = gradeApprovedThreshold;
  }
}
