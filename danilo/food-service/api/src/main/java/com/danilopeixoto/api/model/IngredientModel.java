package com.danilopeixoto.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Ingredient")
@Entity
public class IngredientModel {
  @NotBlank(message = "The name field is required.")
  @JsonProperty("name")
  @Column(name = "name")
  @Id
  private String name;

  @NotNull(message = "The calories field is required.")
  @Min(value = 0, message = "The total calories field requires positive numbers.")
  @JsonProperty("calories")
  @Column(name = "calories")
  private Double calories;
}
