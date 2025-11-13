package lab1.domain.factory;

import lab1.domain.models.Car;
import lab1.domain.models.Vehicle;

/**
 * Concrete Creator 1: Factory for luxury cars.
 * Implements the factory method to create luxury car variants.
 */
public class LuxuryCarFactory extends VehicleFactory {

    @Override
    public Vehicle createVehicle() {
        return new Car(
            "Mercedes-Benz",
            "S-Class",
            "Black",
            "V8 Twin-Turbo",
            2024,
            true,
            true
        );
    }
}

