package com.ali.skeletonV1.gym.AccountService.service;

import com.ali.skeletonV1.gym.AccountService.entity.AccountLevelTypeLookup;
import com.ali.skeletonV1.gym.AccountService.repository.AccountLevelTypeLookupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountLevelTypeLookupService {


    private final AccountLevelTypeLookupRepository accountLevelTypeLookupRepository;


    /**
     * Save AccountLevelTypeLookup into Database
     *
     * @param accountLevelTypeLookup AccountLevelTypeLookup
     * @return AccountLevelTypeLookup
     */
    public AccountLevelTypeLookup save(final AccountLevelTypeLookup accountLevelTypeLookup) {

        // SAve Account Level Lookup into Database
        return accountLevelTypeLookupRepository.save(accountLevelTypeLookup);
    }
}
