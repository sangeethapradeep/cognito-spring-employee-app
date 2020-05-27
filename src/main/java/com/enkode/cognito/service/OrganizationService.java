package com.enkode.cognito.service;

import com.enkode.cognito.exception.RequestException;
import com.enkode.cognito.model.OrganizationDto;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService {

  List<OrganizationDto> organizations =
      Arrays.asList(
          OrganizationDto.builder()
              .id("I001")
              .reportingManagerId("I002")
              .teamName("Cloud Focus")
              .effectiveFrom("17-10-2019")
              .build(),
          OrganizationDto.builder()
              .id("I002")
              .reportingManagerId("I011")
              .teamName("Cloud Focus")
              .effectiveFrom("01-04-2019")
              .build());

  public OrganizationDto getDetails(String employee) {
    Optional<OrganizationDto> employeeOrganization =
        organizations.stream()
            .filter(organization -> organization.getId().equalsIgnoreCase(employee))
            .findFirst();

    if (!employeeOrganization.isPresent()) {
      throw RequestException.NO_DATA;
    }

    return employeeOrganization.get();
  }
}
