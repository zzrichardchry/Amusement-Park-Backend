package com.team_nine.final_project.service;

import com.team_nine.final_project.payload.AttractionDto;

import java.util.List;

/**
 * @Author zhuhaotian
 * @Date 2023/5/4
 */

public interface AttractionService {

    AttractionDto createAttraction(AttractionDto attractionDto);

    List<AttractionDto> getAllAttractions();

    AttractionDto getAttractionById(long id);

    AttractionDto updateAttractionById(AttractionDto attractionDto, long id);

    void deleteAttractionById(long id);
}
