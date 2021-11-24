package com.hackathon.MYD.model.service;

import com.hackathon.MYD.model.repository.UserRepository;
import com.hackathon.MYD.model.user.SingUpRequest;
import com.hackathon.MYD.model.user.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final UserRepository userRepository;
    public void singUp(SingUpRequest req){
        userRepository.save(UserEntity.builder()
                                    .nickname(req.getNickname())
                                    .password(req.getPassword()).build());
    }
}
