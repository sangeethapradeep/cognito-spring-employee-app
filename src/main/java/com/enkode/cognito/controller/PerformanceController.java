package com.enkode.cognito.controller;

import com.enkode.cognito.model.GeneralResponse;
import com.enkode.cognito.model.PerformanceDto;
import com.enkode.cognito.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/performance")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class PerformanceController {
  @Autowired PerformanceService performanceService;

  @GetMapping("/{id}")
  public ResponseEntity<GeneralResponse<PerformanceDto>> getDetails(
      @PathVariable(name = "id") String empId) {

    GeneralResponse<PerformanceDto> response =
        new GeneralResponse<>(performanceService.getDetails(empId));
    return ResponseEntity.ok(response);
  }
}
