package com.ali.skeletonV1.employee.fetch.single;

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

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class EmployeeFetchSingleTest extends SkeletonV1ApplicationTests {


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
     * Test the Happy Case Senior For Fetch single Employee
     * Expected Result : Return one Employee with the below Details
     * employeeNo,firstName,lastName,creationDate,departmentName,departmentCode
     */
    @Test
    public void testNormalFlow() throws Exception {


        // Delete All Exists Record
        employeeIdentificationService.deleteAll();
        employeeService.deleteAll();
        usersService.deleteAll();

        // create Test Employee
        employeeFetchTestService.createTestEmployees();


        final String employeeNo = employeeFetchTestService.getOneEmployee().getEmployeeNo();

        // Call Fetch Single Employee By Employee No API
        final MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders.get("/v1/api/employees/" + employeeNo)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // Convert Result as String
        final String json = result.getResponse().getContentAsString();

        // Mapping to actual Response
        final EmployeeDetails response = objectMapper.readValue(json, EmployeeDetails.class);

        // Assert the Main Response Keys not null
        assertThat(response).isNotNull();

        assertThat(response.getEmployeeNo()).isNotNull();
        assertThat(response.getCreationDate()).isNotNull();
        assertThat(response.getFirstName()).isNotNull();
        assertThat(response.getLastName()).isNotNull();
        assertThat(response.getDepartmentName()).isNotNull();
        assertThat(response.getDepartmentCode()).isNotNull();


        // Assert That the Employee Number equal the Return one
        assertThat(employeeNo.equals(response.getEmployeeNo()))
                .isTrue();

    }


    /**
     * Test When the Employee Not Exists
     * Expected Result : Return Resource Exception with Key EMPLOYEE_NOT_FOUND
     */
    @Test
    public void testEmployeeNotFoundFlow() throws Exception {


        // Delete All Exists Record
        employeeIdentificationService.deleteAll();
        employeeService.deleteAll();
        usersService.deleteAll();


        final String employeeNo = UUID.randomUUID().toString();

        // Call Fetch Single Employee By Employee No API
        final MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders.get("/v1/api/employees/" + employeeNo)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();

        // Convert Result as String
        final String json = result.getResponse().getContentAsString();

        // Mapping to actual Response
        final EmployeeDetails response = objectMapper.readValue(json, EmployeeDetails.class);

        // Assert the Main Response Keys is null
        assertThat(response.getEmployeeNo()).isNull();
        assertThat(response.getCreationDate()).isNull();
        assertThat(response.getFirstName()).isNull();
        assertThat(response.getLastName()).isNull();
        assertThat(response.getDepartmentName()).isNull();
        assertThat(response.getDepartmentCode()).isNull();


    }


}

