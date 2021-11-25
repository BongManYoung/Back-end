package com.hackathon.MYD.model.review;

import com.hackathon.MYD.model.empathy.EmpathyEntity;
import com.hackathon.MYD.model.store.StoreEntity;
import com.hackathon.MYD.model.user.UserEntity;
import lombok.*;

import javax.persistence.*;

/**
 * @author 전지환
 */
@Entity(name = "review")
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long reviewIdx;

    /**
     * 식별자 관계를 OneToOne 비식별자 관계로 풀어 냄.
     */
    @OneToOne
    @JoinColumn(name = "empathy_id")
    private EmpathyEntity empathyEntity;

    /**
     * UserEntity와 연관관계를 맺는다.
     */
    @ManyToOne(targetEntity = UserEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    /**
     * StoreEntity 와 연관관계를 맺는다.
     */
    @ManyToOne(targetEntity = StoreEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id")
    private StoreEntity storeEntity;


    @Column(name = "review_content")
    private String reviewContent;

    /**
     * 리뷰 저장시 사용하는 toEntity 메소드.
     *
     * @param empathyEntity
     * @param userEntity
     * @param storeEntity
     * @param reviewContent
     * @return ReviewEntity
     */
    public ReviewEntity toEntity(
            EmpathyEntity empathyEntity, UserEntity userEntity, StoreEntity storeEntity, String reviewContent
    ){
        return ReviewEntity.builder()
                .empathyEntity(empathyEntity)
                .userEntity(userEntity)
                .storeEntity(storeEntity)
                .reviewContent(reviewContent)
                .build();
    }
}
