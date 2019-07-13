package org.escoladocodigo.mapping.inheritancemapping.singletable.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "BoatSingleTable")
@DiscriminatorValue("boat")
public class Boat extends Vehicle{

    private int gears;

    public int getGears() {
        return gears;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }
}
