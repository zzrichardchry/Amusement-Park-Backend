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
        name = "at_tk"
)
public class AttractionTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "tk_id", nullable = false)
    private long ticketId;

    @Column(name = "a_id", nullable = false)
    private int attractionId;

    @Column(name = "a_date", nullable = false)
    private LocalDateTime date;
}
