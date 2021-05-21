package com.danilopeixoto.application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

class Date {
  private int day;
  private int month;
  private int year;

  public Date() {
    LocalDate now = LocalDate.now();

    this.day = now.getDayOfMonth();
    this.month = now.getMonthValue();
    this.year = now.getYear();
  }

  public Date(int day, int month, int year) {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  public int getDay() {
    return day;
  }

  public void setDay(int day) {
    this.day = day;
  }

  public int getMonth() {
    return month;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  @Override
  public String toString() {
    return "GregorianCalendar{" +
      "day=" + day +
      ", month=" + month +
      ", year=" + year +
      '}';
  }

  public void plusDays(int days) {
    this.day += days;
  }

  public boolean isValid() {
    try {
      LocalDate.parse(String.format(
        "%04d-%02d-%02d",
        this.year,
        this.month,
        this.day),
        DateTimeFormatter.ISO_LOCAL_DATE);

      return true;
    } catch (DateTimeParseException exception) {
      exception.printStackTrace();
      return false;
    }
  }
}

public class Exercise45 {
  public static void main(String[] args) {
    Date date = new Date();

    System.out.println("Date (now): " + date);

    date.plusDays(10);

    System.out.println("Date (+10 days): " + date);

    System.out.printf(
      "Date %s is valid: %s\n",
      date,
      date.isValid() ? "yes" : "no");
  }
}
