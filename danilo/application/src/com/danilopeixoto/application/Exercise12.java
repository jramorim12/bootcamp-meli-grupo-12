package com.danilopeixoto.application;

import java.time.LocalDateTime;

class Company {
  private String name;
  private double marketValue;
  private double growthRate;

  public Company(String name, double marketValue, double growthRate) {
    this.name = name;
    this.marketValue = marketValue;
    this.growthRate = growthRate;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getMarketValue() {
    return marketValue;
  }

  public void setMarketValue(double marketValue) {
    this.marketValue = marketValue;
  }

  public double getGrowthRate() {
    return growthRate;
  }

  public void setGrowthRate(double growthRate) {
    this.growthRate = growthRate;
  }

  @Override
  public String toString() {
    return String.format("Name: %s\n", this.name) +
      String.format("Market value: %s millions\n", this.marketValue * 1e-6) +
      String.format("Growth rate: %s%%\n", this.growthRate * 100);
  }

  public void update() {
    this.marketValue = this.marketValue * (1 + this.growthRate);
  }
}

public class Exercise12 {
  public static void main(String[] args) {
    Company xCompany = new Company("X Company", 1.13e6, 1.48);
    Company yCompany = new Company("Y Company", 18.4e6, 0.32);

    LocalDateTime date = LocalDateTime.parse("2021-01-01T00:00:00");

    System.out.printf("Date: %s\n", date);
    System.out.println(xCompany);
    System.out.println(yCompany);
    System.out.println("---------------------------------------------");

    while (xCompany.getMarketValue() < yCompany.getMarketValue()) {
      xCompany.update();
      yCompany.update();

      date = date.plusYears(1);

      System.out.printf("Date: %s\n", date);
      System.out.println(xCompany);
      System.out.println(yCompany);
      System.out.println("---------------------------------------------");
    }
  }
}
