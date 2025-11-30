package com.ali.skeletonV1.gym.ProgramService.entity;

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
        name = "program_exercise",
        schema = "skeleton",
        indexes = {@Index(name = "idx_code", columnList = "code")}
)
public class ExerciseRepetition {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "program_exercise_gen")
    @SequenceGenerator(name = "program_exercise_gen", sequenceName = "program_exercise_seq",
            allocationSize = 1, schema = "skeleton")
    private Long id;

    @Column(name = "code", unique = true)
    private String code;

    @Column(name = "description")
    private String description;

    @Column(name = "min", nullable = false)
    private Integer min;

    @Column(name = "max", nullable = false)
    private String max;

    @Column(name = "status", nullable = false)
    private String status;

    @CreationTimestamp
    @Column(name = "creation_Date", nullable = false)
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(name = "update_date", nullable = false)
    private LocalDateTime updateDate;
}
