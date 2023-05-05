package com.team_nine.final_project.service.impl;

import com.team_nine.final_project.dao.AttractionRepository;
import com.team_nine.final_project.entity.Attraction;
import com.team_nine.final_project.exception.ResourceNotFoundException;
import com.team_nine.final_project.payload.AttractionDto;
import com.team_nine.final_project.service.AttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Attr;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author zhuhaotian
 * @Date 2023/5/4
 */

@Service
public class AttractionServiceImpl implements AttractionService {

    private final AttractionRepository attractionRepository;
    @Autowired
    public AttractionServiceImpl(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }


    @Override
    public AttractionDto createAttraction(AttractionDto attractionDto) {
        Attraction attraction = mapToEntity(attractionDto);

        Attraction savedAttraction = attractionRepository.save(attraction);
        return mapToDto(savedAttraction);
    }

    @Override
    public List<AttractionDto> getAllAttractions() {
        return attractionRepository.findAll().stream()
                .map(AttractionServiceImpl::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public AttractionDto getAttractionById(long id) {
        Attraction attraction = attractionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Attraction", "id", id));

        return mapToDto(attraction);
    }

    @Override
    public AttractionDto updateAttractionById(AttractionDto attractionDto, long id) {
        Attraction attraction = attractionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Attraction", "id", id));

        attraction.setName(attractionDto.getName());
        attraction.setDescription(attractionDto.getDescription());
        attraction.setType(attractionDto.getType());
        attraction.setStatus(attractionDto.getStatus());
        attraction.setHeight(attractionDto.getHeight());
        attraction.setDuration(attractionDto.getDuration());
        attraction.setSection(attractionDto.getSection());
        attraction.setCapacity(attractionDto.getCapacity());

        Attraction savedAttraction = attractionRepository.save(attraction);
        return mapToDto(savedAttraction);
    }

    @Override
    public void deleteAttractionById(long id) {
        Attraction attraction = attractionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Attraction", "id", id));
        attractionRepository.delete(attraction);
    }

    private static AttractionDto mapToDto(Attraction attraction) {
        AttractionDto ret = new AttractionDto();

        ret.setId(attraction.getId());
        ret.setName(attraction.getName());
        ret.setType(attraction.getType());
        ret.setStatus(attraction.getStatus());
        ret.setHeight(attraction.getHeight());
        ret.setDuration(attraction.getDuration());
        ret.setSection(attraction.getSection());
        ret.setCapacity(attraction.getCapacity());
        ret.setDescription(attraction.getDescription());

        return ret;
    }

    private static Attraction mapToEntity(AttractionDto attractionDto) {
        Attraction ret = new Attraction();

        ret.setId(attractionDto.getId());
        ret.setName(attractionDto.getName());
        ret.setType(attractionDto.getType());
        ret.setStatus(attractionDto.getStatus());
        ret.setHeight(attractionDto.getHeight());
        ret.setDuration(attractionDto.getDuration());
        ret.setSection(attractionDto.getSection());
        ret.setCapacity(attractionDto.getCapacity());
        ret.setDescription(attractionDto.getDescription());

        return ret;
    }
}
