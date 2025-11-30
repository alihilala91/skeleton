package com.ali.skeletonV1.gym.ExerciseService.service;

import com.ali.skeletonV1.gym.ExerciseService.entity.ExerciseDetails;
import com.ali.skeletonV1.gym.ExerciseService.repoistory.ExerciseDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExerciseDetailsService {

    private final ExerciseDetailsRepository exerciseDetailsRepository;


    /**
     * Save Exercise Details into Database
     *
     * @param exerciseDetails ExerciseDetails
     * @return ExerciseDetails
     */
    public ExerciseDetails save(final ExerciseDetails exerciseDetails) {

        // Save ExerciseDetails into Database
        return exerciseDetailsRepository.save(exerciseDetails);
    }
}
