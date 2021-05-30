package com.danilopeixoto.api.service;

import com.danilopeixoto.api.model.FoodModel;
import com.danilopeixoto.api.model.IngredientModel;
import com.danilopeixoto.api.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.NoSuchElementException;

@Service
public class FoodService {
  @Autowired
  private IngredientRepository repository;

  public Flux<IngredientModel> getIngredients(Mono<FoodModel> food) {
    return food.map(FoodModel::getIngredients)
      .flatMapMany(Flux::fromIterable)
      .map(this.repository::findById)
      .flatMap(element -> Mono.fromCallable(element::get))
      .onErrorMap(
        NoSuchElementException.class,
        exception -> new NoSuchElementException("Cannot find one or more ingredients."));
  }

  public Mono<Double> calculateTotalCalories(Flux<IngredientModel> ingredients) {
    return ingredients
      .map(IngredientModel::getCalories)
      .reduce(0.0, Double::sum);
  }

  public Mono<IngredientModel> getMostCaloricIngredient(Flux<IngredientModel> ingredients) {
    return ingredients
      .sort(Comparator.comparing(IngredientModel::getCalories))
      .last();
  }
}
