package com.ali.skeletonV1.gym.AccountService.service;

import com.ali.skeletonV1.gym.AccountService.entity.AccountLevel;
import com.ali.skeletonV1.gym.AccountService.repository.AccountLevelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountLevelService {


    private final AccountLevelRepository accountLevelRepository;


    /**
     * Save Account Level into Database
     *
     * @param accountLevel AccountLevel
     * @return AccountLevel
     */
    public AccountLevel save(final AccountLevel accountLevel) {

        // save Account Level into Database
        return accountLevelRepository.save(accountLevel);
    }
}
