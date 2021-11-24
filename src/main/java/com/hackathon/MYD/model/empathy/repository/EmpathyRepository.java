package com.hackathon.MYD.model.empathy.repository;

import com.hackathon.MYD.model.empathy.EmpathyEntity;
import com.hackathon.MYD.model.empathy.EmpathyId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpathyRepository extends JpaRepository<EmpathyEntity, EmpathyId> {
}
