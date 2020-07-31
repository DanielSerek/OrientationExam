package com.greenfox.orientationexam.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="planet")
public class Planet {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Long population;

    public Planet (String name, Long population){
        this.name = name;
        this.population = population;
    }

    public Planet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }
}
