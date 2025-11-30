package com.ali.skeletonV1.gym.ExerciseService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(
        name = "machine_type",
        schema = "skeleton",
        indexes = {@Index(name = "idx_code", columnList = "code")}
)
public class MachineType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "machine_type_gen")
    @SequenceGenerator(name = "machine_type_gen", sequenceName = "machine_type_seq",
            allocationSize = 1, schema = "skeleton")
    private Long id;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "description")
    private String description;

    @CreationTimestamp
    @Column(name = "creation_Date", nullable = false)
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(name = "update_date", nullable = false)
    private LocalDateTime updateDate;
}
