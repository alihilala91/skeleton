package com.ali.skeletonV1.employee.fetch.patch;

import com.ali.skeletonV1.SkeletonV1ApplicationTests;
import com.ali.skeletonV1.dto.employee.fetch.all.response.AllEmployeeResponse;
import com.ali.skeletonV1.dto.employee.fetch.singel.response.EmployeeDetails;
import com.ali.skeletonV1.employee.fetch.EmployeeFetchTestService;
import com.ali.skeletonV1.service.EmployeeIdentificationService;
import com.ali.skeletonV1.service.EmployeeService;
import com.ali.skeletonV1.service.UsersService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class EmployeeFetchPatchTest extends SkeletonV1ApplicationTests {


    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeIdentificationService employeeIdentificationService;


    @Autowired
    private UsersService usersService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Autowired
    private EmployeeFetchTestService employeeFetchTestService;


    /**
     * Test the Happy Case Senior For Fetch Patch Of Employee
     * Expected Result : Return a List of Employee with the below Details
     * totalPages,totalElements,employeeNo,firstName,lastName,creationDate,departmentName,departmentCode
     */
    @Test
    public void testNormalFlow() throws Exception {


        // Delete All Exists Record
        employeeIdentificationService.deleteAll();
        employeeService.deleteAll();
        usersService.deleteAll();

        // create Test Employee
        employeeFetchTestService.createTestEmployees();

        // Call Fetch All Employee API
        final MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders.get("/v1/api/employees")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // Convert Result as String
        final String json = result.getResponse().getContentAsString();

        // Mapping to actual Response
        final AllEmployeeResponse response = objectMapper.readValue(json, AllEmployeeResponse.class);

        // Assert the Main Response Keys not null
        assertThat(response).isNotNull();
        assertThat(response.getTotalPages()).isNotNull();
        assertThat(response.getTotalElements()).isNotNull();
        assertThat(response.getEmployeeDetailsList()).isNotNull();


        response.getEmployeeDetailsList().forEach(employee -> {
            assertThat(employee.getEmployeeNo()).isNotNull();
            assertThat(employee.getCreationDate()).isNotNull();
            assertThat(employee.getFirstName()).isNotNull();
            assertThat(employee.getLastName()).isNotNull();
            assertThat(employee.getDepartmentName()).isNotNull();
            assertThat(employee.getDepartmentCode()).isNotNull();

        });


        // Assert That the Page Size is 10 as Default Value
        assertThat(response.getEmployeeDetailsList().size() == 10)
                .isTrue();

    }



}
