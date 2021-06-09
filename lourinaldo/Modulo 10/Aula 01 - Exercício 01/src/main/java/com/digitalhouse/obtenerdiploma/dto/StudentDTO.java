package com.digitalhouse.obtenerdiploma.dto;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

public class StudentDTO {

    @NotNull(message = "Name cant be null!")
    @Pattern(regexp = "^[\\p{L}\\s]{8,50}")
    @Size(min = 8, max = 50)
    private String name;

    @Valid
    @NotNull(message = "Subjects cant be null!")
    @NotEmpty(message = "A subject must be added!")
    private List<SubjectDTO> subjects;

    public StudentDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubjectDTO> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectDTO> subjects) {
        this.subjects = subjects;
    }

}
