package com.enkode.cognito.service;

import com.enkode.cognito.exception.RequestException;
import com.enkode.cognito.model.AttendanceDto;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {

  private List<AttendanceDto> attendances =
      Arrays.asList(
          AttendanceDto.builder()
              .id("I001")
              .totalNoOfWorkingDays("230 days")
              .currentFiscalYear("2019-2020")
              .noOfAttendedDays("210 days")
              .noOfCasualLeavesTaken("7 days")
              .noOfSickLeavesTaken("7 days")
              .noOfUnPaidLeavesTaken("6 days")
              .build(),
          AttendanceDto.builder()
              .id("I002")
              .totalNoOfWorkingDays("230 days")
              .currentFiscalYear("2019-2020")
              .noOfAttendedDays("220 days")
              .noOfCasualLeavesTaken("4 days")
              .noOfSickLeavesTaken("6 days")
              .build());

  public AttendanceDto getDetails(String employee) {
    Optional<AttendanceDto> employeeAttendance =
        attendances.stream()
            .filter(attendance -> attendance.getId().equalsIgnoreCase(employee))
            .findFirst();

    if (!employeeAttendance.isPresent()) {
      throw RequestException.NO_DATA;
    }

    return employeeAttendance.get();
  }
}
