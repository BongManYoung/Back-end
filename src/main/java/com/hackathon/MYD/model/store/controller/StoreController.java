package com.hackathon.MYD.model.store.controller;

import com.hackathon.MYD.model.response.ResponseData;
import com.hackathon.MYD.model.store.dto.StoreDto;
import com.hackathon.MYD.model.store.dto.StoreListDto;
import com.hackathon.MYD.model.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/store")
@RestController
public class StoreController {

    private final StoreService storeService;

    @GetMapping("/list")
    public ResponseData<StoreListDto> getStoreList() {
        StoreListDto stores = storeService.getStores();

        return new ResponseData<>(HttpStatus.OK, "성공", stores);
    }
}
