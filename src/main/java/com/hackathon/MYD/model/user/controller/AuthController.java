package com.hackathon.MYD.model.user.controller;

import com.hackathon.MYD.model.user.service.AuthService;
import com.hackathon.MYD.model.user.payload.request.SingInRequest;
import com.hackathon.MYD.model.user.payload.request.SingUpRequest;
import com.hackathon.MYD.model.user.payload.response.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthController {
    private final AuthService authService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/user")
    public void singUp(@RequestBody SingUpRequest req){
        authService.singUp(req);
    }

    @PostMapping("/auth")
    public TokenResponse singIn(@RequestBody SingInRequest req){
        return authService.singIn(req);
    }
}
