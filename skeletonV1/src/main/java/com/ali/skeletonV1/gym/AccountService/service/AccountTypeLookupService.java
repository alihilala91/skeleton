package com.ali.skeletonV1.gym.AccountService.service;

import com.ali.skeletonV1.gym.AccountService.entity.AccountTypeLookup;
import com.ali.skeletonV1.gym.AccountService.repository.AccountTypeLookupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountTypeLookupService {


    private final AccountTypeLookupRepository  accountTypeLookupRepository;


    /**
     * Save Account Type Lookup into Database
     * @param accountTypeLookup AccountTypeLookup
     * @return AccountTypeLookup
     */
    public AccountTypeLookup save(final AccountTypeLookup accountTypeLookup) {

        // Save Account Type Lookup into Database
        return accountTypeLookupRepository.save(accountTypeLookup);
    }
}
