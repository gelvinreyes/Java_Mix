package com.runtastic.level1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;


import javax.persistence.*;


@Data
//@AllArgsConstructor
@Entity
public class GPS {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column (name="latitude")
    private String latitude;
    @Column (name="longitude")
    private String longitude;

    public String getLatitude() {
        return this.latitude;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GPS(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }


    public GPS(){}
}
