package com.ali.skeletonV1.gym.GymService.service;

import com.ali.skeletonV1.gym.GymService.entity.GymStatusLookup;
import com.ali.skeletonV1.gym.GymService.repository.GymStatusLookupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GymStatusLookupService {


    private final GymStatusLookupRepository gymStatusLookupRepository;

    /**
     * Save Gym Status Lookup into Database
     *
     * @param gymStatusLookup GymStatusLookup
     * @return GymStatusLookup
     */
    public GymStatusLookup save(final GymStatusLookup gymStatusLookup) {

        // Save Gym Status Lookup into Database
        return gymStatusLookupRepository.save(gymStatusLookup);
    }
}
