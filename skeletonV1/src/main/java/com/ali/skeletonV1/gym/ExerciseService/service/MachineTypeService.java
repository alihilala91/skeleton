package com.ali.skeletonV1.gym.ExerciseService.service;

import com.ali.skeletonV1.gym.ExerciseService.entity.MachineType;
import com.ali.skeletonV1.gym.ExerciseService.repoistory.MachineTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MachineTypeService {

    private final MachineTypeRepository machineTypeRepository;


    /**
     * Save Machine Type into Database
     *
     * @param machineType MachineType
     * @return MachineType
     */
    public MachineType save(final MachineType machineType) {

        // Save Machine Type into Database
        return machineTypeRepository.save(machineType);
    }
}
