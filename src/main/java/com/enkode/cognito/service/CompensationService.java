package com.enkode.cognito.service;

import com.enkode.cognito.exception.RequestException;
import com.enkode.cognito.model.CompensationDto;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CompensationService {

  List<CompensationDto> compensations =
      Arrays.asList(
          CompensationDto.builder()
              .id("I001")
              .basePay("9,00,000 ₹")
              .totalCompensation("10,00,000 ₹")
              .variablePay("1,00,000 ₹")
              .effectiveFrom("01-01-2020")
              .frequency("Annual")
              .build(),
          CompensationDto.builder()
              .id("I002")
              .basePay("25,00,000 ₹")
              .totalCompensation("25,00,000 ₹")
              .variablePay("NIL")
              .effectiveFrom("01-04-2019")
              .frequency("Annual")
              .build());

  public CompensationDto getDetails(String employee) {
    Optional<CompensationDto> employeeCompensation =
        compensations.stream()
            .filter(compensation -> compensation.getId().equalsIgnoreCase(employee))
            .findFirst();

    if (!employeeCompensation.isPresent()) {
      throw RequestException.NO_DATA;
    }

    return employeeCompensation.get();
  }
}
