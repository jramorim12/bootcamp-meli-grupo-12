package com.danilopeixoto.api.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Validated
@ConfigurationProperties(prefix = "api")
@Configuration
public class APIConfiguration {
  @NotEmpty(message = "The version field is required.")
  private String version;

  @NotNull(message = "The square meter price field is required.")
  @Min(value = 0, message = "The square meter price field requires positive numbers.")
  private Double squareMeterPrice;

  public String getVersion() {
    return this.version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public Double getSquareMeterPrice() {
    return this.squareMeterPrice;
  }

  public void setSquareMeterPrice(Double squareMeterPrice) {
    this.squareMeterPrice = squareMeterPrice;
  }
}
