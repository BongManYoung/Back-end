package com.hackathon.MYD.model.review;

import com.hackathon.MYD.model.empathy.EmpathyEntity;
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

    @OneToOne
    @JoinColumn(name = "empathy_id")
    private EmpathyEntity empathyEntity;

    /**
     * UserEntity와 연관관계를 맺는다.
     */
//    @OneToMany(mappedBy = "user")
//    @Column(name = "user_id")
//    private Long userIdx;

    /**
     * StoreEntity와 연관관계를 맺는다.
     */
//    @OneToMany(mappedBy = "store")
//    @Column(name = "store_id")
//    private Long storeIdx;

    @Column(name = "review_content")
    private String reviewContent;
}
