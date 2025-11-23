package com.ali.skeletonV1.controller;

import com.ali.skeletonV1.constant.SystemConstant;
import com.ali.skeletonV1.dto.employee.create.request.EmployeeCreateRequest;
import com.ali.skeletonV1.dto.employee.create.response.EmployeeCreateResponse;
import com.ali.skeletonV1.dto.employee.fetch.all.response.AllEmployeeResponse;
import com.ali.skeletonV1.dto.employee.fetch.singel.response.EmployeeDetails;
import com.ali.skeletonV1.service.EmployeeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("v1/api/employees")
@RequiredArgsConstructor
public class EmployeeController {


    private final EmployeeService employeeService;


    /**
     * Create new Employee
     *
     * @param employeeCreateRequest EmployeeCreateRequest
     * @param request               HttpServletRequest
     * @return EmployeeDetails
     */
    @PostMapping
    public ResponseEntity<EmployeeCreateResponse> create(
            @RequestBody @Valid final EmployeeCreateRequest employeeCreateRequest,
            final HttpServletRequest request) {

        // Create New Employee
        final EmployeeCreateResponse response = employeeService.create(employeeCreateRequest, request);

        // Return Response
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }


    /**
     * Fetch Employee Details By Employee Number
     *
     * @param employeeNumber Employee Number
     * @param request        HttpServletRequest
     * @return EmployeeDetails
     */
    @GetMapping("/{employeeNumber}")
    public ResponseEntity<EmployeeDetails> findById(@PathVariable String employeeNumber,
                                                    final HttpServletRequest request) {

        // Find Employee By ID
        final EmployeeDetails employeeDetails = employeeService.findEmployeeByEmployeeNumber(employeeNumber, request);


        // Return Response
        return new ResponseEntity<>(employeeDetails, HttpStatus.OK);

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
    @GetMapping
    public ResponseEntity<AllEmployeeResponse> findAll(
            @RequestParam(required = false) final String deptCode,
            @RequestParam(required = false) final String firstName,
            @RequestParam(required = false) final String lastName,
            @RequestParam(required = false) final String employeeNo,
            @RequestParam(required = false, defaultValue = SystemConstant.PAGE_NUMBER) final Integer pageNumber,
            @RequestParam(required = false, defaultValue = SystemConstant.PAGE_SIZE) final Integer pageSize,
            final HttpServletRequest request) {

        // Find All Employee
        final AllEmployeeResponse response = employeeService.findAll(
                deptCode,
                firstName,
                lastName,
                employeeNo,
                pageNumber,
                pageSize,
                request);

        // Return Response
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
