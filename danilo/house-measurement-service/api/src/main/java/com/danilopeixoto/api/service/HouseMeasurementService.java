package com.danilopeixoto.api.service;

import com.danilopeixoto.api.configuration.APIConfiguration;
import com.danilopeixoto.api.model.RoomRequest;
import com.danilopeixoto.api.model.RoomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.List;

@Service
public class HouseMeasurementService {
  @Autowired
  private APIConfiguration configuration;

  public Flux<RoomResponse> computeRoomAreas(List<RoomRequest> rooms) {
    return Flux
      .fromIterable(rooms)
      .map(room -> new RoomResponse(
        room.getName(),
        room.getWidth() * room.getLength()));
  }

  public Mono<Double> computeMarketValue(Mono<Double> area) {
    return area.map(a -> a * this.configuration.getSquareMeterPrice());
  }

  public Mono<Double> computeTotalArea(Flux<RoomResponse> rooms) {
    return rooms
      .map(RoomResponse::getArea)
      .reduce(0.0, Double::sum);
  }

  public Mono<RoomResponse> getLargerRoom(Flux<RoomResponse> rooms) {
    return rooms
      .sort(Comparator.comparing(RoomResponse::getArea))
      .last();
  }
}
