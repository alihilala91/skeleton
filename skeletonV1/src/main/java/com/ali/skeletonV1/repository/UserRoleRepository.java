package com.ali.skeletonV1.repository;

import com.ali.skeletonV1.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {


    Optional<UserRole> findUserRoleByCodeAndStatus(String role, String status);
}
