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
        name = "exercise_attachment",
        schema = "skeleton",
        indexes = {@Index(name = "idx_code", columnList = "code")}
)
public class ExerciseAttachment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exercise_attachment_gen")
    @SequenceGenerator(name = "exercise_attachment_gen", sequenceName = "exercise_attachment_seq",
            allocationSize = 1, schema = "skeleton")
    private Long id;

    @Column(name = "url", unique = true)
    private String url;

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

    @ManyToOne
    @JoinColumn(name = "exercise_details_id", referencedColumnName = "id")
    private ExerciseDetails exerciseDetails;

}
