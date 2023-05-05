package com.team_nine.final_project.service;

import com.team_nine.final_project.payload.InvoiceDto;
import com.team_nine.final_project.payload.VisitorActivityDto;
import com.team_nine.final_project.payload.VisitorDto;

import java.util.List;

/**
 * @Author zhuhaotian
 * @Date 2023/5/4
 */

public interface VisitorService {

    List<VisitorDto> getAllVisitors();

    VisitorDto getVisitorById(long id);

    VisitorActivityDto getVisitorActivityById(long id);

}
