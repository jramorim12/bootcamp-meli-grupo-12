package com.digitalhouse.obtenerdiploma;

import com.digitalhouse.obtenerdiploma.dto.CertificateDTO;
import com.digitalhouse.obtenerdiploma.dto.StudentDTO;
import com.digitalhouse.obtenerdiploma.dto.SubjectDTO;
import com.digitalhouse.obtenerdiploma.service.CertificateServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;


@SpringBootTest
@AutoConfigureMockMvc
class CertificateServiceImplTests {

  private CertificateServiceImpl certificateService = new CertificateServiceImpl();

  @Test
  void analyzeNotes(){
    List<SubjectDTO> subjectDTOLista = new ArrayList<>();
    subjectDTOLista.add(new SubjectDTO("Matemática", 7));
    subjectDTOLista.add(new SubjectDTO("História", 8));
    subjectDTOLista.add(new SubjectDTO("Química", 6));

    StudentDTO studentDTO = new StudentDTO("Nome do Aluno", subjectDTOLista);

    CertificateDTO certificateDTO = certificateService.analyzeNotes(studentDTO);

    assertEquals(certificateDTO.getAverage(), 7.0);
    assertEquals(certificateDTO.getMessage(), "Nome do Aluno usted ha conseguido el promedio de 7.0");

  }
  @Test
  void calculateAverageTest(){
    List<SubjectDTO> subjectDTOLista = new ArrayList<>();
    subjectDTOLista.add(new SubjectDTO("Matemática", 3));
    subjectDTOLista.add(new SubjectDTO("História", 9));
    subjectDTOLista.add(new SubjectDTO("Química", 6));

    StudentDTO student = new StudentDTO("Nome do Aluno", subjectDTOLista);

    Double average = certificateService.calculateAverage(student);

    assertEquals(average, 6.0);
  }

  @Test
  void writeDiplomaTest(){
    List<SubjectDTO> subjectDTOLista = new ArrayList<>();
    subjectDTOLista.add(new SubjectDTO("Matemática", 6));
    subjectDTOLista.add(new SubjectDTO("História", 10));

    StudentDTO student = new StudentDTO("Nome do Aluno", subjectDTOLista);

    String diploma = certificateService.writeDiploma(student);

    assertEquals(diploma.toString(), "Nome do Aluno usted ha conseguido el promedio de 8.0");
  }

  @Test
  void withHonorsTeste(){
    String string = certificateService.withHonors(5.0, "Nome do Aluno");

    assertEquals(string, "¡Felicitaciones Nome do Aluno! Usted tiene el gran promedio de 5.0");
  }




}
