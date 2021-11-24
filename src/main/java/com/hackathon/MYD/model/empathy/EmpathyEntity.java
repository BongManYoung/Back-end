package com.hackathon.MYD.model.empathy;

import com.hackathon.MYD.model.review.ReviewEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author 전지환
 */
@Entity(name = "empathy")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class EmpathyEntity {
    @EmbeddedId
    private EmpathyId empathyIdx;

    @MapsId("reviewIdx")
    @ManyToOne
    @JoinColumn(name = "review_id")
    public ReviewEntity reviewEntity;

    @Column(name = "perfect")
    private Integer perfect;

    @Column(name = "not_much")
    private Integer notMuch;
}
