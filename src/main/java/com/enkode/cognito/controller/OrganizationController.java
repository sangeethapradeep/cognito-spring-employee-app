package com.enkode.cognito.controller;

import com.enkode.cognito.model.GeneralResponse;
import com.enkode.cognito.model.OrganizationDto;
import com.enkode.cognito.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/organization")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class OrganizationController {
  @Autowired OrganizationService organizationService;

  @GetMapping("/{id}")
  public ResponseEntity<GeneralResponse<OrganizationDto>> getDetails(
      @PathVariable(name = "id") String empId) {

    GeneralResponse<OrganizationDto> response =
        new GeneralResponse<>(organizationService.getDetails(empId));
    return ResponseEntity.ok(response);
  }
}
