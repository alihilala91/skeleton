package com.ali.skeletonV1.gym.ProgramService.entity;

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
        name = "program_details",
        schema = "skeleton",
        indexes = {@Index(name = "idx_code", columnList = "code")}
)
public class ProgramDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "program_details_gen")
    @SequenceGenerator(name = "program_details_gen", sequenceName = "program_details_seq",
            allocationSize = 1, schema = "skeleton")
    private Long id;


    @Column(name = "gym_id", nullable = false, unique = true)
    private String gymId;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @CreationTimestamp
    @Column(name = "creation_Date", nullable = false)
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(name = "update_date", nullable = false)
    private LocalDateTime updateDate;

    @ManyToOne
    @JoinColumn(name = "program_level_lookup_id", referencedColumnName = "id")
    private ProgramLevelLookup programLevel;

    @ManyToOne
    @JoinColumn(name = "program_status_id", referencedColumnName = "id")
    private ProgramStatus status;
}
