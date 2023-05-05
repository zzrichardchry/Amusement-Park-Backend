package com.team_nine.final_project.service;

import com.team_nine.final_project.payload.StoreDto;

import java.util.List;

/**
 * @Author zhuhaotian
 * @Date 2023/5/4
 */

public interface StoreService {

    StoreDto createStore(StoreDto storeDto);

    List<StoreDto> getAllStores();

    StoreDto getStoreById(long id);

    StoreDto updateStoreById(StoreDto storeDto, long id);

    void deleteStoreById(long id);
}
