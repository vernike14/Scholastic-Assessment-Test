package com.precize.sat.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SAT_RESULTS")
public class SatResults {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "NAME", unique = true)
    private String name;

    @Column(name = "ADDRESS", length = 800)
    private String address;

    @Column(name = "CITY")
    private String city;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "PINCODE")
    private int pincode;

    @Column(name = "SCORE")
    private double score;

}

