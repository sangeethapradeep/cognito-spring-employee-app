package com.enkode.cognito.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonInclude(Include.NON_NULL)
public class ProfileDto {

  private String id;
  private String fullName;
  private String gender;
  private String dateOfBirth;
  private String phone;
  private String email;
  private String location;
  private String maritalStatus;
  private String citizenShip;
}
