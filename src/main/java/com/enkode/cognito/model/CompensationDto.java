package com.enkode.cognito.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonInclude(Include.NON_NULL)
public class CompensationDto {

  @JsonIgnore private String id;
  private String totalCompensation;
  private String basePay;
  private String variablePay;
  private String frequency;
  private String effectiveFrom;
}
