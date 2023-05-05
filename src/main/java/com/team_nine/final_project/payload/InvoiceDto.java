package com.team_nine.final_project.payload;

import com.team_nine.final_project.entity.Parking;
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
public class InvoiceDto {

    private long id;

    private LocalDateTime dateTime;

    private double amount;

    private long parkingId;

}
