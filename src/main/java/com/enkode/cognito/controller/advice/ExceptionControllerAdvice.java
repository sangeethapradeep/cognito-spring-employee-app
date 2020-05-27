package com.enkode.cognito.controller.advice;

import com.enkode.cognito.exception.RequestException;
import com.enkode.cognito.model.GeneralResponse;
import java.time.ZonedDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

  @ExceptionHandler(value = RequestException.class)
  public ResponseEntity<GeneralResponse> handleRequestException(RequestException ex) {
    GeneralResponse response =
        new GeneralResponse(ex.getErrorCode(), ex.getErrorDescription(), ZonedDateTime.now());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
  }
}
