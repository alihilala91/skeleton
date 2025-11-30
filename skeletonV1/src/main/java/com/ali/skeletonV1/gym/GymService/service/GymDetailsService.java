package com.ali.skeletonV1.gym.GymService.service;

import com.ali.skeletonV1.gym.GymService.entity.GymDetails;
import com.ali.skeletonV1.gym.GymService.repository.GymDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GymDetailsService {

    private final GymDetailsRepository gymDetailsRepository;


    /**
     * Save Gym Details into Database
     *
     * @param gymDetails GymDetails
     * @return GymDetails
     */
    public GymDetails save(final GymDetails gymDetails) {

        // Save Gym Details into Database
        return gymDetailsRepository.save(gymDetails);
    }
}
