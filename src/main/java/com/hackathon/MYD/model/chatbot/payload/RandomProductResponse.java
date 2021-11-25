package com.hackathon.MYD.model.chatbot.payload;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RandomProductResponse {
    private final String name;
}
