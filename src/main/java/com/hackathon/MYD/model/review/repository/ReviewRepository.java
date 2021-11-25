package com.hackathon.MYD.model.review.repository;

import com.hackathon.MYD.model.review.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
    ReviewEntity findByReviewIdx(Long reviewIdx);
    List<ReviewEntity> findAllByStoreEntity_StoreIdx(Long storeIdx);
}
