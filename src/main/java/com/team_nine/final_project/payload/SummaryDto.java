package com.team_nine.final_project.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @Author zhuhaotian
 * @Date 2023/5/4
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SummaryDto {

    private long id;

    private long visitorId;
    private LocalDateTime visitDate;

    private long ticketId;
    private double ticketAmount;

    private long showId;
    private double showAmount;

    private int parkingId;
    private double parkingAmount;

    private long storeId;
    private double storeAmount;
}
