package com.danilopeixoto.api.service;

import com.danilopeixoto.api.model.DecimalNumberModel;
import com.danilopeixoto.api.model.RomanNumeralModel;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Service
public class NumeralConversionService {
  private static final List<Integer> decimals = Arrays.asList(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);
  private static final List<String> romans = Arrays.asList("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I");

  public Mono<RomanNumeralModel> decimalToRoman(DecimalNumberModel decimalNumber) {
    int decimal = decimalNumber.getValue();
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < decimals.size(); i++) {
      int numberInPlace = decimal / decimals.get(i);

      if (numberInPlace == 0) {
        continue;
      }

      result.append(
        numberInPlace == 4 && i > 0 ?
          romans.get(i) + romans.get(i - 1) :
          romans.get(i).repeat(numberInPlace));

      decimal = decimal % decimals.get(i);
    }

    return Mono.just(new RomanNumeralModel(result.toString()));
  }
}
