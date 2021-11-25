package com.hackathon.MYD.model.store.dto;

import com.hackathon.MYD.model.store.StoreEntity;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StoreDto {
    private Long idx;
    private String storeName;

    public StoreDto(StoreEntity store) {
        this.idx = store.getStoreIdx();
        this.storeName = store.getStoreName();
    }
}
