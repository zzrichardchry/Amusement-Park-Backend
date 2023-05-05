package com.team_nine.final_project.controller;

import com.team_nine.final_project.payload.VisitorActivityDto;
import com.team_nine.final_project.payload.VisitorDto;
import com.team_nine.final_project.service.AuthorityService;
import com.team_nine.final_project.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author zhuhaotian
 * @Date 2023/5/4
 */

@RestController
@RequestMapping("api/visitor")
public class VisitorController {

    private final VisitorService visitorService;
    private final AuthorityService authorityService;
    @Autowired
    public VisitorController(VisitorService visitorService, AuthorityService authorityService) {
        this.visitorService = visitorService;
        this.authorityService = authorityService;
    }

    @GetMapping
    public ResponseEntity<List<VisitorDto>> getAllVisitors() {
        return ResponseEntity.ok(visitorService.getAllVisitors());
    }

    @GetMapping("{id}")
    public ResponseEntity<VisitorDto> getVisitorById(@PathVariable long id) {
        return ResponseEntity.ok(visitorService.getVisitorById(id));
    }

    @GetMapping("manager/{id}")
    public ResponseEntity<VisitorActivityDto> getVisitorActivityById(@RequestBody VisitorDto visitorDto,
                                                                     @PathVariable long id) {

        authorityService.isManager(visitorDto);
        return ResponseEntity.ok(visitorService.getVisitorActivityById(id));
    }
}
