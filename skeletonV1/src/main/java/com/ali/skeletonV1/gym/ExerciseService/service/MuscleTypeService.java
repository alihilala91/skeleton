package com.ali.skeletonV1.gym.ExerciseService.service;

import com.ali.skeletonV1.gym.ExerciseService.entity.MuscleType;
import com.ali.skeletonV1.gym.ExerciseService.repoistory.MuscleTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MuscleTypeService {

    private final MuscleTypeRepository muscleTypeRepository;


    /**
     * Save MuscleType into Database
     *
     * @param muscleType MuscleType
     * @return MuscleType
     */
    public MuscleType save(final MuscleType muscleType) {

        // Save Muscle Type into Database
        return muscleTypeRepository.save(muscleType);
    }
}
