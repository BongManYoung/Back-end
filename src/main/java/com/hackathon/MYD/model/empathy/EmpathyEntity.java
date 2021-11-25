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
@AllArgsConstructor
public class EmpathyEntity {
    @EmbeddedId
    private EmpathyId empathyIdx;

    @MapsId("reviewIdx")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "review_id", referencedColumnName = "review_id")
    public ReviewEntity reviewEntity;

    @Column(name = "perfect")
    private Integer perfect;

    @Column(name = "not_much")
    private Integer notMuch;
}
