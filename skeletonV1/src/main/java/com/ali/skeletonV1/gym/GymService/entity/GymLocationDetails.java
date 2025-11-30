package com.ali.skeletonV1.gym.GymService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
        name = "gym_location_details",
        schema = "skeleton"
)
public class GymLocationDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gym_location_details_gen")
    @SequenceGenerator(name = "gym_location_details_gen", sequenceName = "gym_location_details_seq",
            allocationSize = 1, schema = "skeleton")
    private Long id;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "building_no", nullable = false)
    private String buildingNo;

    @Column(name = "Lat", nullable = false)
    private Double Lat;

    @Column(name = "Lng", nullable = false)
    private Double Lng;

    @Column(name = "status", nullable = false)
    private String status;

    @CreationTimestamp
    @Column(name = "creation_Date", nullable = false)
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(name = "update_date", nullable = false)
    private LocalDateTime updateDate;
}
