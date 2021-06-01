package com.danilopeixoto.api.controller;

import com.danilopeixoto.api.model.ErrorResponseModel;
import com.danilopeixoto.api.model.LinkRequestModel;
import com.danilopeixoto.api.model.LinkResponseModel;
import com.danilopeixoto.api.service.LinkService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.net.URI;
import java.util.NoSuchElementException;
import java.util.UUID;

@Tag(name = "Link service")
@Validated
@RequestMapping("/links")
@RestController
public class LinkController {
  @Autowired
  private LinkService service;

  @Operation(summary = "Create URL redirect link.", responses = {
    @ApiResponse(
      responseCode = "200",
      content = @Content(
        schema = @Schema(implementation = LinkResponseModel.class),
        mediaType = "application/json")),
    @ApiResponse(
      responseCode = "400",
      content = @Content(
        schema = @Schema(implementation = ErrorResponseModel.class),
        mediaType = "application/json")),
    @ApiResponse(
      responseCode = "500",
      content = @Content(
        schema = @Schema(implementation = ErrorResponseModel.class),
        mediaType = "application/json"))
  })
  @PostMapping
  public Mono<LinkResponseModel> create(@Valid @RequestBody Mono<LinkRequestModel> linkRequest) {
    return this.service.create(linkRequest);
  }

  @Operation(summary = "List or find URL redirect link by URL.", responses = {
    @ApiResponse(
      responseCode = "200",
      content = @Content(
        array = @ArraySchema(schema = @Schema(implementation = LinkResponseModel.class)),
        mediaType = "application/json")),
    @ApiResponse(
      responseCode = "400",
      content = @Content(
        schema = @Schema(implementation = ErrorResponseModel.class),
        mediaType = "application/json")),
    @ApiResponse(
      responseCode = "500",
      content = @Content(
        schema = @Schema(implementation = ErrorResponseModel.class),
        mediaType = "application/json"))
  })
  @GetMapping("/")
  public Flux<LinkResponseModel> listOrFindByUrl(@Valid @RequestParam(value = "url", required = false) String url) {
    return Mono
      .justOrEmpty(url)
      .flux()
      .switchIfEmpty(Mono.error(new IllegalArgumentException()))
      .flatMap(this.service::findByUrl)
      .onErrorResume(
        IllegalArgumentException.class,
        exception -> this.service.list());
  }

  @Operation(summary = "Find URL redirect link by ID.", responses = {
    @ApiResponse(
      responseCode = "200",
      content = @Content(
        schema = @Schema(implementation = LinkResponseModel.class),
        mediaType = "application/json")),
    @ApiResponse(
      responseCode = "400",
      content = @Content(
        schema = @Schema(implementation = ErrorResponseModel.class),
        mediaType = "application/json")),
    @ApiResponse(
      responseCode = "404",
      content = @Content(
        schema = @Schema(implementation = ErrorResponseModel.class),
        mediaType = "application/json")),
    @ApiResponse(
      responseCode = "500",
      content = @Content(
        schema = @Schema(implementation = ErrorResponseModel.class),
        mediaType = "application/json"))
  })
  @GetMapping("/{id}")
  public Mono<LinkResponseModel> findById(@Valid @PathVariable UUID id) {
    return this.service
      .findById(id)
      .switchIfEmpty(Mono.error(new NoSuchElementException("Resource not found.")));
  }

  @Operation(summary = "Redirect to URL link.", responses = {
    @ApiResponse(
      responseCode = "200",
      content = @Content(
        schema = @Schema(implementation = LinkResponseModel.class),
        mediaType = "application/json")),
    @ApiResponse(
      responseCode = "400",
      content = @Content(
        schema = @Schema(implementation = ErrorResponseModel.class),
        mediaType = "application/json")),
    @ApiResponse(
      responseCode = "404",
      content = @Content(
        schema = @Schema(implementation = ErrorResponseModel.class),
        mediaType = "application/json")),
    @ApiResponse(
      responseCode = "500",
      content = @Content(
        schema = @Schema(implementation = ErrorResponseModel.class),
        mediaType = "application/json"))
  })
  @GetMapping("/{id}/redirect")
  public Mono<ResponseEntity<Object>> redirect(
    @Valid @PathVariable UUID id,
    @Valid @RequestParam String passcode) {
    return this.service
      .redirect(id, passcode)
      .map(url -> ResponseEntity
        .status(HttpStatus.FOUND)
        .location(URI.create(url))
        .build())
      .switchIfEmpty(Mono.error(new NoSuchElementException("Resource not found.")));
  }

  @Operation(summary = "Update URL redirect link by ID.", responses = {
    @ApiResponse(
      responseCode = "200",
      content = @Content(
        schema = @Schema(implementation = LinkResponseModel.class),
        mediaType = "application/json")),
    @ApiResponse(
      responseCode = "400",
      content = @Content(
        schema = @Schema(implementation = ErrorResponseModel.class),
        mediaType = "application/json")),
    @ApiResponse(
      responseCode = "404",
      content = @Content(
        schema = @Schema(implementation = ErrorResponseModel.class),
        mediaType = "application/json")),
    @ApiResponse(
      responseCode = "500",
      content = @Content(
        schema = @Schema(implementation = ErrorResponseModel.class),
        mediaType = "application/json"))
  })
  @PutMapping("/{id}")
  public Mono<LinkResponseModel> update(
    @Valid @PathVariable UUID id,
    @Valid @RequestBody Mono<LinkRequestModel> linkRequest) {
    return this.service
      .update(id, linkRequest)
      .switchIfEmpty(Mono.error(new NoSuchElementException("Resource not found.")));
  }

  @Operation(summary = "Delete URL redirect link by ID.", responses = {
    @ApiResponse(
      responseCode = "200",
      content = @Content(
        schema = @Schema(implementation = LinkResponseModel.class),
        mediaType = "application/json")),
    @ApiResponse(
      responseCode = "400",
      content = @Content(
        schema = @Schema(implementation = ErrorResponseModel.class),
        mediaType = "application/json")),
    @ApiResponse(
      responseCode = "404",
      content = @Content(
        schema = @Schema(implementation = ErrorResponseModel.class),
        mediaType = "application/json")),
    @ApiResponse(
      responseCode = "500",
      content = @Content(
        schema = @Schema(implementation = ErrorResponseModel.class),
        mediaType = "application/json"))
  })
  @DeleteMapping("/{id}")
  public Mono<LinkResponseModel> delete(@Valid @PathVariable UUID id) {
    return this.service
      .delete(id)
      .switchIfEmpty(Mono.error(new NoSuchElementException("Resource not found.")));
  }
}
