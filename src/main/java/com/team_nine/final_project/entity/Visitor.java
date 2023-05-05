package com.team_nine.final_project.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;

/**
 * @Author zhuhaotian
 * @Date 2023/5/4
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "visitor"
)
public class Visitor {

    @Id
    @Column(name = "visit_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "v_fname", nullable = false)
    private String firstName;

    @Column(name = "v_lname", nullable = false)
    private String lastName;

    @Column(name = "v_email", nullable = false)
    private String email;

    @Column(name = "ph_no", nullable = false)
    private long phoneNumber;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "zipcode", nullable = false)
    private String zipcode;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "dob", nullable = false)
    private LocalDateTime dob;

    @Column(name = "v_type", nullable = false)
    private char visitorType;

    @Column(name = "A_type", nullable = false)
    private char aType;

    @OneToOne(mappedBy = "visitor", cascade = CascadeType.ALL, orphanRemoval = true)
    private Parking parking;
}
