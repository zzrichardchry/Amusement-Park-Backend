package com.team_nine.final_project.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
        name = "shows"
)
public class Show {

    @Id
    @Column(name = "show_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "s_name", nullable = false)
    private String name;

    @Column(name = "s_descp", nullable = false)
    private String description;

    @Column(name = "sh_type", nullable = false)
    private String type;

    @Column(name = "wheelchair_acc", nullable = false)
    private char wheelchairAcc;
}
