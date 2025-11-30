package com.ali.skeletonV1.gym.ExerciseService.service;

import com.ali.skeletonV1.gym.ExerciseService.entity.ExerciseLevelLookup;
import com.ali.skeletonV1.gym.ExerciseService.repoistory.ExerciseLevelLookupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExerciseLevelLookupService {


    private final ExerciseLevelLookupRepository  exerciseLevelLookupRepository;

    /**
     * Save Exercise Level Lookup into Database
     * @param exerciseLevelLookup ExerciseLevelLookup
     * @return ExerciseLevelLookup
     */
    public ExerciseLevelLookup save(final ExerciseLevelLookup exerciseLevelLookup) {

        // Save Exercise Level Lookup Into Database
        return exerciseLevelLookupRepository.save(exerciseLevelLookup);
    }
}
