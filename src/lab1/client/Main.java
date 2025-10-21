package lab1.client;

import lab1.domain.builder.CarBuilder;
import lab1.domain.factory.VehicleFactory;
import lab1.domain.factory.VehicleType;
import lab1.domain.models.Car;
import lab1.domain.models.Vehicle;
import lab1.domain.singleton.VehicleRegistry;

public class Main {
    static void main() {
        // Builder: building a custom car
        Car customCar = new CarBuilder()
                .model("Mercedes")
                .color("Black")
                .engine("V8")
                .year(2022)
                .build();

        // Factory: creating a bike and truck
        Vehicle bike = VehicleFactory.createVehicle(VehicleType.BIKE);
        Vehicle truck = VehicleFactory.createVehicle(VehicleType.TRUCK);

        // Singleton: One registry for all
        VehicleRegistry registry = VehicleRegistry.getInstance();
        registry.register(customCar);
        registry.register(bike);
        registry.register(truck);

        registry.printAll();
    }
}
