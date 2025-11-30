package com.ali.skeletonV1.gym.GymService.entity;


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
        name = "gym_details",
        schema = "skeleton",
        indexes = {@Index(name = "idx_code", columnList = "code")}
)
public class GymDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gym_details_gen")
    @SequenceGenerator(name = "gym_details_gen", sequenceName = "gym_details_seq",
            allocationSize = 1, schema = "skeleton")
    private Long id;

    @Column(name = "gym_id", nullable = false, unique = true)
    private String gymID;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "player_number", nullable = false)
    private Integer playerNumber;

    @Column(name = "logo_URL", nullable = false)
    private String logoURL;

    @CreationTimestamp
    @Column(name = "creation_Date", nullable = false)
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(name = "update_date", nullable = false)
    private LocalDateTime updateDate;

    @ManyToOne
    @JoinColumn(name = "gym_status_lookup_id", referencedColumnName = "id")
    private GymStatusLookup status;

    @ManyToOne
    @JoinColumn(name = "Gym_Location_Details_id", referencedColumnName = "id")
    private GymLocationDetails location;
}
