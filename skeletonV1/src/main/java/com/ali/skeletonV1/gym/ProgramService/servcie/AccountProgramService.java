package com.ali.skeletonV1.gym.ProgramService.servcie;

import com.ali.skeletonV1.gym.ProgramService.entity.AccountProgram;
import com.ali.skeletonV1.gym.ProgramService.repository.AccountProgramRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountProgramService {


    private final AccountProgramRepository accountProgramRepository;


    /**
     * Save Account Program into Database
     *
     * @param accountProgram AccountProgram
     * @return AccountProgram
     */
    public AccountProgram save(final AccountProgram accountProgram) {

        //  Save Account Program into Database
        return accountProgramRepository.save(accountProgram);
    }
}
