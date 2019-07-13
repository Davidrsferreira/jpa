package org.escoladocodigo.mapping.inheritancemapping.tableperclass.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "car_per_class")
public class Car extends Vehicle {

    private int engines;

    public int getEngines() {
        return engines;
    }

    public void setEngines(int engines) {
        this.engines = engines;
    }
}
