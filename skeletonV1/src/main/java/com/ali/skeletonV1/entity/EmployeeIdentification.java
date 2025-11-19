package com.ali.skeletonV1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(
        name = "employee_identification",
        schema = "skeleton",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"identification_value", "identification_type"})}
)
public class EmployeeIdentification {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_identification_gen")
    @SequenceGenerator(name = "employee_identification_gen", sequenceName = "employee_identification_seq",
            allocationSize = 1)
    private Long id;

    @Column(name = "identification_value")
    private String identificationValue;

    @Column(name = "identification_type")
    private String identificationType;

    @Column(name = "status")
    private String status;

    @CreationTimestamp
    @Column(name = "creation_Date", nullable = false)
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(name = "update_date", nullable = false)
    private LocalDateTime updateDate;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ToString.Exclude
    private Employee employee;
}
