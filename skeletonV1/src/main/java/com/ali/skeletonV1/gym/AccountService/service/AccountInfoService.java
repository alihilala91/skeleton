package com.ali.skeletonV1.gym.AccountService.service;

import com.ali.skeletonV1.gym.AccountService.entity.AccountInfo;
import com.ali.skeletonV1.gym.AccountService.repository.AccountInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountInfoService {


    private final AccountInfoRepository accountInfoRepository;

    /**
     * Save Account Info in Database
     *
     * @param accountInfo AccountInfo
     * @return AccountInfo
     */
    public AccountInfo save(final AccountInfo accountInfo) {

        // Save AccountInfo into Database
        return accountInfoRepository.save(accountInfo);
    }
}
