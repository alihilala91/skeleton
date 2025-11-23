package com.ali.skeletonV1.repository;

import com.ali.skeletonV1.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
