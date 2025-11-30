package com.ali.skeletonV1.gym.GymService.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
        name = "gym_account_details",
        schema = "skeleton")
public class GymAccountDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gym_account_details_gen")
    @SequenceGenerator(name = "gym_account_details_gen", sequenceName = "gym_account_details_seq",
            allocationSize = 1, schema = "skeleton")
    private Long id;

    @Column(name = "account_id", nullable = false)
    private String accountId;

    @Column(name = "status", nullable = false)
    private String status;

    @CreationTimestamp
    @Column(name = "creation_Date", nullable = false)
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(name = "update_date", nullable = false)
    private LocalDateTime updateDate;

    @ManyToOne
    @JoinColumn(name = "gym_details_id", referencedColumnName = "id")
    private GymDetails gymDetails;

}
