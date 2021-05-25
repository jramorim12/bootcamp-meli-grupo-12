package com.danilopeixoto.application;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

interface Payable {
  void pay();
}

class CieloPaymentController implements Payable {
  @Override
  public void pay() {
    System.out.println("CIELO");
  }
}

class StonePaymentController implements Payable {
  @Override
  public void pay() {
    System.out.println("STONE");
  }
}

class RedePaymentController implements Payable {
  @Override
  public void pay() {
    System.out.println("REDE");
  }
}

class PaymentProvider {
  private final Map<String, Payable> providers;

  public PaymentProvider() {
    this.providers = new HashMap<>();
  }

  public void register(String name, Payable provider) {
    this.providers.put(name, provider);
  }

  public Payable get(String name) {
    return this.providers.get(name);
  }
}

public class PaymentApplication {
  public static void main(String[] args) {
    // Instantiate providers at initialization (eg. Spring Boot beans)
    PaymentProvider provider = new PaymentProvider();

    provider.register("cielo", new CieloPaymentController());
    provider.register("stone", new StonePaymentController());
    provider.register("rede", new RedePaymentController());

    Scanner scanner = new Scanner(System.in);
    System.out.print("Provider: ");

    String paymentID = scanner.next().toLowerCase();

    // Use providers at runtime

    try {
      Payable controller = provider.get(paymentID);
      controller.pay();
    } catch (NullPointerException exception) {
      System.err.println("Payment provider not found.");
    }
  }
}
