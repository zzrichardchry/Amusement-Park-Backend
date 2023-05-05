package com.team_nine.final_project.dao;

import com.team_nine.final_project.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author zhuhaotian
 * @Date 2023/5/4
 */

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {

}
