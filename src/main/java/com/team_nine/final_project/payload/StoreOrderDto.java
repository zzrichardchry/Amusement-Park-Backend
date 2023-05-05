package com.team_nine.final_project.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author zhuhaotian
 * @Date 2023/5/4
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StoreOrderDto {

    private long id;

    private String item;
    private long quantity;
    private double unitPrice;

    private long visitorId;
    private long storeId;
    private long invoiceId;

}
