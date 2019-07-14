package org.escoladocodigo.associations.onetoone.model;

import javax.persistence.*;

@Entity
@Table (name = "owner")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToOne(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "owner"
    )
    private Car car;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
