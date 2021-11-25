package com.hackathon.MYD.model.store.repository;

import com.hackathon.MYD.model.store.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<StoreEntity, Long> {
}
