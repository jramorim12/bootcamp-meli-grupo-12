package com.danilopeixoto.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FoodModel {
  @NotBlank(message = "The name field is required.")
  @JsonProperty("name")
  private String name;

  @Valid
  @NotEmpty(message = "The ingredients field requires at least one ingredient.")
  @JsonProperty("ingredients")
  private List<String> ingredients;
}
