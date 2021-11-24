package com.hackathon.MYD.model.service;

import com.hackathon.MYD.exception.BasicException;
import com.hackathon.MYD.exception.ErrorCode;
import com.hackathon.MYD.model.repository.UserRepository;
import com.hackathon.MYD.payload.request.SingInRequest;
import com.hackathon.MYD.payload.request.SingUpRequest;
import com.hackathon.MYD.model.user.UserEntity;
import com.hackathon.MYD.payload.response.TokenResponse;
import com.hackathon.MYD.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    public void singUp(SingUpRequest req){
        userRepository.save(UserEntity.builder()
                                    .nickname(req.getNickname())
                                    .password(pwEncrypt(req.getPassword())).build());
    }

    private String pwEncrypt(String pw){
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

    public TokenResponse singIn(SingInRequest req){
        UserEntity user = userRepository.findByNicknameAndPassword(req.getNickname(),pwEncrypt(req.getPassword()));
        if(user == null){
            throw new BasicException(ErrorCode.USER_NOT_FOUND);
        }
        return TokenResponse.builder().token(jwtUtil.createToken(req.getNickname())).build();
    }
}
