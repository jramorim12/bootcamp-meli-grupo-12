package br.com.marcello.DegreeProject.dto;

import java.util.Map;

public class StudentDto {

    private String name;
    private Map<String, Double> schoolReport;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Double> getSchoolReport() {
        return schoolReport;
    }

    public void setSchoolReport(Map<String, Double> schoolReport) {
        this.schoolReport = schoolReport;
    }
}
