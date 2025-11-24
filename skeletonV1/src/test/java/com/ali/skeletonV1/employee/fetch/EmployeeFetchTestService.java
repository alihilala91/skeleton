package com.ali.skeletonV1.employee.fetch;

import com.ali.skeletonV1.seeds.SeedDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeFetchTestService {


    private final SeedDate seedDate;

    public void createTestEmployees() {
        seedDate.AddingTestEmployee();
    }
}
