package com.ali.skeletonV1.service;

import com.ali.skeletonV1.entity.Department;
import com.ali.skeletonV1.exception.ExceptionKey;
import com.ali.skeletonV1.exception.ResourceException;
import com.ali.skeletonV1.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;


    /**
     * Save Department Entity
     *
     * @param department Department
     */
    public void save(final Department department) {

        departmentRepository.save(department);
    }


    /**
     * Find Department By Code
     *
     * @param code Code
     * @return Department
     */
    public Department findByCode(final String code) {

        return departmentRepository.findByCode(code).orElseThrow(() ->
                new ResourceException(ExceptionKey.DEPARTMENT_NOT_FOUND, HttpStatus.NOT_FOUND)
        );

    }
}
