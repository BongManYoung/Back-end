package com.hackathon.MYD.model.review.service;

import com.hackathon.MYD.model.empathy.EmpathyEntity;
import com.hackathon.MYD.model.review.ReviewEntity;
import com.hackathon.MYD.model.review.dto.ReviewDto;
import com.hackathon.MYD.model.review.repository.ReviewRepository;
import com.hackathon.MYD.model.store.StoreEntity;
import com.hackathon.MYD.model.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * ServiceImpl
 * 결합도를 느슨하게 함.
 *
 * @author 전지환
 */
@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewEntity reviewEntity;
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;

    @Transactional
    public void saveReview(Long storeIdx, String nickname, ReviewDto.ReviewRequestDto reviewRequestDto) throws Exception {
        // 매장이 존재하는지 확인한다.
        Optional<StoreEntity> storeEntity = storeRepository.findById(storeIdx);
        if (storeEntity.isEmpty()) throw new Exception("해당 매장을 찾을 수 없음");
    }
}
