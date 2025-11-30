package com.ali.skeletonV1.gym.ExerciseService.service;

import com.ali.skeletonV1.gym.ExerciseService.entity.ExerciseStatus;
import com.ali.skeletonV1.gym.ExerciseService.repoistory.ExerciseStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExerciseStatusService {


    private final ExerciseStatusRepository exerciseStatusRepository;


    /**
     * Save Exercise Status into Database
     *
     * @param exerciseStatus ExerciseStatus
     * @return ExerciseStatus
     */
    public ExerciseStatus save(final ExerciseStatus exerciseStatus) {

        // Save Exercise Status into Database
        return exerciseStatusRepository.save(exerciseStatus);
    }
}
