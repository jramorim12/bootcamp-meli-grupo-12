package com.danilopeixoto.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
  private String name;
  private double price;
  private int amount;

  public Product() {
  }

  public Product(String name, double price, int amount) {
    this.name = name;
    this.price = price;
    this.amount = amount;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public double getTotalPrice() {
    return this.amount * this.price;
  }

  @Override
  public String toString() {
    return String.format("Name: %s\n", this.name) +
      String.format("Price: US$ %s\n", this.price) +
      String.format("Amount: %s\n", this.amount);
  }
}

public class Exercise13 {
  public static void validatePositiveInteger(int value) {
    if (value < 0) {
      System.err.println("Invalid parameter: negative integer not allowed.");
      System.exit(1);
    }
  }

  public static void main(String[] args) {
    int count = 3;
    List<Product> products = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    for (int i = 0; i < count; i++) {
      Product product = new Product();

      System.out.printf("Product %s\n", i + 1);

      System.out.println("Name:");
      product.setName(scanner.next());

      System.out.println("Price US$:");
      product.setPrice(scanner.nextDouble());

      System.out.println("Amount:");
      int amount = scanner.nextInt();

      validatePositiveInteger(amount);
      product.setAmount(amount);

      System.out.println("---------------------------------------------");

      products.add(product);
    }

    products.forEach(System.out::println);

    double totalPrice = products
      .stream()
      .parallel()
      .map(Product::getTotalPrice)
      .reduce(0.0, Double::sum);

    System.out.printf("Total price: US$ %s\n", totalPrice);
  }
}
