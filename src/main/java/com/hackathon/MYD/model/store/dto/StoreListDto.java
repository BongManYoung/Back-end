package com.hackathon.MYD.model.store.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class StoreListDto {
    List<StoreDto> stores = new ArrayList<>();
}
