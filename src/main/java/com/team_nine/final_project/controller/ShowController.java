package com.team_nine.final_project.controller;

import com.team_nine.final_project.payload.ShowDto;
import com.team_nine.final_project.payload.manage.ShowManageDto;
import com.team_nine.final_project.service.AuthorityService;
import com.team_nine.final_project.service.ShowService;
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
@RequestMapping("api/show")
public class ShowController {

    private final ShowService showService;
    private final AuthorityService authorityService;
    @Autowired
    public ShowController(ShowService showService, AuthorityService authorityService) {
        this.showService = showService;
        this.authorityService = authorityService;
    }

    @PostMapping
    public ResponseEntity<ShowDto> createShow(@RequestBody ShowManageDto showManageDto) {
        authorityService.isManager(showManageDto.getVisitorDto());
        return new ResponseEntity<>(showService.createShow(showManageDto.getShowDto()), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ShowDto>> getAllShows() {
        return ResponseEntity.ok(showService.getAllShows());
    }

    @GetMapping("{id}")
    public ResponseEntity<ShowDto> getShowById(@PathVariable long id) {
        return ResponseEntity.ok(showService.getShowById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<ShowDto> updateShowById(@RequestBody ShowManageDto showManageDto,
                                                  @PathVariable long id) {
        authorityService.isManager(showManageDto.getVisitorDto());
        return ResponseEntity.ok(showService.updateShowById(showManageDto.getShowDto(), id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteShowById(@PathVariable long id) {
        showService.deleteShowById(id);
        return new ResponseEntity<>("Show entity deleted successfully!", HttpStatus.OK);
    }

}
