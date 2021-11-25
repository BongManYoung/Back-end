package com.hackathon.MYD.model.store.service;

import com.hackathon.MYD.model.store.StoreEntity;
import com.hackathon.MYD.model.store.dto.StoreDto;
import com.hackathon.MYD.model.store.dto.StoreListDto;
import com.hackathon.MYD.model.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    @Override
    @Transactional(readOnly = true)
    public StoreListDto getStores() {
        StoreListDto storeList = new StoreListDto();
        List<StoreEntity> stores = storeRepository.findAll();

        for (StoreEntity store : stores) {
            StoreDto storeDto = new StoreDto(store);
            storeList.getStores().add(storeDto);
        }

        return storeList;
    }
}
