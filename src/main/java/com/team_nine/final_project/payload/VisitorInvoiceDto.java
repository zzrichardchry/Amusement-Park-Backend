package com.team_nine.final_project.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author zhuhaotian
 * @Date 2023/5/5
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VisitorInvoiceDto {

    private VisitorDto visitorDto;
    private InvoiceDto invoiceDto;

}
