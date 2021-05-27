package br.com.marcello.DegreeProject.entities;

public class Degree {

    private Long id;
    private Student student;
    private Double average;
    private String message;

    public Degree(Long id, Student student, Double average, String message) {
        this.id = id;
        this.student = student;
        this.average = average;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
