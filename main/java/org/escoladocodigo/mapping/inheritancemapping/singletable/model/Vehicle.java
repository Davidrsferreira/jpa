package org.escoladocodigo.mapping.inheritancemapping.singletable.model;

import javax.persistence.*;

@Entity (name = "VehicleSingleTable")
@Table (name = "vehicle_single")
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "vehicle_type",
        discriminatorType = DiscriminatorType.STRING
)
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
