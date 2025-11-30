package com.ali.skeletonV1.gym.ExerciseService.service;

import com.ali.skeletonV1.gym.ExerciseService.entity.ExerciseAttachment;
import com.ali.skeletonV1.gym.ExerciseService.repoistory.ExerciseAttachmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExerciseAttachmentService {

    private final ExerciseAttachmentRepository exerciseAttachmentRepository;


    /**
     * Save ExerciseAttachment into Database
     *
     * @param exerciseAttachment ExerciseAttachment
     * @return ExerciseAttachment
     */
    public ExerciseAttachment save(final ExerciseAttachment exerciseAttachment) {

        // Save ExerciseAttachment into Database
        return exerciseAttachmentRepository.save(exerciseAttachment);
    }
}
