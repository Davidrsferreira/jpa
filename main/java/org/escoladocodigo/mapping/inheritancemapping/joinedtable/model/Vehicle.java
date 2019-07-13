package org.escoladocodigo.mapping.inheritancemapping.joinedtable.model;

import javax.persistence.*;

@Entity (name = "VehicleJoinedTable")
@Table (name = "vehicle_joined_table")
@Inheritance (strategy = InheritanceType.JOINED)
public abstract class Vehicle {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private int maxSpeed;

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
