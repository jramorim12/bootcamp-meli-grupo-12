package com.danilopeixoto.api.util;

import com.danilopeixoto.api.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.server.ServerWebInputException;

import java.util.Objects;

@RestControllerAdvice
public class APIExceptionHandler {
  @ExceptionHandler(ServerWebInputException.class)
  public ResponseEntity<ErrorResponse> handleBadRequest(ServerWebInputException exception) {
    return ResponseEntity
      .status(HttpStatus.BAD_REQUEST)
      .body(new ErrorResponse(
        exception instanceof WebExchangeBindException ?
          Objects.requireNonNull(
            ((WebExchangeBindException) exception)
              .getFieldError())
            .getDefaultMessage() :
          "Bad request."));
  }

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<ErrorResponse> handleInternalServerError(RuntimeException exception) {
    return ResponseEntity
      .status(HttpStatus.INTERNAL_SERVER_ERROR)
      .body(new ErrorResponse(exception.getMessage()));
  }
}
