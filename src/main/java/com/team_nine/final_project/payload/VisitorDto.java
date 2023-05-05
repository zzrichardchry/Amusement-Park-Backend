package com.team_nine.final_project.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @Author zhuhaotian
 * @Date 2023/5/4
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VisitorDto {

    private long id;

    private String firstName;
    private String lastName;
    private String email;
    private long phoneNumber;

    private String street;
    private String city;
    private String state;
    private String zipcode;
    private String country;

    private char visitorType;
    private char aType;

}
