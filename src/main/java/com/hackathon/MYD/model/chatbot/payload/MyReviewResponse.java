package com.hackathon.MYD.model.chatbot.payload;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MyReviewResponse {
    private final String reviewContent;
    private final long reviewId;
    private final String nickname;
}
