package com.hackathon.MYD.model.review;

import com.hackathon.MYD.model.empathy.EmpathyEntity;
import com.hackathon.MYD.model.empathy.EmpathyId;
import com.hackathon.MYD.model.empathy.repository.EmpathyRepository;
import com.hackathon.MYD.model.review.repository.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReviewEntityTest {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private EmpathyRepository empathyRepository;

    @Test
    @Transactional
    void 식별_관계_테스트(){
        ReviewEntity reviewEntity = ReviewEntity.builder()
                .reviewContent("리뷰 컨텐츠")
                .build();

        ReviewEntity saved_review = reviewRepository.save(reviewEntity);

        EmpathyId empathyId = EmpathyId.builder()
                .reviewIdx(saved_review.getReviewIdx())
                .build();

        EmpathyEntity empathyEntity = EmpathyEntity.builder()
                .empathyIdx(empathyId)
                .perfect(0)
                .notMuch(0)
                .build();

        EmpathyEntity saved_empathy = empathyRepository.save(empathyEntity);

        assertEquals(1, saved_empathy.getEmpathyIdx());
    }
}