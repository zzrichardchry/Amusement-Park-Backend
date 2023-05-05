package com.team_nine.final_project.payload.manage;

import com.team_nine.final_project.payload.ShowDto;
import com.team_nine.final_project.payload.VisitorDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author zhuhaotian
 * @Date 2023/5/5
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShowManageDto {

    private VisitorDto visitorDto;
    private ShowDto showDto;
}
