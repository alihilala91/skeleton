package com.ali.skeletonV1.service;

import com.ali.skeletonV1.entity.EmployeeIdentification;
import com.ali.skeletonV1.repository.EmployeeIdentificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeIdentificationService {


    private final EmployeeIdentificationRepository employeeIdentificationRepository;


    /**
     * Save Employee Identification Details
     *
     * @param employeeIdentification Employee Identification Details
     * @return EmployeeIdentification
     */
    public EmployeeIdentification save(final EmployeeIdentification employeeIdentification) {

        return employeeIdentificationRepository.save(employeeIdentification);
    }


    /**
     * Check if Employee IDentification Details Exists
     *
     * @param identificationValue Identification Value
     * @param identificationType  Identification Type
     * @return Boolean
     */
    public Boolean isIdentificationExists(final String identificationValue,
                                          final String identificationType) {
        return employeeIdentificationRepository.existsByIdentificationValueAndIdentificationType(identificationValue,
                identificationType);
    }


    /**
     * This Method Used  for Testing
     * Delete All Records
     */
    public void deleteAll() {
        employeeIdentificationRepository.deleteAll();
    }

}
