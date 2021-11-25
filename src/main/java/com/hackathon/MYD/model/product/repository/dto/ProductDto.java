package com.hackathon.MYD.model.product.repository.dto;

import com.hackathon.MYD.model.product.ProductEntity;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductDto {
    private Long idx;
    private String productName;

    public ProductDto(ProductEntity product) {
        this.idx = product.getProductIdx();
        this.productName = product.getProductName();
    }
}
