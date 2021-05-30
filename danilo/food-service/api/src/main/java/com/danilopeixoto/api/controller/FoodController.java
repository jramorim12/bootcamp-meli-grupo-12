package com.danilopeixoto.api.controller;

import com.danilopeixoto.api.model.CalorieReportModel;
import com.danilopeixoto.api.model.ErrorResponse;
import com.danilopeixoto.api.model.FoodModel;
import com.danilopeixoto.api.model.IngredientModel;
import com.danilopeixoto.api.service.FoodService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Tag(name = "Food calorie calculator")
@Validated
@RequestMapping("/calories")
@RestController
public class FoodController {
  @Autowired
  private FoodService service;

  @Operation(summary = "Calculate food calories.", responses = {
    @ApiResponse(
      responseCode = "200",
      content = @Content(
        schema = @Schema(implementation = CalorieReportModel.class),
        mediaType = "application/json")),
    @ApiResponse(
      responseCode = "400",
      content = @Content(
        schema = @Schema(implementation = ErrorResponse.class),
        mediaType = "application/json")),
    @ApiResponse(
      responseCode = "500",
      content = @Content(
        schema = @Schema(implementation = ErrorResponse.class),
        mediaType = "application/json"))
  })
  @PostMapping
  public Mono<CalorieReportModel> calculateCalories(@Valid @RequestBody Mono<FoodModel> food) {
    return this.service
      .getIngredients(food)
      .collectList()
      .flatMap(ingredients -> {
        Flux<IngredientModel> ingredientFlux = Flux.fromIterable(ingredients);

        return Flux
          .zip(
            this.service.calculateTotalCalories(ingredientFlux),
            this.service.getMostCaloricIngredient(ingredientFlux),
            Mono.just(ingredients))
          .map(results -> new CalorieReportModel(
            results.getT1(),
            results.getT2(),
            results.getT3()))
          .single();
      });
  }
}
