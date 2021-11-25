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


}
