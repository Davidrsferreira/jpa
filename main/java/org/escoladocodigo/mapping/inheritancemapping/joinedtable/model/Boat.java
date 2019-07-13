package org.escoladocodigo.mapping.inheritancemapping.joinedtable.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "BoatJoinedTable")
@Table(name = "boat_joined_table")
public class Boat extends Vehicle {

    private int gears;

    public int getGears() {
        return gears;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }
}
