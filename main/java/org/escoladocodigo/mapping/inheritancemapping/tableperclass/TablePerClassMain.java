package org.escoladocodigo.mapping.inheritancemapping.tableperclass;

import org.escoladocodigo.mapping.inheritancemapping.tableperclass.model.Boat;
import org.escoladocodigo.mapping.inheritancemapping.tableperclass.model.Car;
import org.escoladocodigo.mapping.inheritancemapping.tableperclass.service.BoatService;
import org.escoladocodigo.mapping.inheritancemapping.tableperclass.service.CarService;

public class TablePerClassMain {

    public static void main(String[] args) {

        Car car = new Car();
        Boat boat = new Boat();
        CarService carService = new CarService();
        BoatService boatService = new BoatService();

        car.setEngines(1500);
        car.setMaxSpeed(200);

        boat.setGears(20);
        boat.setMaxSpeed(55);

        carService.saveOrUpdate(car);
        boatService.saveOrUpdate(boat);

        carService.close();
        boatService.close();

    }

}
