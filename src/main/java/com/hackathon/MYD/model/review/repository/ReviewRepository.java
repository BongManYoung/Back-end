package com.hackathon.MYD.model.review.repository;

import com.hackathon.MYD.model.review.ReviewEntity;
import com.hackathon.MYD.model.store.StoreEntity;
import com.hackathon.MYD.model.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
    ReviewEntity findByReviewIdx(Long reviewIdx);
    List<ReviewEntity> findAllByStoreEntity_StoreIdx(long storeIdx);
    List<ReviewEntity> findByUserIdxAndStoreEntity(UserEntity user, StoreEntity storeEntity);
}
