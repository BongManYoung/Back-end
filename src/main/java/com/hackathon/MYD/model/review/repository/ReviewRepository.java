package com.hackathon.MYD.model.review.repository;

import com.hackathon.MYD.model.review.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
}
