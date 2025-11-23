package com.ali.skeletonV1.service;

import com.ali.skeletonV1.entity.Users;
import com.ali.skeletonV1.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersService {


    private final UsersRepository usersRepository;


    /**
     * Save User To Database
     *
     * @param users User
     * @return User
     */
    public Users save(final Users users) {

        // Save User to Database
        return usersRepository.save(users);
    }


    /**
     * Delete All Users
     * Used for Test
     */
    public void deleteAll() {

        usersRepository.deleteAll();
    }
}
