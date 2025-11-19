package com.ali.skeletonV1.repository;

import com.ali.skeletonV1.entity.EmployeeIdentification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeIdentificationRepository extends JpaRepository<EmployeeIdentification, Long> {


    Boolean existsByIdentificationValueAndIdentificationType(String identificationValue,
                                                             String identificationType);




}
