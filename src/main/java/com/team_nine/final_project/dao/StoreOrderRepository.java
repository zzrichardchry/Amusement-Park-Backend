package com.team_nine.final_project.dao;

import com.team_nine.final_project.entity.StoreOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zhuhaotian
 * @Date 2023/5/4
 */

@Repository
public interface StoreOrderRepository extends JpaRepository<StoreOrder, Long> {

    List<StoreOrder> findByVisitorId(long id);
}
