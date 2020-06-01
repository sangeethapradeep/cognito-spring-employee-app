package com.enkode.cognito.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
@JsonInclude(Include.NON_NULL)
public class AttendanceDto {

  @JsonIgnore private String id;
  private String currentFiscalYear;
  private String totalNoOfWorkingDays;
  private String noOfAttendedDays;
  private String noOfCasualLeavesTaken;
  private String noOfSickLeavesTaken;
  private String noOfUnPaidLeavesTaken;
}
