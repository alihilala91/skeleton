package com.ali.skeletonV1.service;

import com.ali.skeletonV1.dto.employee.create.request.EmployeeCreateRequest;
import com.ali.skeletonV1.dto.employee.create.response.EmployeeCreateResponse;
import com.ali.skeletonV1.dto.employee.fetch.all.response.AllEmployeeResponse;
import com.ali.skeletonV1.dto.employee.fetch.singel.response.EmployeeDetails;
import com.ali.skeletonV1.entity.Department;
import com.ali.skeletonV1.entity.Employee;
import com.ali.skeletonV1.exception.ExceptionKey;
import com.ali.skeletonV1.exception.ResourceException;
import com.ali.skeletonV1.repository.EmployeeRepository;
import com.ali.skeletonV1.repository.pojo.employee.AllEmployeePojo;
import com.ali.skeletonV1.repository.pojo.employee.EmployeeDetailsPojo;
import com.ali.skeletonV1.utils.Utility;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentService departmentService;


    /**
     * SAve Employee in the Database
     *
     * @param employee Employee
     * @return Employee
     */
    public Employee save(final Employee employee) {

        return employeeRepository.save(employee);
    }


    /**
     * Find Employee By Employee Number
     *
     * @param employeeNo Employee ID
     * @param request    Http Servlet Request
     * @return EmployeeDetails
     */
    public EmployeeDetails findEmployeeByEmployeeNumber(final String employeeNo, final HttpServletRequest request) {


        // Find Locale
        final Locale locale = Utility.getLocale(request);

        // Fetch Employee Details By Employee Number
        EmployeeDetailsPojo employeeDetailsPojo = employeeRepository.getEmployeeDetails(employeeNo).orElseThrow(() ->
                new ResourceException(ExceptionKey.EMPLOYEE_NOT_FOUND, HttpStatus.NOT_FOUND));

        // Mapping Response
        return EmployeeDetails.mapping(employeeDetailsPojo);
    }


    /**
     * Create new Employee
     *
     * @param employeeCreateRequest EmployeeCreateRequest
     * @param request               HttpServletRequest
     * @return EmployeeDetails
     */
    public EmployeeCreateResponse create(final EmployeeCreateRequest employeeCreateRequest,
                                         final HttpServletRequest request) {

        // Find Locale
        final Locale locale = Utility.getLocale(request);

        // Validate Department Code
        final Department department = departmentService.findByCode(employeeCreateRequest.getDeptCode());

        // Generate Employee Number
        final String employeeNumber = generateEmployeeNumber();

        // create Employee
        final Employee employee = save(Employee.builder()
                .firstName(employeeCreateRequest.getFirstName().toUpperCase())
                .lastName(employeeCreateRequest.getLastName().toUpperCase())
                .department(department)
                .employeeNo(employeeNumber)
                .build());

        // Mapping Response
        return EmployeeCreateResponse.mapping(employee);


    }


    /**
     * Generate Employee Number
     *
     * @return String
     */
    private String generateEmployeeNumber() {

        return UUID.randomUUID().toString();
    }


    /**
     * Find All Employee Details
     *
     * @param deptCode   Department code
     * @param firstName  First Name
     * @param lastName   Last Name
     * @param employeeNo Employee Number
     * @param pageNumber Page Number
     * @param pageSize   Page Size
     * @param request    HttpServletRequest
     * @return AllEmployeeResponse
     */
    public AllEmployeeResponse findAll(final String deptCode,
                                       final String firstName,
                                       final String lastName,
                                       final String employeeNo,
                                       final Integer pageNumber,
                                       final Integer pageSize,
                                       final HttpServletRequest request) {

        // Create Pageable Config
        final Pageable pageable = PageRequest.of(pageNumber, pageSize,
                Sort.by(Sort.Direction.DESC, "update_date"));

        // Prepare parameters safely
        final String first = firstName != null ? firstName.toUpperCase() : null;
        final String last = lastName != null ? lastName.toUpperCase() : null;

        // Fetch All Employee
        final Page<AllEmployeePojo> allEmployeePojos = employeeRepository.findAllEmployee(
                deptCode,
                first,
                last,
                employeeNo,
                pageable);


        // Mapping Response
        return AllEmployeeResponse.mapping(allEmployeePojos);
    }
}
