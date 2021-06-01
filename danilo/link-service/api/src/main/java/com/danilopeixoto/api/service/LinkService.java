package com.danilopeixoto.api.service;

import com.danilopeixoto.api.configuration.APIConfiguration;
import com.danilopeixoto.api.model.LinkModel;
import com.danilopeixoto.api.model.LinkRequestModel;
import com.danilopeixoto.api.model.LinkResponseModel;
import com.danilopeixoto.api.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.function.TupleUtils;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

import java.util.UUID;

@Service
public class LinkService {
  @Autowired
  private APIConfiguration configuration;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private LinkRepository repository;

  private LinkResponseModel mapToResponse(LinkModel link) {
    return LinkResponseModel
      .builder()
      .id(link.getId())
      .url(link.getUrl())
      .redirect_url(String
        .format(
          "%s://%s:%d/api/%s/links/%s/redirect",
          this.configuration.getSecure() ? "https" : "http",
          this.configuration.getHostname(),
          this.configuration.getPort(),
          this.configuration.getVersion(),
          link.getId()))
      .redirects(link.getRedirects())
      .build();
  }

  public Mono<LinkResponseModel> create(Mono<LinkRequestModel> linkRequest) {
    return linkRequest
      .flatMap(link -> this.repository
        .save(LinkModel
          .builder()
          .url(link.getUrl())
          .passcode(this.passwordEncoder
            .encode(link.getPasscode()))
          .redirects(0)
          .build()))
      .map(this::mapToResponse);
  }

  public Mono<LinkResponseModel> findById(UUID id) {
    return this.repository
      .findById(id)
      .map(this::mapToResponse);
  }

  public Flux<LinkResponseModel> list() {
    return this.repository
      .findAll()
      .map(this::mapToResponse);
  }

  public Flux<LinkResponseModel> findByUrl(String url) {
    return this.repository
      .findByUrl(url)
      .map(this::mapToResponse);
  }

  public Mono<LinkResponseModel> update(UUID id, Mono<LinkRequestModel> linkRequest) {
    return this.repository
      .findById(id)
      .zipWith(linkRequest)
      .flatMap(TupleUtils
        .function((link, linkUpdate) -> this.repository
          .save(link
            .toBuilder()
            .url(linkUpdate.getUrl())
            .passcode(this.passwordEncoder
              .encode(linkUpdate.getPasscode()))
            .build())))
      .map(this::mapToResponse);
  }

  public Mono<LinkResponseModel> delete(UUID id) {
    return this.repository
      .findById(id)
      .flatMap(link -> this.repository
        .deleteById(link.getId())
        .thenReturn(link))
      .map(this::mapToResponse);
  }

  public Mono<String> redirect(UUID id, String passcode) {
    return this.repository
      .findById(id)
      .flatMap(link -> Mono
        .just(Tuples.of(
          link,
          this.passwordEncoder.matches(passcode, link.getPasscode())))
        .filter(Tuple2::getT2)
        .switchIfEmpty(Mono.error(new IllegalAccessException("Invalid passcode."))))
      .map(Tuple2::getT1)
      .map(link -> link
        .toBuilder()
        .redirects(link.getRedirects() + 1)
        .build())
      .flatMap(this.repository::save)
      .map(LinkModel::getUrl);
  }
}
