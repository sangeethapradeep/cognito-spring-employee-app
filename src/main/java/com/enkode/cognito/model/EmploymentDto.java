package com.enkode.cognito.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonInclude(Include.NON_NULL)
public class EmploymentDto {

  @JsonIgnore private String id;
  private String position;
  private String employmentType;
  private String timeType;
  private String hireDate;
  private String yearOfService;
}
