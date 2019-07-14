package org.escoladocodigo.associations.onetoone;

import org.escoladocodigo.associations.onetoone.model.Car;
import org.escoladocodigo.associations.onetoone.model.Owner;
import org.escoladocodigo.associations.onetoone.service.Service;

public class OneToOneMain {

    public static void main(String[] args) {

        Service service = new Service();
        Car car1 = new Car();
        Owner owner1 = new Owner();
        Car car2 = new Car();
        Owner owner2 = new Owner();

        car1.setMake("BMW");
        car1.setModel("X5");
        car1.setOwner(owner1);
        car2.setMake("Opel");
        car2.setModel("Corsa");
        car2.setOwner(owner2);

        owner1.setName("Jorgito");
        owner1.setCar(car1);
        owner2.setName("Carlitos");
        owner2.setCar(car2);

        service.saveOrUpdate(owner1);
        service.saveOrUpdate(owner2);

        service.remove(1);

        service.close();
    }
}
