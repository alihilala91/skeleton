package com.ali.skeletonV1.entity;


import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import jakarta.persistence.Column;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "employee", schema = "skeleton")
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_gen")
    @SequenceGenerator(name = "employee_gen", sequenceName = "employee_seq", allocationSize = 1)
    private Long id;

    @Column(name = "employee_no", nullable = false, unique = true)
    private String employeeNo;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "status")
    private String status;

    @CreationTimestamp
    @Column(name = "creation_Date", nullable = false)
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(name = "update_date", nullable = false)
    private LocalDateTime updateDate;


    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;


}
