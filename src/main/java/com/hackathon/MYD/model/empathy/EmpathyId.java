package com.hackathon.MYD.model.empathy;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class EmpathyId implements Serializable {
    private Long reviewIdx;

    @Column(name = "empathy_id")
    private Long empathyIdx;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpathyId empathyId = (EmpathyId) o;
        return Objects.equals(reviewIdx, empathyId.reviewIdx) && Objects.equals(empathyIdx, empathyId.empathyIdx);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewIdx, empathyIdx);
    }
}
