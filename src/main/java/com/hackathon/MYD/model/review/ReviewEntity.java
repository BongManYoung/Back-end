package com.hackathon.MYD.model.review;

import javax.persistence.*;

@Entity
public class ReviewEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long reviewIdx;
}
