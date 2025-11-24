package com.ali.skeletonV1.employee.create;

import com.ali.skeletonV1.SkeletonV1ApplicationTests;
import com.ali.skeletonV1.entity.Department;
import com.ali.skeletonV1.entity.Employee;
import com.ali.skeletonV1.enums.employee.EmployeeStatus;
import com.ali.skeletonV1.service.EmployeeIdentificationService;
import com.ali.skeletonV1.service.EmployeeService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class EmployeeCreationTest extends SkeletonV1ApplicationTests {


    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeIdentificationService employeeIdentificationService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    /**
     * Test the Happy Case Senior For Create Employee
     * Result: Employee Created Successfully
     */
    @Test
    public void testNormalFlow() throws Exception {


        // Delete All Exists User
        employeeIdentificationService.deleteAll();
        employeeService.deleteAll();

        // Prepare Create Employee Request
        final EmployeeRequestDTO request = EmployeeRequestDTO.normalFlow();

        // Mapping Request as JSON
        final String requestDetails = objectMapper.writeValueAsString(request);


        // Call Create Employee APIs
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/api/employees")
                        .content(requestDetails)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();


        // Get the Actual Created Employee
        final Employee actualEmployee = employeeService.findByIdentificationValueAndType(request.getIdentificationValue(),
                request.getIdentificationType());


        // Create the Excepted Employee
        final Employee exceptedEmployee = Employee.builder()
                .employeeNo(actualEmployee.getEmployeeNo())
                .firstName(request.getFirstName().toUpperCase())
                .lastName(request.getLastName().toUpperCase())
                .status(EmployeeStatus.ACTIVE.name())
                .department(Department.builder()
                        .code(request.getDeptCode())
                        .build())
                .build();

        // Assert the Result is True ( actualEmployee == exceptedEmployee)
        assertThat(actualEmployee.equals(exceptedEmployee))
                .isTrue();

    }


    /**
     * Test the Duplicated Employee Identifications
     * Result: Throw Resource Exception with Key EMPLOYEE_IDENTIFICATION_EXISTS
     */
    @Test
    public void testDuplicatedEmployeeIdentificationFlow() throws Exception {


        // Delete All Exists User
        employeeIdentificationService.deleteAll();
        employeeService.deleteAll();


        // Prepare Create Employee Request
        final EmployeeRequestDTO request = EmployeeRequestDTO.normalFlow();

        // Mapping Request as JSON
        final String requestDetails = objectMapper.writeValueAsString(request);

        // Create Employee for the First Time
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/api/employees")
                        .content(requestDetails)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();


        // Create Employee for the Second Time
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/api/employees")
                        .content(requestDetails)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isFound())
                .andReturn();


        // Get the Actual Created Employee
        final Employee actualEmployee = employeeService.findByIdentificationValueAndType(request.getIdentificationValue(),
                request.getIdentificationType());


        // Create the Excepted Employee
        final Employee exceptedEmployee = Employee.builder()
                .employeeNo(actualEmployee.getEmployeeNo())
                .firstName(request.getFirstName().toUpperCase())
                .lastName(request.getLastName().toUpperCase())
                .status(EmployeeStatus.ACTIVE.name())
                .department(Department.builder()
                        .code(request.getDeptCode())
                        .build())
                .build();

        // Assert the Result is True ( actualEmployee == exceptedEmployee)
        assertThat(actualEmployee.equals(exceptedEmployee))
                .isTrue();

    }


    /**
     * Test the Department not Exists when try to create  Customer
     * Result: Throw Resource Exception with Key DEPARTMENT_NOT_FOUND
     */
    @Test
    public void testEmployeeDepartmentNotFoundFlow() throws Exception {


        // Delete All Exists User
        employeeIdentificationService.deleteAll();
        employeeService.deleteAll();

        // Initialized for Object Mapper
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        // Prepare Create Employee Request
        final EmployeeRequestDTO request = EmployeeRequestDTO.normalFlow();
        request.setDeptCode("002");

        // Mapping Request as JSON
        final String requestDetails = objectMapper.writeValueAsString(request);


        // Call Create Employee APIs
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/api/employees")
                        .content(requestDetails)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();

        Employee actualEmployee = null;

        try {
            // Attempt to fetch the employee (should not exist)
            actualEmployee = employeeService.findByIdentificationValueAndType(request.getIdentificationValue(),
                    request.getIdentificationType());
        } catch (final Exception e) {
            // Expected: employee does not exist
        }


        // Assert the employee was not created
        assertThat(actualEmployee).isNull();

    }


    /**
     * Test the Create Employee with Missing Create Request Param
     * Result: Throw Resource Exception with Http Status 400
     */
    @Test
    public void testCreateEmployeeWithMissingParamFlow() throws Exception {


        // Delete All Exists User
        employeeIdentificationService.deleteAll();
        employeeService.deleteAll();


        // Prepare Create Employee Request
        final EmployeeRequestDTO request = EmployeeRequestDTO.normalFlow();
        request.setFirstName(null);
        request.setLastName(null);

        // Mapping Request as JSON
        final String requestDetails = objectMapper.writeValueAsString(request);


        // Call Create Employee APIs
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/api/employees")
                        .content(requestDetails)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();


        Employee actualEmployee = null;
        try {
            // Attempt to fetch the employee (should not exist)
            actualEmployee = employeeService.findByIdentificationValueAndType(request.getIdentificationValue(),
                    request.getIdentificationType());
        } catch (final Exception e) {
            // Expected: employee does not exist
        }


        // Assert the employee was not created
        assertThat(actualEmployee).isNull();
        ;

    }


    /**
     * Test the Create Employee with Invalid Employee Identification Type
     * Result: Throw Resource Exception Error Code EMPLOYEE_IDENTIFICATION_TYPE_NOT_VALID
     */
    @Test
    public void testCreateEmployeeWithInvalidIdentificationTypeFlow() throws Exception {


        // Delete All Exists User
        employeeIdentificationService.deleteAll();
        employeeService.deleteAll();


        // Prepare Create Employee Request
        final EmployeeRequestDTO request = EmployeeRequestDTO.normalFlow();
        request.setIdentificationType("TestType");


        // Mapping Request as JSON
        final String requestDetails = objectMapper.writeValueAsString(request);


        // Call Create Employee APIs
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/api/employees")
                        .content(requestDetails)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotAcceptable())
                .andReturn();


        Employee actualEmployee = null;
        try {
            // Attempt to fetch the employee (should not exist)
            actualEmployee = employeeService.findByIdentificationValueAndType(request.getIdentificationValue(),
                    request.getIdentificationType());
        } catch (final Exception e) {
            // Expected: employee does not exist
        }


        // Assert the employee was not created
        assertThat(actualEmployee).isNull();
        ;

    }
}
