package com.hackathon.MYD.model.chatbot.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Builder
public class MyReviewsResponse {
    private final List<MyReviewResponse> reviews;
    private final String nextAnswer;
}
