package com.ali.skeletonV1.gym.ProgramService.servcie;

import com.ali.skeletonV1.gym.ProgramService.entity.ProgramDetails;
import com.ali.skeletonV1.gym.ProgramService.repository.ProgramDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProgramDetailsService {

    private final ProgramDetailsRepository programDetailsRepository;


    /**
     * Save Program Details into Database
     *
     * @param programDetails ProgramDetails
     * @return ProgramDetails
     */
    public ProgramDetails save(final ProgramDetails programDetails) {

        // Save Program Details into Database
        return programDetailsRepository.save(programDetails);
    }
}
