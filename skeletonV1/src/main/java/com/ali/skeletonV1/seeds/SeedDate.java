package com.ali.skeletonV1.seeds;


import com.ali.skeletonV1.dto.employee.create.request.EmployeeCreateRequest;
import com.ali.skeletonV1.entity.Department;
import com.ali.skeletonV1.entity.UserRole;
import com.ali.skeletonV1.entity.Users;
import com.ali.skeletonV1.enums.employee.EmployeeIdentificationTypeEnums;
import com.ali.skeletonV1.enums.user.UserRoleEnums;
import com.ali.skeletonV1.enums.user.UserRoleStatus;
import com.ali.skeletonV1.enums.user.UsersStatus;
import com.ali.skeletonV1.service.DepartmentService;
import com.ali.skeletonV1.service.EmployeeIdentificationService;
import com.ali.skeletonV1.service.EmployeeService;
import com.ali.skeletonV1.service.UserRoleService;
import com.ali.skeletonV1.service.UsersService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Component
@RequiredArgsConstructor
public class SeedDate {
    
    private final DepartmentService departmentService;
    private final EmployeeIdentificationService employeeIdentificationService;
    private final EmployeeService employeeService;
    private final UsersService usersService;
    private final UserRoleService userRoleService;


    @PostConstruct
    public void AddingTestEmployee() {

        employeeIdentificationService.deleteAll();
        employeeService.deleteAll();
        departmentService.deleteAll();
        usersService.deleteAll();


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


        final UserRole employeeRole = userRoleService.findByCode(UserRoleEnums.EMPLOYEE.name(),
                UserRoleStatus.ACTIVE.name(), Locale.ENGLISH);


        for (int i = 0; i < 100; i++) {

            int firstnameNumber = ThreadLocalRandom.current().nextInt(0, 9);
            int lastNameNumber = ThreadLocalRandom.current().nextInt(0, 9);


            String identification = String.valueOf(
                    ThreadLocalRandom.current().nextLong(1_000_000_000L, 10_000_000_000L)
            );


            // Create Employee
            employeeService.create(EmployeeCreateRequest.builder()
                    .firstName(names.get(firstnameNumber))
                    .lastName(names.get(lastNameNumber))
                    .identificationValue(identification)
                    .identificationType(EmployeeIdentificationTypeEnums.NATIONAL_ID.name())
                    .deptCode("001")
                    .build(), null);


            // Create User
            usersService.save(Users.builder()
                    .username(buildUsername(names.get(firstnameNumber), names.get(lastNameNumber)))
                    .password(UUID.randomUUID().toString())
                    .status(UsersStatus.ACTIVE.name())
                    .userRole(employeeRole)
                    .build());


        }


    }

    /**
     * Generate a Generale Username
     *
     * @param firstName Firstname
     * @param lastName  Lastname
     * @return username
     */
    private String buildUsername(final String firstName, final String lastName) {

        return firstName.substring(0, 1).toUpperCase() +
                "." +
                lastName.toUpperCase()
                + UUID.randomUUID().toString().substring(0, 4);

    }
}
