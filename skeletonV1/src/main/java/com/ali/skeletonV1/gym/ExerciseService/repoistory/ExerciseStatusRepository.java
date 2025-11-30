package com.ali.skeletonV1.gym.ExerciseService.repoistory;

import com.ali.skeletonV1.gym.ExerciseService.entity.ExerciseStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseStatusRepository extends JpaRepository<ExerciseStatus, Long> {
}
