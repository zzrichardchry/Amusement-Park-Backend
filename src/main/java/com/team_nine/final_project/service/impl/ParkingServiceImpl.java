package com.team_nine.final_project.service.impl;

import com.team_nine.final_project.dao.ParkingRepository;
import com.team_nine.final_project.dao.VisitorRepository;
import com.team_nine.final_project.entity.Parking;
import com.team_nine.final_project.entity.Visitor;
import com.team_nine.final_project.exception.ResourceNotFoundException;
import com.team_nine.final_project.payload.ParkingDto;
import com.team_nine.final_project.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author zhuhaotian
 * @Date 2023/5/4
 */

@Service
public class ParkingServiceImpl implements ParkingService {

    private final ParkingRepository parkingRepository;
    private final VisitorRepository visitorRepository;
    @Autowired
    public ParkingServiceImpl(ParkingRepository parkingRepository, VisitorRepository visitorRepository) {
        this.parkingRepository = parkingRepository;
        this.visitorRepository = visitorRepository;
    }

    @Override
    public List<ParkingDto> getParkingByVisitorId(long id) {
        // Parking parking = parkingRepository.findByVisitId(id).orElseThrow(() -> new ResourceNotFoundException("Parking", "visitor id", id));
        Visitor visitor = visitorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Visitor", "id", id));
        return parkingRepository.findByVisitor(visitor).stream()
                .map(ParkingServiceImpl::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ParkingDto getParkingById(long id) {
        Parking parking = parkingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Parking", "id", id));
        return mapToDto(parking);
    }

    private static ParkingDto mapToDto(Parking parking) {
        ParkingDto ret = new ParkingDto();

        ret.setId(parking.getId());
        ret.setParkingLot(parking.getParkingLot());
        ret.setSpotNumber(parking.getSpotNumber());
        ret.setEnterTime(parking.getEnterTime());
        ret.setExitTime(parking.getExitTime());
        ret.setFee(parking.getFee());

        return ret;
    }

    private static Parking mapToEntity(ParkingDto parkingDto) {
        Parking ret = new Parking();

        ret.setId(parkingDto.getId());
        ret.setParkingLot(parkingDto.getParkingLot());
        ret.setSpotNumber(parkingDto.getSpotNumber());
        ret.setEnterTime(parkingDto.getEnterTime());
        ret.setExitTime(parkingDto.getExitTime());
        ret.setFee(parkingDto.getFee());

        return ret;
    }
}
