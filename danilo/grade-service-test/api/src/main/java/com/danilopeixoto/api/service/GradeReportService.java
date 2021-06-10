package com.danilopeixoto.api.service;

import com.danilopeixoto.api.configuration.APIConfiguration;
import com.danilopeixoto.api.model.CourseApprovalStatus;
import com.danilopeixoto.api.model.CourseModel;
import com.danilopeixoto.api.model.GradeReportModel;
import com.danilopeixoto.api.model.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class GradeReportService {
  @Autowired
  private APIConfiguration configuration;

  public Mono<GradeReportModel> generate(Mono<StudentModel> student) {
    return student.flatMap(s -> Flux
      .zip(
        Mono.just(s.getName()),
        Mono.just(s.getCourses())
          .flatMapMany(Flux::fromIterable)
          .map(CourseModel::getGrade)
          .reduce(0.0, Double::sum)
          .filter(sum -> sum != 0)
          .map(sum -> sum / s.getCourses().size())
          .defaultIfEmpty(0.0),
        Mono.just(s.getCourses()))
      .map(results -> new GradeReportModel(
        results.getT1(),
        results.getT2(),
        results.getT2() > this.configuration.getGradeApprovedThreshold() ?
          CourseApprovalStatus.Approved :
          CourseApprovalStatus.Rejected,
        results.getT3()))
      .single());
  }
}
