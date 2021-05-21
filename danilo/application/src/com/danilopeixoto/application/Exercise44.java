package com.danilopeixoto.application;

class Fraction extends Number implements Comparable<Double> {
  private double numerator;
  private double denominator;

  public Fraction() {
    this.numerator = 0;
    this.denominator = 0;
  }

  public Fraction(Number value) {
    this.numerator = value.doubleValue();
    this.denominator = 1.0;
  }

  public Fraction(double numerator, double denominator) {
    this.numerator = numerator;
    this.denominator = denominator;
  }

  public double getNumerator() {
    return numerator;
  }

  public void setNumerator(double numerator) {
    this.numerator = numerator;
  }

  public double getDenominator() {
    return denominator;
  }

  public void setDenominator(double denominator) {
    this.denominator = denominator;
  }

  public Fraction add(Fraction fraction) {
    return new Fraction(this.doubleValue() + fraction.doubleValue());
  }

  public Fraction sub(Fraction fraction) {
    return new Fraction(this.doubleValue() - fraction.doubleValue());
  }

  public Fraction div(Fraction fraction) {
    return new Fraction(this.doubleValue() / fraction.doubleValue());
  }

  public Fraction mul(Fraction fraction) {
    return new Fraction(this.doubleValue() * fraction.doubleValue());
  }

  public <T extends Number> Fraction add(T value) {
    return this.add(new Fraction(value));
  }

  public <T extends Number> Fraction sub(T value) {
    return this.sub(new Fraction(value));
  }

  public <T extends Number> Fraction mul(T value) {
    return this.mul(new Fraction(value));
  }

  public <T extends Number> Fraction div(T value) {
    return this.div(new Fraction(value));
  }

  @Override
  public int intValue() {
    return (int) (this.numerator / this.denominator);
  }

  @Override
  public long longValue() {
    return (long) (this.numerator / this.denominator);
  }

  @Override
  public float floatValue() {
    return (float) (this.numerator / this.denominator);
  }

  @Override
  public double doubleValue() {
    return this.numerator / this.denominator;
  }

  @Override
  public int compareTo(Double value) {
    return Double.compare(this.doubleValue(), value);
  }

  @Override
  public String toString() {
    return String.format(
      "%s/%s: %s",
      this.numerator,
      this.denominator,
      this.doubleValue());
  }
}

public class Exercise44 {
  public static void main(String[] args) {
    Fraction fractionA = new Fraction(1, 2);
    Fraction fractionB = new Fraction(1, 2);

    System.out.println("Fraction A:");
    System.out.println(fractionA);

    System.out.println("Fraction B:");
    System.out.println(fractionB);

    System.out.println("Fraction A / Fraction B:");
    System.out.println(fractionA.div(fractionB));

    System.out.println("Fraction A * 2");
    System.out.println(fractionA.mul(2.0));
  }
}
