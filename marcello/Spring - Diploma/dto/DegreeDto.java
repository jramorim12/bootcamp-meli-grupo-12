package br.com.marcello.DegreeProject.dto;

import br.com.marcello.DegreeProject.entities.Student;

public class DegreeDto {

    private Student student;
    private Double average;
    private String message;

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
