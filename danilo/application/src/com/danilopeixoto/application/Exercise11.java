package com.danilopeixoto.application;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exercise11 {
  public static void main(String[] args) {
    Integer[] array = {52, 10, 85, 1324, 1, 13, 62, 30, 12, 127};
    List<Integer> list = Arrays.asList(array);

    System.out.println("Ascending:");

    Collections.sort(list);
    list.forEach(System.out::println);

    System.out.println("Descending:");

    Collections.reverse(list);
    list.forEach(System.out::println);
  }
}
