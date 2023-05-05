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
@Table(
        name = "inv"
)
public class Invoice {

    @Id
    @Column(name = "inv_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "inv_date", nullable = false)
    private LocalDateTime dateTime;

    @Column(name = "inv_amt", nullable = false)
    private double amount;

    @Column(name = "pk_id", nullable = false)
    private long parkingId;
}
