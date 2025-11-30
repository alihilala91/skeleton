package com.ali.skeletonV1.gym.GymService.entity;

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
        name = "gym_status_lookup",
        schema = "skeleton",
        indexes = {@Index(name = "idx_code", columnList = "code")}
)
public class GymStatusLookup {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gym_status_lookup_gen")
    @SequenceGenerator(name = "gym_status_lookup_gen", sequenceName = "gym_status_lookup_seq",
            allocationSize = 1, schema = "skeleton")
    private Long id;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "description")
    private String description;

    @CreationTimestamp
    @Column(name = "creation_Date", nullable = false)
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(name = "update_date", nullable = false)
    private LocalDateTime updateDate;
    ;
}
