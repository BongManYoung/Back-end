package com.hackathon.MYD.model.chatbot.payload;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RandomProductAnswerResponse {
    private final String answer;
}
