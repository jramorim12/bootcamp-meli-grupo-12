package com.danilopeixoto.api.service;

import com.danilopeixoto.api.model.ContentModel;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MorseTranslationService {
  public static Map<String, Character> codes = new HashMap<>() {{
    put(".-", 'a');
    put("-...", 'b');
    put("-.-.", 'c');
    put("-..", 'd');
    put(".", 'e');
    put("..-.", 'f');
    put("--.", 'g');
    put("....", 'h');
    put("..", 'i');
    put(".---", 'j');
    put("-.-", 'k');
    put(".-..", 'l');
    put("--", 'm');
    put("-.", 'n');
    put("---", 'o');
    put(".--.", 'p');
    put("--.-", 'q');
    put(".-.", 'r');
    put("...", 's');
    put("-", 't');
    put("..-", 'u');
    put("...-", 'v');
    put(".--", 'w');
    put("-..-", 'x');
    put("-.--", 'y');
    put("--..", 'z');
    put(".----", '1');
    put("..---", '2');
    put("...--", '3');
    put("....-", '4');
    put(".....", '5');
    put("-....", '6');
    put("--...", '7');
    put("---..", '8');
    put("----.", '9');
    put("-----", '0');
  }};

  public Mono<ContentModel> translate(Mono<ContentModel> content) {
    return content
      .map(ContentModel::getContent)
      .filter(text -> text
        .chars()
        .filter(c -> c != '.' && c != '-' && c != ' ')
        .count() == 0)
      .map(text -> Arrays.stream(text.split("\\s{3}"))
        .map(word -> Arrays.stream(word.split("\\s"))
          .map(code -> codes.get(code))
          .filter(Objects::nonNull)
          .map(String::valueOf)
          .collect(Collectors.joining()))
        .collect(Collectors.joining(" ")))
      .map(String::toUpperCase)
      .map(ContentModel::new)
      .switchIfEmpty(Mono.error(new IllegalArgumentException("Invalid Morse content.")));
  }
}
