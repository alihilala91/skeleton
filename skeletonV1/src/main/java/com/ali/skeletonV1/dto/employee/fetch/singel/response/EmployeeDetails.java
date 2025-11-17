package com.ali.skeletonV1.dto.employee.fetch.singel.response;

import com.ali.skeletonV1.repository.pojo.employee.EmployeeDetailsPojo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class EmployeeDetails {


    private String employeeNo;
    private String firstName;
    private String lastName;
    private LocalDateTime creationDate;
    private String departmentName;
    private String departmentCode;


    /**
     * Mapping The EmployeeDetailsPojo to the  EmployeeDetails
     *
     * @param employeeDetailsPojo EmployeeDetails
     * @return EmployeeDetails
     */
    public static EmployeeDetails mapping(final EmployeeDetailsPojo employeeDetailsPojo) {

        return EmployeeDetails.builder()
                .employeeNo(employeeDetailsPojo.getEmployeeNO())
                .firstName(employeeDetailsPojo.getFirstName())
                .lastName(employeeDetailsPojo.getLastName())
                .creationDate(employeeDetailsPojo.getCreationDate())
                .departmentName(employeeDetailsPojo.getDepartmentName())
                .departmentCode(employeeDetailsPojo.getDepartmentCode())
                .build();

    }
}
