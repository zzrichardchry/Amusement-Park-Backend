package com.team_nine.final_project.service.impl;

import com.team_nine.final_project.dao.StoreRepository;
import com.team_nine.final_project.entity.Store;
import com.team_nine.final_project.exception.ResourceNotFoundException;
import com.team_nine.final_project.payload.StoreDto;
import com.team_nine.final_project.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author zhuhaotian
 * @Date 2023/5/4
 */

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    @Autowired
    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public StoreDto createStore(StoreDto storeDto) {
        Store store = mapToEntity(storeDto);

        Store savedStore = storeRepository.save(store);
        return mapToDto(savedStore);
    }

    @Override
    public List<StoreDto> getAllStores() {
        return storeRepository.findAll().stream()
                .map(StoreServiceImpl::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public StoreDto getStoreById(long id) {
        Store store = storeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Store", "id", id));
        return mapToDto(store);
    }

    @Override
    public StoreDto updateStoreById(StoreDto storeDto, long id) {
        Store store = storeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Store", "id", id));

        store.setName(storeDto.getName());
        store.setCategory(storeDto.getCategory());
        store.setDescription(storeDto.getDescription());
        store.setItem(storeDto.getItem());

        Store savedStore = storeRepository.save(store);
        return mapToDto(savedStore);
    }

    @Override
    public void deleteStoreById(long id) {
        Store store = storeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Store", "id", id));

        storeRepository.delete(store);
    }

    private static StoreDto mapToDto(Store store) {
        StoreDto ret = new StoreDto();

        ret.setId(store.getId());
        ret.setName(store.getName());
        ret.setCategory(store.getCategory());
        ret.setDescription(store.getDescription());
        ret.setItem(store.getItem());

        return ret;
    }

    private static Store mapToEntity(StoreDto storeDto) {
        Store ret = new Store();

        ret.setId(storeDto.getId());
        ret.setName(storeDto.getName());
        ret.setCategory(storeDto.getCategory());
        ret.setDescription(storeDto.getDescription());
        ret.setItem(storeDto.getItem());

        return ret;
    }
}
