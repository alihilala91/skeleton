package com.ali.skeletonV1.gym.AccountService.service;

import com.ali.skeletonV1.gym.AccountService.entity.IdentificationTypeLookup;
import com.ali.skeletonV1.gym.AccountService.repository.IdentificationTypeLookupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IdentificationTypeLookupService {


    private final IdentificationTypeLookupRepository identificationTypeLookupRepository;


    /**
     * Save Identification Type Lookup into Database
     *
     * @param identificationTypeLookup IdentificationTypeLookup
     * @return IdentificationTypeLookup
     */
    public IdentificationTypeLookup save(final IdentificationTypeLookup identificationTypeLookup) {

        // Save Identification Type Lookup into Database
        return identificationTypeLookupRepository.save(identificationTypeLookup);
    }
}
