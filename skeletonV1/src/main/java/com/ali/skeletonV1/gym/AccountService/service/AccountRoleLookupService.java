package com.ali.skeletonV1.gym.AccountService.service;

import com.ali.skeletonV1.gym.AccountService.entity.AccountRoleLookup;
import com.ali.skeletonV1.gym.AccountService.repository.AccountRoleLookupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountRoleLookupService {


    private final AccountRoleLookupRepository accountRoleLookupRepository;


    /**
     * Save AccountRoleLookup into Database
     *
     * @param accountRoleLookup AccountRoleLookup
     * @return AccountRoleLookup
     */
    public AccountRoleLookup save(final AccountRoleLookup accountRoleLookup) {

        // Save Account role Lookup into Database
        return accountRoleLookupRepository.save(accountRoleLookup);
    }
}
