package com.team_nine.final_project.entity;

/**
 * @Author zhuhaotian
 * @Date 2023/5/4
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (
        name = "str"
)
public class StoreOrder {

    @Id
    @Column(name = "order_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "qty", nullable = false)
    private long quantity;

    @Column(name = "unit_price", nullable = false)
    private double unitPrice;

    @Column(name = "visit_id", nullable = false)
    private long visitorId;

    @Column(name = "store_id", nullable = false)
    private long storeId;

    @Column(name = "menue_item", nullable = false)
    private String item;

    @Column(name = "inv_id", nullable = false)
    private long invoiceId;
}
