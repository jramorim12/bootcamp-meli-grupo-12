package com.danilopeixoto.api.controller;

import com.danilopeixoto.api.model.ErrorResponse;
import com.danilopeixoto.api.model.GradeReportModel;
import com.danilopeixoto.api.model.StudentModel;
import com.danilopeixoto.api.service.GradeReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Tag(name = "Student grade report")
@Validated
@RequestMapping("/report")
@RestController
public class GradeReportController {
  @Autowired
  private GradeReportService gradeReportService;

  @Operation(summary = "Return student grade report.", responses = {
    @ApiResponse(
      responseCode = "200",
      content = @Content(
        schema = @Schema(implementation = GradeReportModel.class),
        mediaType = "application/json")),
    @ApiResponse(
      responseCode = "400",
      content = @Content(
        schema = @Schema(implementation = ErrorResponse.class),
        mediaType = "application/json")),
    @ApiResponse(
      responseCode = "500",
      content = @Content(
        schema = @Schema(implementation = ErrorResponse.class),
        mediaType = "application/json"))
  })
  @PostMapping
  public Mono<GradeReportModel> compute(@Valid @RequestBody Mono<StudentModel> student) {
    return this.gradeReportService.generate(student);
  }
}
