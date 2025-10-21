package lab1.domain.factory;
import lab1.domain.models.*;

public class VehicleFactory {
    public static Vehicle createVehicle(VehicleType type) {
        return switch(type) {
            case CAR -> new Car("Mercedes", "Black", "V8", 2022);
            case BIKE -> new Bike();
            case TRUCK -> new Truck();
        };
    }
}
