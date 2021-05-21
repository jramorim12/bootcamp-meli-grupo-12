package com.danilopeixoto.application;

class Counter {
  private int value;

  public Counter() {
    this.value = 0;
  }

  public Counter(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public void increment() {
    this.value++;
  }

  public void decrement() {
    this.value--;
  }

  @Override
  public String toString() {
    return "Counter{" +
      "value=" + value +
      '}';
  }
}

public class Exercise42 {
  public static void main(String[] args) {
    Counter counter = new Counter();

    counter.increment();
    counter.decrement();

    System.out.println("Counter:");
    System.out.println(counter);
  }
}
