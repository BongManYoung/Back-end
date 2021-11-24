package com.hackathon.MYD.model.repository;

import com.hackathon.MYD.model.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
