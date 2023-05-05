package com.team_nine.final_project.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Author zhuhaotian
 * @Date 2023/5/4
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParkingDto {

    private long id;

    private String parkingLot;
    private String spotNumber;

    private LocalDateTime enterTime;
    private LocalDateTime exitTime;

    private short fee;

}