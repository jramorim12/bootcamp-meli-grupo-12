package com.danilopeixoto.api.service;

import com.danilopeixoto.api.entity.CharacterEntity;
import com.danilopeixoto.api.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class CharacterService {
  @Autowired
  private CharacterRepository repository;

  public Flux<CharacterEntity> findByName(String name) {
    return Flux.fromIterable(this.repository.findByName(name));
  }
}
