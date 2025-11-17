package com.ali.skeletonV1.dto.employee.fetch.all.response;


import com.ali.skeletonV1.dto.employee.fetch.singel.response.EmployeeDetails;
import com.ali.skeletonV1.repository.pojo.employee.AllEmployeePojo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class AllEmployeeResponse {

    private Integer totalPages;
    private Long totalElements;
    private List<EmployeeDetails> employeeDetailsList;


    /**
     * Mapping Response
     *
     * @param allEmployeePojos AllEmployeePojo List
     * @return AllEmployeeResponse
     */
    public static AllEmployeeResponse mapping(final Page<AllEmployeePojo> allEmployeePojos) {

        final List<EmployeeDetails> employeeDetailsList = new ArrayList<>();

        allEmployeePojos.getContent().forEach(employee -> {
            employeeDetailsList.add(EmployeeDetails.builder()
                    .employeeNo(employee.getEmployeeNO())
                    .firstName(employee.getFirstName())
                    .lastName(employee.getLastName())
                    .creationDate(employee.getCreationDate())
                    .departmentName(employee.getDepartmentName())
                    .departmentCode(employee.getDepartmentCode())
                    .build());


        });

        return AllEmployeeResponse.builder()
                .employeeDetailsList(employeeDetailsList)
                .totalPages(allEmployeePojos.getTotalPages())
                .totalElements(allEmployeePojos.getTotalElements())
                .build();


    }
}
