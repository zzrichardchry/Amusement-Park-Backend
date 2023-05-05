package com.team_nine.final_project.service;

import com.team_nine.final_project.payload.InvoiceDto;
import com.team_nine.final_project.payload.VisitorInvoiceDto;

import java.util.List;

/**
 * @Author zhuhaotian
 * @Date 2023/5/5
 */

public interface InvoiceService {

    List<InvoiceDto> getAllInvoice();

    InvoiceDto getInvoiceById(long id);

//    void deleteInvoiceById(long id);
}
