package com.team_nine.final_project.dao;

import com.team_nine.final_project.entity.Parking;
import com.team_nine.final_project.entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @Author zhuhaotian
 * @Date 2023/5/4
 */

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long> {

    List<Parking> findByVisitor(Visitor visitor);

}
