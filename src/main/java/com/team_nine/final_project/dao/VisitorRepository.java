package com.team_nine.final_project.dao;

import com.team_nine.final_project.entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author zhuhaotian
 * @Date 2023/5/4
 */

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Long> {

}
