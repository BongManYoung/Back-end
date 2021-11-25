package com.hackathon.MYD.model.empathy;

import com.hackathon.MYD.model.review.ReviewEntity;
import lombok.*;

import javax.persistence.*;

/**
 * @author 전지환
 */
@Entity(name = "empathy")
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EmpathyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empathy_id")
    private Long empathyIdx;

    @OneToOne
    @JoinColumn(name = "review_id")
    private ReviewEntity reviewEntity;

    @Column(name = "perfect")
    private Integer perfect;

    @Column(name = "not_much")
    private Integer notMuch;
}
