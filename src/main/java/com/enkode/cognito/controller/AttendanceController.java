package com.enkode.cognito.controller;

import com.enkode.cognito.model.AttendanceDto;
import com.enkode.cognito.model.GeneralResponse;
import com.enkode.cognito.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attendance")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AttendanceController {

  @Autowired AttendanceService attendanceService;

  @GetMapping("/{id}")
  public ResponseEntity<GeneralResponse<AttendanceDto>> getDetails(
      @PathVariable(name = "id") String empId) {

    GeneralResponse<AttendanceDto> response =
        new GeneralResponse<>(attendanceService.getDetails(empId));
    return ResponseEntity.ok(response);
  }
}
