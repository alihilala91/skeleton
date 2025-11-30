package com.ali.skeletonV1.gym.ProgramService.servcie;

import com.ali.skeletonV1.gym.ProgramService.entity.ProgramExercise;
import com.ali.skeletonV1.gym.ProgramService.repository.ProgramExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProgramExerciseService {


    private final ProgramExerciseRepository programExerciseRepository;


    /**
     * Save program Exercise  into Database
     *
     * @param programExercise ProgramExercise
     * @return ProgramExercise
     */
    public ProgramExercise save(final ProgramExercise programExercise) {

        // Save program Exercise  into Database
        return programExerciseRepository.save(programExercise);
    }
}
