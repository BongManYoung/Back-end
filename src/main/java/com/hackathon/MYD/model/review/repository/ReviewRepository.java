package com.hackathon.MYD.model.review.repository;

import com.hackathon.MYD.model.review.ReviewEntity;
import com.hackathon.MYD.model.store.StoreEntity;
import com.hackathon.MYD.model.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
    List<ReviewEntity> findByUserIdxAndStoreEntity(UserEntity userIdx, StoreEntity storeEntity);
}
