package com.hackathon.MYD.model.chatbot.service;

import com.hackathon.MYD.exception.StoreNotFoundException;
import com.hackathon.MYD.model.chatbot.payload.MenuListResponse;
import com.hackathon.MYD.model.chatbot.payload.MyReviewResponse;
import com.hackathon.MYD.model.chatbot.payload.MyReviewsResponse;
import com.hackathon.MYD.model.product.ProductEntity;
import com.hackathon.MYD.model.product.repository.ProductRepository;
import com.hackathon.MYD.model.review.ReviewEntity;
import com.hackathon.MYD.model.review.repository.ReviewRepository;
import com.hackathon.MYD.model.store.repository.StoreRepository;
import com.hackathon.MYD.model.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ChatBotService {
    private final UserRepository userRepository;
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;

    public MyReviewsResponse myReviewList(String nickname, long storeId){
        List<ReviewEntity> reviewList = reviewRepository.findByUserIdxAndStoreEntity(userRepository.findByNickname(nickname), storeRepository.findById(storeId).orElseThrow(StoreNotFoundException::new));
        List<MyReviewResponse> myReviews = new ArrayList<>();
        for(ReviewEntity review : reviewList){
            myReviews.add(MyReviewResponse.builder()
                                        .nickname(nickname)
                                        .reviewId(review.getReviewIdx())
                                        .reviewContent(review.getReviewContent()).build());
        }
        return MyReviewsResponse.builder().reviews(myReviews).nextAnswer("좋은 리뷰는 행복을 불러옵니다:)").build();
    }

    public MenuListResponse getMenuList(long storeId){

        List<ProductEntity> product =  productRepository.findByStoreIdx(storeRepository.findById(storeId).orElseThrow(StoreNotFoundException::new));
        List<String> names = new ArrayList<>();
        for(ProductEntity p : product){
            names.add(p.getProductName());
        }
        return MenuListResponse.builder().names(names).nextAnswer("더 필요한 게 있으신가요?").build();
    }
}
