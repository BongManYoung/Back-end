package com.hackathon.MYD.model.review.service;

import com.hackathon.MYD.model.review.ReviewEntity;
import com.hackathon.MYD.model.review.dto.ReviewDto;
import com.hackathon.MYD.model.review.repository.ReviewRepository;
import com.hackathon.MYD.model.store.StoreEntity;
import com.hackathon.MYD.model.store.repository.StoreRepository;
import com.hackathon.MYD.model.user.UserEntity;
import com.hackathon.MYD.model.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * ServiceImpl
 * 결합도를 느슨하게 함.
 *
 * @author 전지환
 */
@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;

    @Transactional
    public void saveReview(Long storeIdx, String nickname, ReviewDto.ReviewRequestDto reviewRequestDto) throws Exception {
        // 유저가 존재하는지 확인한다.
        UserEntity userEntity = userRepository.findByNickname(nickname);

        // 매장이 존재하는지 확인한다.
        StoreEntity storeEntity = storeRepository.findByStoreIdx(storeIdx);
        if (storeEntity==null) throw new Exception("해당 매장을 찾을 수 없음");

        // Review 생성하기
        ReviewEntity reviewEntity = ReviewEntity.builder()
                .reviewContent(reviewRequestDto.getReviewContent())
                .perfect(0)
                .notMuch(0)
                .userEntity(userEntity)
                .storeEntity(storeEntity)
                .build();

        reviewRepository.save(reviewEntity);
    }
}
