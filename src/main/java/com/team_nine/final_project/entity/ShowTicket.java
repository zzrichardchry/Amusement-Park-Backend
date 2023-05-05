package com.team_nine.final_project.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @Author zhuhaotian
 * @Date 2023/5/4
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (
        name = "sw_tk"
)
public class ShowTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "visit_id", nullable = false)
    private long visitorId;

    @Column(name = "show_id", nullable = false)
    private long showId;

    @Column(name = "inv_inv_id", nullable = false)
    private long invoiceId;

    @Column(name = "srt_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;

    @Column(name = "qty", nullable = false)
    private short quantity;

    @Column(name = "price", nullable = false)
    private double price;

}
