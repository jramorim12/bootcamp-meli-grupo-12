package com.danilopeixoto.application;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Exercise01 {
  public static void validatePositiveInteger(int value) {
    if (value < 0) {
      System.err.println("Invalid parameter: negative integer not allowed.");
      System.exit(1);
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("N: ");
    int count = scanner.nextInt();

    validatePositiveInteger(count);

    System.out.println("Result:");

    IntStream
      .range(0, count)
      .parallel()
      .map(i -> 2 * i)
      .forEachOrdered(System.out::println);
  }
}
