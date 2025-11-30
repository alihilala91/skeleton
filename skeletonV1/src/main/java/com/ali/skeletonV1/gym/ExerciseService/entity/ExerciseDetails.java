package com.ali.skeletonV1.gym.ExerciseService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
        name = "exercise_details",
        schema = "skeleton",
        indexes = {@Index(name = "idx_exercise_id", columnList = "exercise_id")}
)
public class ExerciseDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exercise_details_gen")
    @SequenceGenerator(name = "exercise_details_gen", sequenceName = "exercise_details_seq",
            allocationSize = 1, schema = "skeleton")
    private Long id;

    @Column(name = "exercise_id", nullable = false, unique = true)
    private String exerciseId;

    @Column(name = "exercise_name", nullable = false)
    private String exerciseName;

    @Column(name = "description")
    private String description;

    @Column(name = "default_repeat", nullable = false)
    private Integer defaultRepeat;

    @Column(name = "wight", nullable = false)
    private Double wight;

    @CreationTimestamp
    @Column(name = "creation_Date", nullable = false)
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(name = "update_date", nullable = false)
    private LocalDateTime updateDate;

    @ManyToOne
    @JoinColumn(name = "exercise_level_lookup_id", referencedColumnName = "id")
    private ExerciseLevelLookup exerciseLevel;

    @ManyToOne
    @JoinColumn(name = "muscle_type_id", referencedColumnName = "id")
    private MuscleType muscleType;

    @ManyToOne
    @JoinColumn(name = "exercise_status_id", referencedColumnName = "id")
    private ExerciseStatus status;

    @ManyToOne
    @JoinColumn(name = "machine_type_id", referencedColumnName = "id")
    private MachineType machineType;
}
