package com.danilopeixoto.application;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// TODO: profile non-parallel vs parallel streams.

public class RadixSort {
  public static void sort(List<Integer> list) {
    int maximumLength = Collections
      .max(list)
      .toString()
      .length();

    List<String> items = list
      .stream()
      .parallel()
      .map(Object::toString)
      .map(element -> String
        .format("%" + maximumLength + "s", element)
        .replace(' ', '0'))
      .collect(Collectors.toList());

    for (int i = maximumLength - 1; i >= 0; i--) {
      final int pivot = i;

      Map<Character, List<String>> groups = items
        .stream()
        .parallel()
        .collect(Collectors
          .toMap(
            element -> element.charAt(pivot),
            Arrays::asList,
            (element0, element1) -> Stream
              .concat(element0.stream(), element1.stream())
              .collect(Collectors.toList()),
            TreeMap::new));

      items = groups
        .values()
        .stream()
        .parallel()
        .flatMap(Collection::stream)
        .collect(Collectors.toList());
    }

    Collections.copy(
      list,
      items
        .stream()
        .parallel()
        .map(Integer::valueOf)
        .collect(Collectors.toList()));
  }

  public static void main(String[] args) {
    List<Integer> array = Arrays.asList(3, 673, 106, 45, 2, 23);

    sort(array);

    System.out.println("Result:");
    array.forEach(System.out::println);
  }
}
