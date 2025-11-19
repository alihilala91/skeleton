package com.ali.skeletonV1.dto.employee.create.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import jakarta.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class EmployeeCreateRequest {

    @NotNull(message = "EmployeeCreateRequest.firstName.NotNull")
    private String firstName;

    @NotNull(message = "EmployeeCreateRequest.lastName.NotNull")
    private String lastName;

    @NotNull(message = "EmployeeCreateRequest.deptCode.NotNull")
    private String deptCode;


    @NotNull(message = "EmployeeCreateRequest.identificationValue.NotNull")
    private String identificationValue;

    @NotNull(message = "EmployeeCreateRequest.identificationType.NotNull")
    private String identificationType;
}
