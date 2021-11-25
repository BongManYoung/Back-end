package com.hackathon.MYD.model.store.dto;

import com.hackathon.MYD.model.product.dto.ProductDto;
import com.hackathon.MYD.model.store.StoreEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class StoreDetailDto {
    private String storeName;
    private List<ProductDto> products;

    public StoreDetailDto(StoreEntity store, List<ProductDto> products) {
        this.storeName = store.getStoreName();
        this.products = products;
    }
}
