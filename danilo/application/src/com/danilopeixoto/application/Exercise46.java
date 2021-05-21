package com.danilopeixoto.application;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Tuple<X, Y> {
  public final X x;
  public final Y y;

  public Tuple(X x, Y y) {
    this.x = x;
    this.y = y;
  }
}

class MyStringUtils {
  public static String rpad(String s, char c, int n) {
    int length = s.length();

    if (length == n) {
      return s;
    } else if (length > n) {
      return s.substring(length - n);
    } else {
      int count = n - length;

      return String
        .valueOf(c)
        .repeat(count) +
        s;
    }
  }

  public static String ltrim(String s) {
    return s.replaceAll("^\\s+", "");
  }

  public static String rtrim(String s) {
    return s.replaceAll("\\s+$", "");
  }

  public static String trim(String s) {
    return s.trim();
  }

  public static int indexOfN(String s, char c, int n) {
    int length = s.length();

    if (n < 0 || n >= length) {
      return -1;
    }

    List<Tuple<Integer, Character>> result = IntStream
      .range(0, length)
      .mapToObj(i -> new Tuple<>(i, s.charAt(i)))
      .filter(tuple -> tuple.y.equals(c))
      .collect(Collectors.toList());

    if (n >= result.size()) {
      return -1;
    }

    return result
      .get(n)
      .x;
  }
}

public class Exercise46 {
  public static void main(String[] args) {
    String name = "     Danilo Peixoto Ferreira     ";

    System.out.printf("Input: {%s}\n", name);
    System.out.printf("Right pad: {%s}\n", MyStringUtils.rpad(name, '0', 35));
    System.out.printf("Left trim: {%s}\n", MyStringUtils.ltrim(name));
    System.out.printf("Right trim: {%s}\n", MyStringUtils.rtrim(name));
    System.out.printf("Trim: {%s}\n", MyStringUtils.trim(name));
    System.out.printf("Index of N: {%s}\n", MyStringUtils.indexOfN(name, 'a', 1));
  }
}
