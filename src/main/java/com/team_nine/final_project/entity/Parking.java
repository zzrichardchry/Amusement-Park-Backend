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
        name = "parking"
)
public class Parking {

    @Id
    @Column(name = "pk_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "pk_lot", nullable = false)
    private String parkingLot;

    @Column(name = "spot_num", nullable = false)
    private String spotNumber;

    @Column(name = "time_in", nullable = false)
    private LocalDateTime enterTime;

    @Column(name = "time_out", nullable = false)
    private LocalDateTime exitTime;

    @Column(name = "park_fee", nullable = false)
    private short fee;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visit_id", referencedColumnName = "visit_id", nullable = false)
    private Visitor visitor;

    @Column(name = "inv_id", nullable = false)
    private long invoiceId;
}
