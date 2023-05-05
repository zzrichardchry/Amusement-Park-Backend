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
        name = "attraction"
)
public class Attraction {

    @Id
    @Column(name = "a_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "at_name", nullable = false)
    private String name;

    @Column(name = "a_descp", nullable = false)
    private String description;

    @Column(name = "at_type", nullable = false)
    private String type;

    @Column(name = "status", nullable = false)
    private char status;

    @Column(name = "min_height", nullable = false)
    private double height;

    @Column(name = "a_duration", nullable = false)
    private short duration;

    @Column(name = "loc_section", nullable = false)
    private String section;

    @Column(name = "capacity", nullable = false)
    private short capacity;
}
