package com.hackathon.MYD.model.chatbot.controller;

import com.hackathon.MYD.model.chatbot.payload.MenuListResponse;
import com.hackathon.MYD.model.chatbot.payload.MyReviewsResponse;
import com.hackathon.MYD.model.chatbot.payload.RandomProductAnswerResponse;
import com.hackathon.MYD.model.chatbot.service.ChatBotService;

import com.hackathon.MYD.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ChatBotController {
    private final ChatBotService chatBotService;
    private final JwtUtil jwtUtil;

    @GetMapping("/{storeId}/menu")
    public MenuListResponse menuList(@PathVariable int storeId){
        return chatBotService.getMenuList(storeId);
    }

    @GetMapping("/{storeId}/myReview")
    public MyReviewsResponse myReview(@RequestHeader("Authorization") String token, @PathVariable int storeId){
        return chatBotService.myReviewList(jwtUtil.getUserNicknameFromJwtToken(token), storeId);
    }

    @GetMapping("/{storeId}/menu/{message}")
    public RandomProductAnswerResponse randomMenu(@PathVariable int storeId, @PathVariable String message){
        return chatBotService.randomMenu(storeId, message);
    }
}
