package com.ali.skeletonV1.gym.GymService.repository;

import com.ali.skeletonV1.gym.GymService.entity.GymStatusLookup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GymStatusLookupRepository extends JpaRepository<GymStatusLookup, Long> {
}
