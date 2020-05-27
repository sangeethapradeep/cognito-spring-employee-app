package com.enkode.cognito.service;

import com.enkode.cognito.exception.RequestException;
import com.enkode.cognito.model.ProfileDto;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

  private List<ProfileDto> profiles =
      Arrays.asList(
          ProfileDto.builder()
              .id("I001")
              .fullName("Sangeetha Pradeep")
              .gender("Female")
              .dateOfBirth("17-10-1994")
              .email("sangeetha@gmail.com")
              .phone("+91 9999999999")
              .citizenShip("Indian")
              .location("Bangalore")
              .maritalStatus("Single")
              .build(),
          ProfileDto.builder()
              .id("I002")
              .fullName("John Doe")
              .gender("Male")
              .dateOfBirth("09-07-1984")
              .email("john.doe@gmail.com")
              .phone("+91 9999999999")
              .citizenShip("French")
              .location("Bangalore")
              .maritalStatus("Married")
              .build());

  public ProfileDto getDetails(String employee) {
    Optional<ProfileDto> employeeProfile =
        profiles.stream().filter(profile -> profile.getId().equalsIgnoreCase(employee)).findFirst();

    if (!employeeProfile.isPresent()) {
      throw RequestException.NO_DATA;
    }

    return employeeProfile.get();
  }
}
