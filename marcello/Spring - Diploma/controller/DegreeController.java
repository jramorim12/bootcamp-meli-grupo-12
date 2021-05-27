package br.com.marcello.DegreeProject.controller;

import br.com.marcello.DegreeProject.dto.DegreeDto;
import br.com.marcello.DegreeProject.dto.StudentDto;
import br.com.marcello.DegreeProject.entities.Student;
import br.com.marcello.DegreeProject.utils.DegreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/degree")
public class DegreeController {

    @Autowired
    private DegreeUtils degreeUtils;

    @PostMapping(value = "/post", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DegreeDto> getDegree(@RequestBody StudentDto studentDto) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Student student = new Student(1L,studentDto.getName(), studentDto.getSchoolReport());

        DegreeDto degreeDto = new DegreeDto();
        Double average = this.degreeUtils.getAverage(studentDto.getSchoolReport());
        String message = this.degreeUtils.getMessage(average);

        degreeDto.setStudent(student);
        degreeDto.setAverage(average);
        degreeDto.setMessage(message);


        return new ResponseEntity<>(degreeDto, headers, HttpStatus.OK);

    }

}
