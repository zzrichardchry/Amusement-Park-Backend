package com.team_nine.final_project.controller;

import com.team_nine.final_project.payload.StoreDto;
import com.team_nine.final_project.payload.VisitorDto;
import com.team_nine.final_project.payload.manage.StoreManageDto;
import com.team_nine.final_project.service.AuthorityService;
import com.team_nine.final_project.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author zhuhaotian
 * @Date 2023/5/4
 */

@RestController
@RequestMapping("api/store")
public class StoreController {

    private final StoreService storeService;
    private final AuthorityService authorityService;
    @Autowired
    public StoreController(StoreService storeService, AuthorityService authorityService) {
        this.storeService = storeService;
        this.authorityService = authorityService;
    }

    @PostMapping
    public ResponseEntity<StoreDto> createStore(@RequestBody StoreManageDto storeManageDto) {
        authorityService.isManager(storeManageDto.getVisitorDto());
        return new ResponseEntity<>(storeService.createStore(storeManageDto.getStoreDto()), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StoreDto>> getAllStores() {
        return ResponseEntity.ok(storeService.getAllStores());
    }

    @GetMapping("{id}")
    public ResponseEntity<StoreDto> getStoreById(@PathVariable long id) {
        return ResponseEntity.ok(storeService.getStoreById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<StoreDto> updateStoreById(@RequestBody StoreManageDto storeManageDto,
                                                    @PathVariable long id) {
        authorityService.isManager(storeManageDto.getVisitorDto());
        return ResponseEntity.ok(storeService.updateStoreById(storeManageDto.getStoreDto(), id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStoreById(@RequestBody VisitorDto visitorDto,
                                                  @PathVariable long id) {
        authorityService.isManager(visitorDto);

        storeService.deleteStoreById(id);
        return new ResponseEntity<>("Store entity deleted successfully!", HttpStatus.OK);
    }
}
