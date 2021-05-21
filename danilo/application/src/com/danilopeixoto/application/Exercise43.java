package com.danilopeixoto.application;

class Book {
  private String title;
  private String author;
  private String isbn;

  public Book() {
  }

  public Book(String title, String author, String isbn) {
    this.title = title;
    this.author = author;
    this.isbn = isbn;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getISBN() {
    return isbn;
  }

  public void setISBN(String isbn) {
    this.isbn = isbn;
  }

  @Override
  public String toString() {
    return String.format("%s, %s - ISBN %s", this.title, this.author, this.isbn);
  }
}

public class Exercise43 {
  public static void main(String[] args) {
    Book book = new Book(
      "Alice's Adventures in Wonderland",
      "Lewis Carroll",
      "978-0147515872");

    System.out.println("Book:");
    System.out.println(book);
  }
}
