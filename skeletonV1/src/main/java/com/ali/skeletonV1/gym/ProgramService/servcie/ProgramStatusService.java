package com.ali.skeletonV1.gym.ProgramService.servcie;

import com.ali.skeletonV1.gym.ProgramService.entity.ProgramStatus;
import com.ali.skeletonV1.gym.ProgramService.repository.ProgramStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProgramStatusService {

    private final ProgramStatusRepository programStatusRepository;

    /**
     * Save Program Status into Database
     *
     * @param programStatus ProgramStatus
     * @return ProgramStatus
     */
    public ProgramStatus save(final ProgramStatus programStatus) {

        // Save Program Status into Database
        return programStatusRepository.save(programStatus);
    }
}
