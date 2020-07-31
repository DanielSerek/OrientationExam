package com.greenfox.orientationexam.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="spaceship")
public class Spaceship {

    @Id
    @GeneratedValue
    private Long id;
    private Long max_capacity;
    private Long planet_id;
    private Long utilization;

    public Spaceship(Long max_capacity, Long planet_id, Long utilization){
        this.max_capacity = max_capacity;
        this.planet_id = planet_id;
        this.utilization = utilization;
    }

    public Spaceship() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMax_capacity() {
        return max_capacity;
    }

    public void setMax_capacity(Long max_capacity) {
        this.max_capacity = max_capacity;
    }

    public Long getPlanet_id() {
        return planet_id;
    }

    public void setPlanet_id(Long planet_id) {
        this.planet_id = planet_id;
    }

    public Long getUtilization() {
        return utilization;
    }

    public void setUtilization(Long utilization) {
        this.utilization = utilization;
    }
}
