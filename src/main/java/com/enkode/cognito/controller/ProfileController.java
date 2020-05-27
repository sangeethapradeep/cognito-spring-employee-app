package com.enkode.cognito.controller;

import com.enkode.cognito.model.GeneralResponse;
import com.enkode.cognito.model.ProfileDto;
import com.enkode.cognito.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class ProfileController {

  @Autowired ProfileService profileService;

  @GetMapping("/{id}")
  public ResponseEntity<GeneralResponse<ProfileDto>> getDetails(
      @PathVariable(name = "id") String empId) {

    GeneralResponse<ProfileDto> response = new GeneralResponse<>(profileService.getDetails(empId));
    return ResponseEntity.ok(response);
  }
}
