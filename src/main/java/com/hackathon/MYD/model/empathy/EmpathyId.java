package com.hackathon.MYD.model.empathy;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EqualsAndHashCode
public class EmpathyId implements Serializable {
    private Long reviewIdx;

    @Column(name = "empathy_id")
    private Long empathyIdx;
}
