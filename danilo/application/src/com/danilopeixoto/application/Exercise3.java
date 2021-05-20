package com.danilopeixoto.application;

import java.util.Scanner;
import java.util.stream.IntStream;

// NOTE: trivial division method (parallel brute force).
// TODO: implement sieve of Eratosthenes method.

public class Exercise3 {
    public static void validatePositiveInteger(int value) {
        if (value < 0) {
            System.err.println("Invalid parameter: negative integer not allowed.");
            System.exit(1);
        }
    }

    public static boolean isPrime(int number) {
        return number > 1 && IntStream
                .rangeClosed(2, number / 2)
                .parallel()
                .noneMatch(i -> number % i == 0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("N: ");
        int number = scanner.nextInt();

        validatePositiveInteger(number);

        System.out.printf("Prime number: %s\n", isPrime(number) ? "yes": "no");
    }
}
