package com.ali.skeletonV1.employee.fetch;

import com.ali.skeletonV1.entity.Employee;
import com.ali.skeletonV1.repository.EmployeeRepository;
import com.ali.skeletonV1.seeds.SeedDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeFetchTestService {


    private final SeedDate seedDate;
    private final EmployeeRepository employeeRepository;

    public void createTestEmployees() {
        seedDate.AddingTestEmployee();
    }


    public Employee getOneEmployee() {

        return employeeRepository.findTopBy();

    }
}
