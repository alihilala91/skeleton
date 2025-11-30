package com.ali.skeletonV1.gym.AccountService.service;

import com.ali.skeletonV1.gym.AccountService.entity.AccountStatusLookup;
import com.ali.skeletonV1.gym.AccountService.repository.AccountStatusLookupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountStatusLookupService {

    private final AccountStatusLookupRepository accountStatusLookupRepository;


    /**
     * Save Account Status Lookup into Database
     * @param accountStatusLookup AccountStatusLookup
     * @return AccountStatusLookup
     */
    public AccountStatusLookup save(final AccountStatusLookup accountStatusLookup) {

        // Save Account Status into Lookup
        return accountStatusLookupRepository.save(accountStatusLookup);
    }
}
