package com.team_nine.final_project.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

/**
 * @Author zhuhaotian
 * @Date 2023/5/4
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VisitorActivityDto {

    private long id;

    private char visitorType;

    private Set<Long> showIds;
    private Set<Long> parkingIds;
    private Set<Long> orderIds;
    private Set<Long> ticketIds;
    private Set<Integer> attractionIds;
    private Set<Long> invoiceIds;

    private double amount;
}
