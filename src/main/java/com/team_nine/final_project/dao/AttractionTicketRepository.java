package com.team_nine.final_project.dao;

import com.team_nine.final_project.entity.AttractionTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttractionTicketRepository extends JpaRepository<AttractionTicket, Long> {

    List<AttractionTicket> findByTicketId(long id);
}
