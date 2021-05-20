package com.danilopeixoto.application;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Exercise05 {
  public static void validatePositiveInteger(int value) {
    if (value < 0) {
      System.err.println("Invalid parameter: negative integer not allowed.");
      System.exit(1);
    }
  }

  public static void validateIntegerRange(int value, int minimum, int maximum) {
    if (value < minimum || value >= maximum) {
      System.err.println("Invalid parameter: range not allowed.");
      System.exit(1);
    }
  }

  public static int countDigitOccurrences(int number, int digit) {
    return (int) String
      .valueOf(number)
      .chars()
      .filter(d -> d == Character.forDigit(digit, 10))
      .count();
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("N: ");
    int count = scanner.nextInt();

    validatePositiveInteger(count);

    System.out.print("M: ");
    int length = scanner.nextInt();

    validatePositiveInteger(length);

    System.out.print("D: ");
    int digit = scanner.nextInt();

    validateIntegerRange(digit, 0, 10);

    System.out.println("Result:");

    IntStream
      .iterate(0, i -> i + 1)
      .parallel()
      .filter(i -> countDigitOccurrences(i, digit) >= length)
      .limit(count)
      .forEachOrdered(System.out::println);
  }
}
