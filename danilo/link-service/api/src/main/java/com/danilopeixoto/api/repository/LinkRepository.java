package com.danilopeixoto.api.repository;

import com.danilopeixoto.api.model.LinkModel;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Repository
public interface LinkRepository extends ReactiveCrudRepository<LinkModel, UUID> {
  @Query("select * from Link where lower(url) like concat('%', lower(:url), '%')")
  Flux<LinkModel> findByUrl(String url);
}
