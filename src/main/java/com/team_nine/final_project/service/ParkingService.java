package com.team_nine.final_project.service;

import com.team_nine.final_project.payload.ParkingDto;

import java.util.List;

/**
 * @Author zhuhaotian
 * @Date 2023/5/4
 */

public interface ParkingService {

    List<ParkingDto> getParkingByVisitorId(long id);

    ParkingDto getParkingById(long id);

}
