package com.hackathon.MYD.model.review.dto;

import lombok.*;

public class ReviewDto {
    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class ReviewRequestDto {
        private String reviewContent;
    }
}
