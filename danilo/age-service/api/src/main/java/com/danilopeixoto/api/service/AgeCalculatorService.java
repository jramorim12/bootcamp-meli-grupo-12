package com.danilopeixoto.api.service;

import com.danilopeixoto.api.model.AgeResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.Period;

@Service
public class AgeCalculatorService {
  public Mono<AgeResponse> calculate(LocalDate birthDate) {
    return Mono.just(birthDate)
      .map(date -> Period.between(date, LocalDate.now()))
      .map(Period::getYears)
      .filter(age -> age >= 0)
      .map(age -> new AgeResponse(birthDate, age))
      .switchIfEmpty(Mono.error(new IllegalArgumentException("Birth date cannot be a future date.")));
  }
}
