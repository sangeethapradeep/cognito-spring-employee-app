package com.enkode.cognito.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonInclude(Include.NON_NULL)
public class PerformanceDto {

  @JsonIgnore private String id;
  private String lastAppraisalInPercent;
  private String lastAppraisalDate;
  private String lastbonus;
  private String lastBonusDate;
  private String approverId;
}
