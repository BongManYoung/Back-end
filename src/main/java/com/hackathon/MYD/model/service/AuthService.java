package com.hackathon.MYD.model.service;

import com.hackathon.MYD.model.repository.UserRepository;
import com.hackathon.MYD.model.user.SingUpRequest;
import com.hackathon.MYD.model.user.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final UserRepository userRepository;
    public void singUp(SingUpRequest req){
        userRepository.save(UserEntity.builder()
                                    .nickname(req.getNickname())
                                    .password(pwEncrypt(req.getPassword())).build());
    }

    public String pwEncrypt(String pw){
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(pw.getBytes());
            StringBuilder bilder = new StringBuilder();
            for(byte b: md.digest()){
                bilder.append(String.format("%02x",b));
            }
            return bilder.toString();
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            System.out.println("Password encryption failed");
        }
        return "";
    }
}
