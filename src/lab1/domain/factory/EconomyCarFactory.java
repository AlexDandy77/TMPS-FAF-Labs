package lab1.domain.factory;

import lab1.domain.models.Car;
import lab1.domain.models.Vehicle;

/**
 * Concrete Creator 2: Factory for economy cars.
 * Implements the factory method to create affordable car variants.
 */
public class EconomyCarFactory extends VehicleFactory {

    @Override
    public Vehicle createVehicle() {
        return new Car(
            "Dacia",
            "Logan",
            "White",
            "1.0L 3-Cylinder",
            2023,
            false,
            false
        );
    }
}

