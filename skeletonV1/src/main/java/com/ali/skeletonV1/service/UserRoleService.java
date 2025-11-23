package com.ali.skeletonV1.service;

import com.ali.skeletonV1.entity.UserRole;
import com.ali.skeletonV1.exception.ExceptionKey;
import com.ali.skeletonV1.exception.ResourceException;
import com.ali.skeletonV1.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class UserRoleService {


    private final UserRoleRepository userRoleRepository;


    /**
     * Save User Role to DB
     *
     * @param userRole User Role
     * @return USerRole
     */
    public UserRole save(final UserRole userRole) {

        // Save USer Role to Database
        return userRoleRepository.save(userRole);
    }


    /**
     * Find User Role By Code And Status
     *
     * @param role   User Role code
     * @param status Status
     * @return User Role
     */
    public UserRole findByCode(final String role,
                               final String status,
                               final Locale locale) {

        // Find USer Role By Status And Code
        return userRoleRepository.findUserRoleByCodeAndStatus(role, status)
                .orElseThrow(() ->
                        new ResourceException(ExceptionKey.USER_ROLE_NOT_FOUND, HttpStatus.NOT_FOUND, locale));
    }
}
