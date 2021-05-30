package com.danilopeixoto.api.repository;

import com.danilopeixoto.api.model.IngredientModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientRepository extends CrudRepository<IngredientModel, String> {
  @Query("select i from IngredientModel i where lower(i.name) = lower(:name)")
  Optional<IngredientModel> findById(String name);
}
