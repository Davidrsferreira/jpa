package org.escoladocodigo.mapping.inheritancemapping.tableperclass.model;

import javax.persistence.*;

@Entity
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Vehicle {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private int id;
    private int maxSpeed;

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
