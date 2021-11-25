package com.hackathon.MYD.model.review.repository;

public interface ReviewSummary {
    Long getReviewIdx();
    String getReviewContent();
    Integer getReviewPerfect();
    Integer getReviewNotMuch();
    String getReviewNickname();
}
