package com.hackathon.MYD.model.product.repository;

import com.hackathon.MYD.model.product.ProductEntity;
import com.hackathon.MYD.model.store.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByStoreIdx(StoreEntity store);
}
