package com.danilopeixoto.application;

class Account {
  private String owner;
  private double balance;

  public Account(String owner, double balance) {
    this.owner = owner;
    this.balance = balance;
  }

  public Account(Account account) {
    this.owner = account.getOwner();
    this.balance = account.getBalance();
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  @Override
  public String toString() {
    return "Account{" +
      "owner='" + owner + '\'' +
      ", balance=" + balance +
      '}';
  }

  public void deposit(double amount) {
    if (amount > 0) {
      this.balance += amount;
    } else {
      throw new IllegalArgumentException("Invalid deposit amount.");
    }
  }

  public void withdraw(double amount) {
    if (amount > 0) {
      this.balance -= amount;
    } else {
      throw new IllegalArgumentException("Invalid withdraw amount.");
    }
  }

  public void returnAmount(double amount) {
    this.deposit(amount);
  }

  public void transfer(Account account, double amount) {
    if (amount > 0) {
      if (this.balance >= amount) {
        this.withdraw(amount);
        account.deposit(amount);
      }
    } else {
      throw new IllegalArgumentException("Invalid return amount.");
    }
  }
}

public class Exercise41 {
  public static void main(String[] args) {
    Account accountA = new Account("Danilo Peixoto Ferreira", 10);
    Account accountB = new Account("Maria Elizabeth Ferreira", 10);

    System.out.println(accountA);
    System.out.println("---------------------------------------------");

    System.out.println(accountB);
    System.out.println("---------------------------------------------");

    System.out.printf("Transfering 10 units from %s to %s.\n", accountA.getOwner(), accountB.getOwner());
    System.out.println("---------------------------------------------");

    accountA.transfer(accountB, 10);

    System.out.println(accountA);
    System.out.println("---------------------------------------------");

    System.out.println(accountB);
    System.out.println("---------------------------------------------");
  }
}
