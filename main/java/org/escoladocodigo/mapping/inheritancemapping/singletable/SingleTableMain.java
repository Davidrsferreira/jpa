package org.escoladocodigo.mapping.inheritancemapping.singletable;

import org.escoladocodigo.mapping.inheritancemapping.singletable.model.Boat;
import org.escoladocodigo.mapping.inheritancemapping.singletable.model.Car;
import org.escoladocodigo.mapping.inheritancemapping.singletable.service.BoatService;
import org.escoladocodigo.mapping.inheritancemapping.singletable.service.CarService;

public class SingleTableMain {

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
