package com.danilopeixoto.application;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// More complex clothing can be derived from Clothing class.

class Clothing {
  private String brand;
  private String model;

  public Clothing(String brand, String model) {
    this.brand = brand;
    this.model = model;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  @Override
  public String toString() {
    return "Clothing{" +
      "brand='" + brand + '\'' +
      ", model='" + model + '\'' +
      '}';
  }
}

class Closet {
  private int counter;
  private final Map<Integer, List<Clothing>> shelves;

  public Closet() {
    this.counter = 0;
    this.shelves = new HashMap<>();
  }

  public int store(List<Clothing> clothes) {
    int id = this.counter++;
    shelves.put(id, clothes);

    return id;
  }

  public List<Clothing> getShelf(int id) {
    return this.shelves.get(id);
  }

  public void report() {
    this.shelves.forEach((id, shelf) -> {
      System.out.printf("Shelf ID: %d\n", id);
      shelf.forEach(System.out::println);
      System.out.println("--------------------------------------------------");
    });
  }
}

public class ClothStoreApplication {
  public static void main(String[] args) {
    Clothing clothing0 = new Clothing("Chanel", "Tweed Mescla Jacket");
    Clothing clothing1 = new Clothing("Chanel", "Gabrielle Lã Jacket");

    List<Clothing> clothes0 = Collections.singletonList(clothing0);
    List<Clothing> clothes1 = Collections.singletonList(clothing1);

    Closet closet = new Closet();

    int shelfID0 = closet.store(clothes0);
    int shelfID1 = closet.store(clothes1);

    System.out.println("Report");
    closet.report();

    System.out.println("Returned shelves");

    List<Clothing> clothes = closet.getShelf(shelfID0);

    System.out.printf("Shelf ID: %s\n", shelfID0);
    clothes.forEach(System.out::println);

    clothes = closet.getShelf(shelfID1);

    System.out.printf("Shelf ID: %s\n", shelfID1);
    clothes.forEach(System.out::println);
  }
}
