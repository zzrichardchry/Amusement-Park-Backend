package com.team_nine.final_project.service.impl;

import com.team_nine.final_project.dao.ShowRepository;
import com.team_nine.final_project.entity.Show;
import com.team_nine.final_project.exception.ResourceNotFoundException;
import com.team_nine.final_project.payload.ShowDto;
import com.team_nine.final_project.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author zhuhaotian
 * @Date 2023/5/4
 */

@Service
public class ShowServiceImpl implements ShowService {

    private final ShowRepository showRepository;
    @Autowired
    public ShowServiceImpl(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    @Override
    public ShowDto createShow(ShowDto showDto) {
        Show savedShow = showRepository.save(mapToEntity(showDto));
        return mapToDto(savedShow);
    }

    @Override
    public List<ShowDto> getAllShows() {
        return showRepository.findAll().stream()
                .map(ShowServiceImpl::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ShowDto getShowById(long id) {
        Show show = showRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Show", "id", id));
        return mapToDto(show);
    }

    @Override
    public ShowDto updateShowById(ShowDto showDto, long id) {
        Show show = showRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Show", "id", id));

        show.setName(showDto.getName());
        show.setDescription(showDto.getDescription());
        show.setType(showDto.getType());
        show.setWheelchairAcc(showDto.getWheelchairAcc());

        Show savedShow = showRepository.save(show);
        return mapToDto(savedShow);
    }

    @Override
    public void deleteShowById(long id) {
        Show show = showRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Show", "id", id));
        showRepository.delete(show);
    }

    private static ShowDto mapToDto(Show show) {
        ShowDto ret = new ShowDto();

        ret.setId(show.getId());
        ret.setName(show.getName());
        ret.setDescription(show.getDescription());
        ret.setType(show.getType());
        ret.setWheelchairAcc(show.getWheelchairAcc());

        return ret;
    }

    private Show mapToEntity(ShowDto showDto) {
        Show ret = new Show();

        ret.setId(showDto.getId());
        ret.setName(showDto.getName());
        ret.setDescription(showDto.getDescription());
        ret.setType(showDto.getType());
        ret.setWheelchairAcc(showDto.getWheelchairAcc());

        return ret;
    }
}
