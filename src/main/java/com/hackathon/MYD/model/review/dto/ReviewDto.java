package com.hackathon.MYD.model.review.dto;

import com.hackathon.MYD.model.review.ReviewEntity;
import lombok.*;

public class ReviewDto {
    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class ReviewRequestDto {
        private String reviewContent;
    }

    @Getter @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class ReviewResponseDto {
        private Long reviewIdx;
        private String reviewContent;
        private Integer perfect;
        private Integer notMuch;
        private String nickname;

        public static ReviewResponseDto of(ReviewEntity reviewEntity){
            return ReviewResponseDto.builder()
                    .reviewIdx(reviewEntity.getReviewIdx())
                    .reviewContent(reviewEntity.getReviewContent())
                    .perfect(reviewEntity.getPerfect())
                    .notMuch(reviewEntity.getNotMuch())
                    .nickname(reviewEntity.getUserEntity().getNickname())
                    .build();

        }
    }
}
