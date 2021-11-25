package com.hackathon.MYD.model.review.controller;

import com.hackathon.MYD.model.review.dto.ReviewDto;
import com.hackathon.MYD.model.review.service.ReviewService;
import com.hackathon.MYD.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
}
