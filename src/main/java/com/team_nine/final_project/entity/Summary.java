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
        name = "summary"
)
public class Summary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "visitor_id", nullable = false)
    private long visitorId;

    @Column(name = "visit_date", nullable = false)
    private LocalDateTime visitDate;

    @Column(name = "ticket_id", nullable = false)
    private long ticketId;

    @Column(name = "ticket_amt", nullable = false)
    private double ticketAmount;

    @Column(name = "show_id", nullable = false)
    private long showId;

    @Column(name = "show_amt", nullable = false)
    private double showAmount;

    @Column(name = "park_id", nullable = false)
    private int parkingId;

    @Column(name = "park_amt", nullable = false)
    private double parkingAmount;

    @Column(name = "store_id", nullable = false)
    private long storeId;

    @Column(name = "store_amt", nullable = false)
    private double storeAmount;
}
