package com.hackathon.MYD.model.user.payload.request;

import lombok.Getter;

@Getter
public class SingInRequest {
    private String nickname;
    private String password;
}
