package com.ali.skeletonV1.gym.ProgramService.servcie;

import com.ali.skeletonV1.gym.ProgramService.entity.ProgramLevelLookup;
import com.ali.skeletonV1.gym.ProgramService.repository.ProgramLevelLookupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProgramLevelLookupService {

    private final ProgramLevelLookupRepository programLevelLookupRepository;


    /**
     * Save ProgramLevelLookup into Database
     *
     * @param programLevelLookup ProgramLevelLookup
     * @return ProgramLevelLookup
     */
    public ProgramLevelLookup save(final ProgramLevelLookup programLevelLookup) {

        // Save ProgramLevelLookup into Database
        return programLevelLookupRepository.save(programLevelLookup);
    }
}
