package com.team_nine.final_project.controller;

import com.team_nine.final_project.payload.AttractionDto;
import com.team_nine.final_project.payload.manage.AttractionManageDto;
import com.team_nine.final_project.payload.VisitorDto;
import com.team_nine.final_project.service.AttractionService;
import com.team_nine.final_project.service.AuthorityService;
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
@RequestMapping("api/attraction")
public class AttractionController {

    private final AttractionService attractionService;
    private final AuthorityService authorityService;

    @Autowired
    public AttractionController(AttractionService attractionService, AuthorityService authorityService) {
        this.attractionService = attractionService;
        this.authorityService = authorityService;
    }

    @PostMapping("manager")
    public ResponseEntity<AttractionDto> createAttraction(@RequestBody AttractionManageDto attractionManageDto) {

        authorityService.isManager(attractionManageDto.getVisitorDto());
        return new ResponseEntity<>(attractionService.createAttraction(attractionManageDto.getAttractionDto()), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AttractionDto>> getAllAttractions() {
        return new ResponseEntity<>(attractionService.getAllAttractions(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<AttractionDto> getAttractionById(@PathVariable long id) {
        return new ResponseEntity<>(attractionService.getAttractionById(id), HttpStatus.OK);
    }

    @PutMapping("manager/{id}")
    public ResponseEntity<AttractionDto> updateAttraction(@RequestBody AttractionManageDto attractionManageDtoDto,
                                                          @PathVariable long id) {
        authorityService.isManager(attractionManageDtoDto.getVisitorDto());
        return ResponseEntity.ok(attractionService.updateAttractionById(attractionManageDtoDto.getAttractionDto(), id));
    }

    @DeleteMapping("manager/{id}")
    public ResponseEntity<String> deleteAttractionById(@RequestBody VisitorDto visitorDto,
                                                       @PathVariable long id) {
        authorityService.isManager(visitorDto);
        attractionService.deleteAttractionById(id);
        return ResponseEntity.ok("Attraction entity deleted successfully!");
    }
}
