package br.com.marcello.DegreeProject.entities;

import java.util.Map;

public class Student {

    private Long id;
    private String name;
    private Map<String, Double> schoolReport;

    public Student(Long id, String name, Map<String, Double> schoolReport) {
        this.id = id;
        this.name = name;
        this.schoolReport = schoolReport;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setNome(String nome) {
        this.name = name;
    }

    public Map<String, Double> getSchoolReport() {
        return schoolReport;
    }

    public void setSchoolReport(Map<String, Double> schoolReport) {
        this.schoolReport = schoolReport;
    }
}
