package com.hackathon.MYD.model.product.repository;

import com.hackathon.MYD.model.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
