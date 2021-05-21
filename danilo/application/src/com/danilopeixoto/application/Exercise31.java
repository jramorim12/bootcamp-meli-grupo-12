package com.danilopeixoto.application;

import java.util.ArrayList;
import java.util.List;

class Course {
  private String name;
  private int workload;

  public Course(String name, int workload) {
    this.name = name;
    this.workload = workload;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getWorkload() {
    return workload;
  }

  @Override
  public String toString() {
    return String.format("Name: %s\n", this.name) +
      String.format("Workload: %s hours/week\n", this.workload);
  }

  public void setWorkload(int workload) {
    this.workload = workload;
  }
}

class Student {
  private int id;
  private String name;
  private int age;
  private String grade;

  public Student(int id, String name, int age, String grade) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.grade = grade;
  }

  public int getID() {
    return id;
  }

  public void setID(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getGrade() {
    return grade;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }

  @Override
  public String toString() {
    return String.format("ID: %s\n", this.id) +
      String.format("Name: %s\n", this.name) +
      String.format("Age: %s\n", this.age) +
      String.format("Grade: %s\n", this.grade);
  }
}

class Class {
  private String id;
  private String grade;
  private List<Course> courses;
  private List<Student> students;

  public Class(String id, String grade, List<Course> courses, List<Student> students) {
    this.id = id;
    this.grade = grade;
    this.courses = courses;
    this.students = students;
  }

  public String getID() {
    return id;
  }

  public void setID(String id) {
    this.id = id;
  }

  public String getGrade() {
    return grade;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }

  public List<Course> getCourses() {
    return courses;
  }

  public void setCourses(List<Course> courses) {
    this.courses = courses;
  }

  public List<Student> getStudents() {
    return students;
  }

  public void setStudents(List<Student> students) {
    this.students = students;
  }

  @Override
  public String toString() {
    return String.format("ID: %s\n", this.id) +
      String.format("Grade: %s\n", this.grade) +
      String.format("Course count: %s\n", this.courses.size()) +
      String.format("Student count: %s\n", this.students.size());
  }
}

public class Exercise31 {
  public static <T> void printGroup(List<T> group) {
    group.forEach(System.out::println);
    System.out.println("---------------------------------------------");
  }

  public static void main(String[] args) {
    List<Course> courses = new ArrayList<>();

    courses.add(new Course(
      "Introduction to Computer Graphics",
      40
    ));

    List<Student> students = new ArrayList<>();

    students.add(new Student(
      0,
      "Danilo Peixoto Ferreira",
      23,
      "8º"
    ));

    List<Class> classes = new ArrayList<>();

    classes.add(new Class(
      "A",
      "8º",
      courses,
      students));

    printGroup(courses);
    printGroup(students);
    printGroup(classes);
  }
}
