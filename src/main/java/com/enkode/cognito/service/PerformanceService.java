package com.enkode.cognito.service;

import com.enkode.cognito.exception.RequestException;
import com.enkode.cognito.model.PerformanceDto;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PerformanceService {

  List<PerformanceDto> performances =
      Arrays.asList(
          PerformanceDto.builder()
              .id("I001")
              .lastAppraisalDate("01-01-2020")
              .lastBonusDate("NIL")
              .lastAppraisalInPercent("21.2 %")
              .lastbonus("NIL")
              .approverId("I002")
              .build(),
          PerformanceDto.builder()
              .id("I002")
              .lastAppraisalDate("01-04-2020")
              .lastBonusDate("30-03-2020")
              .lastAppraisalInPercent("17 %")
              .lastbonus("5,00,00 ₹")
              .approverId("I011")
              .build());

  public PerformanceDto getDetails(String employee) {
    Optional<PerformanceDto> employeePerformance =
        performances.stream()
            .filter(performance -> performance.getId().equalsIgnoreCase(employee))
            .findFirst();

    if (!employeePerformance.isPresent()) {
      throw RequestException.NO_DATA;
    }

    return employeePerformance.get();
  }
}
