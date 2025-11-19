package com.ali.skeletonV1.seeds;


import com.ali.skeletonV1.dto.employee.create.request.EmployeeCreateRequest;
import com.ali.skeletonV1.entity.Department;
import com.ali.skeletonV1.enums.employee.EmployeeIdentificationTypeEnums;
import com.ali.skeletonV1.service.DepartmentService;
import com.ali.skeletonV1.service.EmployeeIdentificationService;
import com.ali.skeletonV1.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.PostLoad;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
@RequiredArgsConstructor
public class SeedDate {


    private final DepartmentService departmentService;

    private final EmployeeIdentificationService employeeIdentificationService;

    private final EmployeeService employeeService;


    @PostConstruct
    public void addDepartments() {

        employeeIdentificationService.deleteAll();

        employeeService.deleteAll();

        departmentService.deleteAll();

        List<String> names = new ArrayList<>();
        names.add("Ali");
        names.add("Adnan");
        names.add("Hilal");
        names.add("Ahmad");
        names.add("Khaled");
        names.add("Mohammed");
        names.add("Sharif");
        names.add("Osama");
        names.add("Oday");


        // Create Department
        departmentService.save(Department.builder()
                .code("001")
                .name("Department One")
                .build());


        for (int i = 0; i < 100; i++) {

            int firstnameNumber = ThreadLocalRandom.current().nextInt(0, 9);
            int lastNameNumber = ThreadLocalRandom.current().nextInt(0, 9);


            String identification = String.valueOf(
                    ThreadLocalRandom.current().nextLong(1_000_000_000L, 10_000_000_000L)
            );

            employeeService.create(EmployeeCreateRequest.builder()
                    .firstName(names.get(firstnameNumber))
                    .lastName(names.get(lastNameNumber))
                    .identificationValue(identification)
                    .identificationType(EmployeeIdentificationTypeEnums.NATIONAL_ID.name())
                    .deptCode("001")
                    .build(), null);

        }
    }
}
