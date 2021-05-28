package com.danilopeixoto.api.controller;

import com.danilopeixoto.api.model.ErrorResponse;
import com.danilopeixoto.api.model.HouseMeasurementRequest;
import com.danilopeixoto.api.model.HouseMeasurementResponse;
import com.danilopeixoto.api.model.RoomResponse;
import com.danilopeixoto.api.service.HouseMeasurementService;
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

@Tag(name = "House area measurement")
@Validated
@RequestMapping("/area")
@RestController
public class AreaMeasurementController {
  @Autowired
  private HouseMeasurementService measurementService;

  @Operation(summary = "Compute house area metrics.", responses = {
    @ApiResponse(
      responseCode = "200",
      content = @Content(
        schema = @Schema(implementation = HouseMeasurementResponse.class),
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
  public Mono<HouseMeasurementResponse> metrics(@Valid @RequestBody HouseMeasurementRequest measurementRequest) {
    Flux<RoomResponse> rooms = this.measurementService.computeRoomAreas(measurementRequest.getRooms());
    Mono<Double> area = this.measurementService.computeTotalArea(rooms);

    return Flux
      .zip(
        area,
        this.measurementService.computeMarketValue(area),
        this.measurementService.getLargerRoom(rooms),
        rooms.collectList())
      .map(items -> new HouseMeasurementResponse(
        items.getT1(),
        items.getT2(),
        items.getT3(),
        items.getT4()))
      .single();
  }
}
