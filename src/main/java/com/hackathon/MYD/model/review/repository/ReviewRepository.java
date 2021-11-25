package com.hackathon.MYD.model.review.repository;

import com.hackathon.MYD.model.review.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
    ReviewEntity findByReviewIdx(Long reviewIdx);
    @Query(value =
            "select r.reviewIdx, r.reviewContent, r.perfect, r.notMuch, r.userEntity.nickname " +
            "from review as r where r.storeEntity.storeIdx = ?1"
    )
    List<ReviewEntity> findAllByStoreEntity_StoreIdx(Long storeIdx);
}
