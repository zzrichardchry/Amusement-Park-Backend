package com.team_nine.final_project.dao;

import com.team_nine.final_project.entity.ShowTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zhuhaotian
 * @Date 2023/5/4
 */

@Repository
public interface ShowTicketRepository extends JpaRepository<ShowTicket, Long> {

    List<ShowTicket> findByVisitorId(long id);

}
