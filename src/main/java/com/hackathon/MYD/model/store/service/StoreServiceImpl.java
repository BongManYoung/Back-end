package com.hackathon.MYD.model.store.service;

import com.hackathon.MYD.model.product.ProductEntity;
import com.hackathon.MYD.model.product.dto.ProductDto;
import com.hackathon.MYD.model.store.StoreEntity;
import com.hackathon.MYD.model.store.dto.StoreDetailDto;
import com.hackathon.MYD.model.store.dto.StoreDto;
import com.hackathon.MYD.model.store.dto.StoreListDto;
import com.hackathon.MYD.model.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
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

    @Override
    @Transactional(readOnly = true)
    public StoreDetailDto getStoreDetail(Long storeId) {
        List<ProductDto> productDtoList = new ArrayList<>();
        StoreEntity store = storeRepository.findById(storeId).orElseThrow(
                () -> new IllegalArgumentException("없는 가게 입니다.")
        );

        for (ProductEntity product : store.getProducts()) {
            ProductDto productDto = new ProductDto(product);
            productDtoList.add(productDto);
        }

        return new StoreDetailDto(store, productDtoList);
    }

    @Override
    @Transactional(readOnly = true)
    public List<StoreDetailDto> getAll() {
        List<StoreDetailDto> response = new ArrayList<>();
        List<StoreEntity> stores = storeRepository.findAll();

        for (StoreEntity store : stores) {
            List<ProductDto> productDtoList = new ArrayList<>();
            for (ProductEntity product : store.getProducts()) {
                ProductDto productDto = new ProductDto(product);
                productDtoList.add(productDto);
            }
            StoreDetailDto storeDetailDto = new StoreDetailDto(store, productDtoList);
            response.add(storeDetailDto);
        }

        return response;
    }
}
