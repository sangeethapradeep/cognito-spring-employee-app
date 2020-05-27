package com.enkode.cognito.controller;

import com.enkode.cognito.model.EmploymentDto;
import com.enkode.cognito.model.GeneralResponse;
import com.enkode.cognito.service.EmploymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employment")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class EmploymentController {
  @Autowired EmploymentService employmentService;

  @GetMapping("/{id}")
  public ResponseEntity<GeneralResponse<EmploymentDto>> getDetails(
      @PathVariable(name = "id") String empId) {

    GeneralResponse<EmploymentDto> response =
        new GeneralResponse<>(employmentService.getDetails(empId));
    return ResponseEntity.ok(response);
  }
}
