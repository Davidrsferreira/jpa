package org.escoladocodigo.mapping.inheritancemapping.singletable.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity (name = "CarSingleTable")
@DiscriminatorValue("car")
public class Car extends Vehicle {

    private int engines;

    public int getEngines() {
        return engines;
    }

    public void setEngines(int engines) {
        this.engines = engines;
    }
}
