package com.danilopeixoto.api.service;

import com.danilopeixoto.api.model.CourseApprovalStatus;
import com.danilopeixoto.api.model.CourseModel;
import com.danilopeixoto.api.model.GradeReportModel;
import com.danilopeixoto.api.model.StudentModel;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active:development")
public class GradleReportServiceTest {
  @Autowired
  private GradeReportService service;

  @Test
  void shouldGenerateRejectedReport() {
    StepVerifier
      .create(this.service
        .generate(Mono
          .just(new StudentModel(
            "danilopeixoto",
            List.of(
              new CourseModel("computergraphics", 5.0),
              new CourseModel("parallelprogramming", 5.0)))))
        .map(GradeReportModel::getStatus))
      .expectNext(CourseApprovalStatus.Rejected)
      .verifyComplete();
  }

  @Test
  void shouldReportAverageFive() {
    StepVerifier
      .create(this.service
        .generate(Mono
          .just(new StudentModel(
            "danilopeixoto",
            List.of(
              new CourseModel("computergraphics", 5.0),
              new CourseModel("parallelprogramming", 10.0)))))
        .map(GradeReportModel::getAverageGrade))
      .expectNext(7.5)
      .verifyComplete();
  }
}
