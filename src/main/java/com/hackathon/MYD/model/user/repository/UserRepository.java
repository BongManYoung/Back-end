package com.hackathon.MYD.model.user.repository;

import com.hackathon.MYD.model.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByNicknameAndPassword(String nickname, String password);
}
