package com.danilopeixoto.api.controller;

import com.danilopeixoto.api.model.AgeResponse;
import com.danilopeixoto.api.model.ErrorResponse;
import com.danilopeixoto.api.service.AgeCalculatorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.time.DateTimeException;
import java.time.LocalDate;

@Tag(name = "Age calculator")
@Validated
@RequestMapping("/age")
@RestController
public class AgeCalculatorController {
  @Autowired
  private AgeCalculatorService ageCalculatorService;

  @Operation(summary = "Calculate age from birth date.", responses = {
    @ApiResponse(
      responseCode = "200",
      content = @Content(
        schema = @Schema(implementation = AgeResponse.class),
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
  @GetMapping("/{year}/{month}/{day}")
  public Mono<AgeResponse> calculate(
    @Valid @PathVariable Integer day,
    @Valid @PathVariable Integer month,
    @Valid @PathVariable Integer year) {
    return Mono
      .fromCallable(() -> LocalDate.of(year, month, day))
      .onErrorMap(DateTimeException.class, (exception) -> new IllegalArgumentException("Invalid birth date."))
      .flatMap(this.ageCalculatorService::calculate);
  }
}
