package com.team_nine.final_project.service;

import com.team_nine.final_project.payload.ShowDto;

import java.util.List;

/**
 * @Author zhuhaotian
 * @Date 2023/5/4
 */

public interface ShowService {

    ShowDto createShow(ShowDto showDto);

    List<ShowDto> getAllShows();

    ShowDto getShowById(long id);

    ShowDto updateShowById(ShowDto showDto, long id);

    void deleteShowById(long id);
}
