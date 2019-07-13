package org.escoladocodigo.mapping.inheritancemapping.tableperclass.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "boat_per_class")
public class Boat extends Vehicle {

    private int gears;

    public int getGears() {
        return gears;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }
}
