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
        name = "payment"
)
public class Payment {

    @Id
    @Column(name = "pay_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "inv_id", nullable = false)
    private long invoiceId;

    @Column(name = "pay_method", nullable = false)
    private String payMethod;

    @Column(name = "pay_date", nullable = false)
    private LocalDateTime payDate;

    @Column(name = "name_oncard", nullable = false)
    private String cardHolder;

    @Column(name = "cvv", nullable = false)
    private short cvv;

    @Column(name = "card_number", nullable = false)
    private long cardNumber;

    @Column(name = "exp_date", nullable = false)
    private LocalDateTime expirationDate;
}
