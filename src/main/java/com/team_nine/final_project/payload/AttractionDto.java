package com.team_nine.final_project.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author zhuhaotian
 * @Date 2023/5/4
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttractionDto {

    private long id;

    private String name;
    private String description;
    private String type;
    private char status;
    private double height;
    private short duration;
    private String section;
    private short capacity;

}
