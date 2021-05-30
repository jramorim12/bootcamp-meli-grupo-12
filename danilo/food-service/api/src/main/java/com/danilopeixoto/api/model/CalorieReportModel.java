package com.danilopeixoto.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CalorieReportModel {
  @NotNull(message = "The total calories field is required.")
  @Min(value = 0, message = "The total calories field requires positive numbers.")
  @JsonProperty("total_calories")
  private Double totalCalories;

  @Valid
  @NotNull(message = "The most caloric ingredient field is required.")
  @JsonProperty("most_caloric_ingredient")
  private IngredientModel mostCaloricIngredient;

  @Valid
  @NotNull(message = "The ingredient calories field is required.")
  @JsonProperty("ingredient_calories")
  private List<IngredientModel> ingredientsCalories;
}
