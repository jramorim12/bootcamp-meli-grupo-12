package com.danilopeixoto.api.repository;

import com.danilopeixoto.api.entity.CharacterEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends CrudRepository<CharacterEntity, String> {
  @Query("select c from CharacterEntity c where lower(c.name) like concat('%', lower(:name), '%')")
  Iterable<CharacterEntity> findByName(String name);
}
