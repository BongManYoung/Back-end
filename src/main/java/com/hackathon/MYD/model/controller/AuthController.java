package com.hackathon.MYD.model.controller;

import com.hackathon.MYD.model.service.AuthService;
import com.hackathon.MYD.model.user.SingUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthController {
    private final AuthService authService;
    @PostMapping("/user")
    public void singUp(@RequestBody SingUpRequest req){
        authService.singUp(req);
    }
}
