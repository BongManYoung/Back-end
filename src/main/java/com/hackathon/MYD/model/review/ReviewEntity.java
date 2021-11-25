package com.hackathon.MYD.model.review;

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

    @Column(name = "review_content")
    private String reviewContent;

    @Column(name = "perfect")
    private Integer perfect;

    @Column(name = "not_much")
    private Integer notMuch;

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
}
