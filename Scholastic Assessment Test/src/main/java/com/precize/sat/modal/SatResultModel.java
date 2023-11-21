package com.precize.sat.modal;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SatResultModel {

    private long id;

    private String name;

    private String address;

    private String city;

    private String country;

    private int pincode;

    private double score;

}
