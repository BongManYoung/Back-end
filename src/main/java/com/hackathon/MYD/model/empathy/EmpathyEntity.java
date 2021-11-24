package com.hackathon.MYD.model.empathy;

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
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empathy_id")
    private Long empathyIdx;

    @Column(name = "perfect")
    private Integer perfect;

    @Column(name = "not_much")
    private Integer notMuch;
}
