package com.enkode.cognito.controller;

import com.enkode.cognito.model.GeneralResponse;
import java.security.Principal;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {

  @GetMapping("/message")
  public ResponseEntity<GeneralResponse<String>> message(Principal principal) {
    GeneralResponse<String> response = new GeneralResponse<>("Admin message for " + principal.getName());
    return ResponseEntity.ok(response);
  }
}
