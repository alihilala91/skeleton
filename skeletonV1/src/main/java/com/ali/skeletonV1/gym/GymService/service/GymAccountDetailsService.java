package com.ali.skeletonV1.gym.GymService.service;

import com.ali.skeletonV1.gym.GymService.entity.GymAccountDetails;
import com.ali.skeletonV1.gym.GymService.repository.GymAccountDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GymAccountDetailsService {

    private final GymAccountDetailsRepository gymAccountDetailsRepository;


    /**
     * Save Gym Account Details into Database
     *
     * @param gymAccountDetails GymAccountDetails
     * @return GymAccountDetails
     */
    public GymAccountDetails save(final GymAccountDetails gymAccountDetails) {
        // Save Gym Account Details into Database
        return gymAccountDetailsRepository.save(gymAccountDetails);
    }
}
