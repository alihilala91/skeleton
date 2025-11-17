package com.ali.skeletonV1.dto.employee.create.response;


import com.ali.skeletonV1.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class EmployeeCreateResponse {


    private String firstName;
    private String lastName;
    private String employeeNo;
    private String departmentCode;
    private String departmentName;


    /**
     * Mapping Create Employee Response
     *
     * @param employee Employee
     * @return EmployeeCreateResponse
     */
    public static EmployeeCreateResponse mapping(final Employee employee) {


        return EmployeeCreateResponse.builder()
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .employeeNo(employee.getEmployeeNo())
                .departmentCode(employee.getDepartment().getCode())
                .departmentName(employee.getDepartment().getName())
                .build();
    }
}
