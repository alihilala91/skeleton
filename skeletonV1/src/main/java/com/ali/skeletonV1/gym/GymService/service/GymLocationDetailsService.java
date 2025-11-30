package com.ali.skeletonV1.gym.GymService.service;

import com.ali.skeletonV1.gym.GymService.entity.GymLocationDetails;
import com.ali.skeletonV1.gym.GymService.repository.GymLocationDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GymLocationDetailsService {

    private final GymLocationDetailsRepository gymLocationDetailsRepository;


    /**
     * Save Gym Location Details into Database
     *
     * @param gymLocationDetails GymLocationDetails
     * @return GymLocationDetails
     */
    public GymLocationDetails save(final GymLocationDetails gymLocationDetails) {

        //  Save Gym Location Details into Database
        return gymLocationDetailsRepository.save(gymLocationDetails);
    }
}
