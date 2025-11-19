package com.ali.skeletonV1.repository;

import com.ali.skeletonV1.entity.Employee;
import com.ali.skeletonV1.repository.pojo.employee.AllEmployeePojo;
import com.ali.skeletonV1.repository.pojo.employee.EmployeeDetailsPojo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    @Query(value = " select emp.employee_no   as employeeNO," +
            "       emp.last_name     as lastName," +
            "       emp.first_name    as firstName," +
            "       emp.creation_date as creationDate," +
            "       d.name            as departmentName," +
            "       d.code            as DepartmentCode" +
            " from skeleton.employee emp" +
            "         join skeleton.department d on emp.department_id = d.id" +
            " where emp.employee_no = :employeeNo"
            , nativeQuery = true)
    Optional<EmployeeDetailsPojo> getEmployeeDetails(@Param("employeeNo") String employeeNo);


    @Query(value = "select emp.employee_no   as employeeNO," +
            "       emp.last_name     as lastName," +
            "       emp.first_name    as firstName," +
            "       emp.creation_date as creationDate," +
            "       d.name            as departmentName," +
            "       d.code            as DepartmentCode" +
            " from skeleton.employee emp" +
            "         join skeleton.department d on emp.department_id = d.id" +
            " where (:employeeNo is null or emp.employee_no = :employeeNo)" +
            "  and (:firstName is null or emp.first_name like :firstName%)" +
            "  and (:lastName is null or emp.last_name like %:lastName)" +
            "  and (:deptCode is null or d.code = :deptCode)", nativeQuery = true)
    Page<AllEmployeePojo> findAllEmployee(@Param("deptCode") String deptCode,
                                          @Param("firstName") String firstName,
                                          @Param("lastName") String lastName,
                                          @Param("employeeNo") String employeeNo,
                                          Pageable pageable);
}
