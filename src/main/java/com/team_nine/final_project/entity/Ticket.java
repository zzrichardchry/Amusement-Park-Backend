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
        name = "ticket"
)
public class Ticket {

    @Id
    @Column(name = "tk_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "tk_method", nullable = false)
    private String method;

    @Column(name = "purchase_date", nullable = false)
    private LocalDateTime purchaseDate;

    @Column(name = "tk_price", nullable = false)
    private double price;

    @Column(name = "visit_date", nullable = false)
    private LocalDateTime visitDate;

    @Column(name = "discount", nullable = false)
    private double discount;

    @Column(name = "visit_id", nullable = false)
    private long visitorId;

    @Column(name = "inv_id", nullable = false)
    private long invoiceId;
}
