package com.ali.skeletonV1.gym.ProgramService.servcie;

import com.ali.skeletonV1.gym.ProgramService.entity.ExerciseRepetition;
import com.ali.skeletonV1.gym.ProgramService.repository.ExerciseRepetitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExerciseRepetitionService {

    private final ExerciseRepetitionRepository exerciseRepetitionRepository;


    /**
     * Save Exercise Repetition into Database
     *
     * @param exerciseRepetition ExerciseRepetition
     * @return ExerciseRepetition
     */
    public ExerciseRepetition save(final ExerciseRepetition exerciseRepetition) {

        // Save Exercise Repetition into Database
        return exerciseRepetitionRepository.save(exerciseRepetition);
    }
}
