package com.hackathon.MYD.model.review.controller;

import com.hackathon.MYD.model.review.ReviewEntity;
import com.hackathon.MYD.model.review.dto.ReviewDto;
import com.hackathon.MYD.model.review.service.ReviewService;
import com.hackathon.MYD.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * WARN - Response Dto 처리 안 함.
 *
 * @author 전지환
 */
@RequestMapping("/review")
@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final JwtUtil jwtUtil;
    private final ReviewService reviewService;

    @PostMapping("/{storeIdx}")
    public void saveReview(
            @RequestHeader(value = "Authorization") String accessToken,
            @RequestBody ReviewDto.ReviewRequestDto reviewRequestDto,
            @PathVariable Long storeIdx
    ) throws Exception {
        String nickname = jwtUtil.getUserNicknameFromJwtToken(accessToken);
        reviewService.saveReview(storeIdx, nickname, reviewRequestDto);
    }

    /**
     * 매장에 모든 리뷰 가져오기.
     *
     * @param storeIdx
     * @return List<ReviewEntity>
     */
    @GetMapping("/{storeIdx}")
    public List<ReviewEntity> getReview(@PathVariable Long storeIdx){
        return reviewService.getStoreReview(storeIdx);
    }

    /**
     * 해당 리뷰에 공감 추가하기.
     *
     * @param reviewIdx
     * @return String
     */
    @PutMapping("/like/{reviewIdx}")
    public String addLike(@PathVariable Long reviewIdx){
        reviewService.addLike(reviewIdx);
        return "좋아요가 정상 반영 되었습니다.";
    }

    /**
     *  해당 리뷰에 공감 취소하기.
     *
     * @param reviewIdx
     * @return String
     */
    @PutMapping("/like/cancel/{reviewIdx}")
    public String cancelLike(@PathVariable Long reviewIdx){
        reviewService.cancelLike(reviewIdx);
        return "좋아요 취소가 정상 반영 되었습니다.";
    }

    /**
     * 해당 리뷰에 비공감 추가하기.
     *
     * @param reviewIdx
     * @return String
     */
    @PutMapping("/dislike/{reviewIdx}")
    public String addDislike(@PathVariable Long reviewIdx){
        reviewService.addDislike(reviewIdx);
        return "싫어요가 정상 반영 되었습니다.";
    }

    /**
     * 해당 리뷰에 비공감 취소하기.
     *
     * @param reviewIdx
     * @return String
     */
    @PutMapping("/cancel/dislike/{reviewIdx}")
    public String cancelDislike(@PathVariable Long reviewIdx){
        reviewService.addDislike(reviewIdx);
        return "싫어요 취소가 정상 반영 되었습니다.";
    }
}
