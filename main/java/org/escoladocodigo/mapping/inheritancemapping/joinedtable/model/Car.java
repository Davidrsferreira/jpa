package org.escoladocodigo.mapping.inheritancemapping.joinedtable.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity (name = "CarJoinedTable")
@Table(name = "car_joined_table")
public class Car extends Vehicle {

    private int engines;

    public int getEngines() {
        return engines;
    }

    public void setEngines(int engines) {
        this.engines = engines;
    }
}
