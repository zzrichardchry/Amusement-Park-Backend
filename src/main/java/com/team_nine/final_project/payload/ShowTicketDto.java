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
public class ShowTicketDto {

    private long id;

    private long visitorId;
    private long showId;
    private long invoiceId;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private short quantity;
    private double price;

}
