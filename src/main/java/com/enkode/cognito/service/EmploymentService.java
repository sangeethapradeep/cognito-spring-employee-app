package com.enkode.cognito.service;

import com.enkode.cognito.exception.RequestException;
import com.enkode.cognito.model.EmploymentDto;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class EmploymentService {

  List<EmploymentDto> employments =
      Arrays.asList(
          EmploymentDto.builder()
              .id("I001")
              .employmentType("Regular")
              .timeType("Full time Employment")
              .position("Software Engineer 2")
              .hireDate("01-01-2018")
              .yearOfService("2.5 years")
              .build(),
          EmploymentDto.builder()
              .id("I002")
              .employmentType("Regular")
              .timeType("Full time Employment")
              .position("Team Manager")
              .hireDate("05-06-2015")
              .yearOfService("5 years")
              .build());

  public EmploymentDto getDetails(String employee) {
    Optional<EmploymentDto> employeeEmployment =
        employments.stream()
            .filter(employment -> employment.getId().equalsIgnoreCase(employee))
            .findFirst();

    if (!employeeEmployment.isPresent()) {
      throw RequestException.NO_DATA;
    }

    return employeeEmployment.get();
  }
}
