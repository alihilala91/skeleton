package com.ali.skeletonV1.gym.ExerciseService.repoistory;

import com.ali.skeletonV1.gym.ExerciseService.entity.ExerciseDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseDetailsRepository extends JpaRepository<ExerciseDetails, Long> {
}
