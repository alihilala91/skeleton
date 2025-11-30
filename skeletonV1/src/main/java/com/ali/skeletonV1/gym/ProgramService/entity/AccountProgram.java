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
        name = "account_program",
        schema = "skeleton",
        indexes = {@Index(name = "idx_code", columnList = "code")}
)
public class AccountProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_program_gen")
    @SequenceGenerator(name = "account_program_gen", sequenceName = "account_program_seq",
            allocationSize = 1, schema = "skeleton")
    private Long id;

    @Column(name = "account_id", nullable = false)
    private String accountId;

    @JoinColumn(name = "status", nullable = false)
    private String status;

    @CreationTimestamp
    @Column(name = "creation_Date", nullable = false)
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(name = "update_date", nullable = false)
    private LocalDateTime updateDate;

    @ManyToOne
    @JoinColumn(name = "program_details_id", referencedColumnName = "id")
    private ProgramDetails programDetails;

}
