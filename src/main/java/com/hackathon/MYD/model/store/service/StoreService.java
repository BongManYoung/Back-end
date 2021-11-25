package com.hackathon.MYD.model.store.service;

import com.hackathon.MYD.model.store.dto.StoreDetailDto;
import com.hackathon.MYD.model.store.dto.StoreListDto;
import org.springframework.transaction.annotation.Transactional;

public interface StoreService {
    @Transactional(readOnly = true)
    StoreListDto getStores();

    @Transactional(readOnly = true)
    StoreDetailDto getStoreDetail(Long storeId);
}