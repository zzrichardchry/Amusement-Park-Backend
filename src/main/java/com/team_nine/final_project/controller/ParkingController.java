package com.team_nine.final_project.controller;

import com.team_nine.final_project.payload.ParkingDto;
import com.team_nine.final_project.payload.VisitorDto;
import com.team_nine.final_project.service.AuthorityService;
import com.team_nine.final_project.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author zhuhaotian
 * @Date 2023/5/4
 */

@RestController
@RequestMapping("api/parking")
public class ParkingController {

    private final ParkingService parkingService;
    private final AuthorityService authorityService;
    @Autowired
    public ParkingController(ParkingService parkingService, AuthorityService authorityService) {
        this.parkingService = parkingService;
        this.authorityService = authorityService;
    }

    @GetMapping("visitor/{id}")
    public ResponseEntity<List<ParkingDto>> getParkingByVisitorId(@PathVariable long id) {
        return ResponseEntity.ok(parkingService.getParkingByVisitorId(id));
    }

    @GetMapping("manager/{id}")
    public ResponseEntity<ParkingDto> getParkingById(@RequestBody VisitorDto visitorDto,
                                                  @PathVariable long id) {
        authorityService.isManager(visitorDto);

        return ResponseEntity.ok(parkingService.getParkingById(id));
    }
}
