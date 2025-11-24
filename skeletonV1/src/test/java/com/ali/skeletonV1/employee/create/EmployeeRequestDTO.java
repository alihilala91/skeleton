package com.ali.skeletonV1.employee.create;


import com.ali.skeletonV1.enums.employee.EmployeeIdentificationTypeEnums;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode
public class EmployeeRequestDTO {

    private String firstName;
    private String lastName;
    private String deptCode;
    private String identificationValue;
    private String identificationType;

    public static EmployeeRequestDTO normalFlow() {

        return EmployeeRequestDTO.builder()
                .firstName("Ali")
                .lastName("Hilal")
                .deptCode("001")
                .identificationValue(UUID.randomUUID().toString())
                .identificationType(EmployeeIdentificationTypeEnums.NATIONAL_ID.name())
                .build();


    }
}
