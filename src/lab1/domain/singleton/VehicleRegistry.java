package lab1.domain.singleton;

import lab1.domain.models.Vehicle;
import java.util.ArrayList;
import java.util.List;

public class VehicleRegistry {
    private static VehicleRegistry instance;
    private final List<Vehicle> vehicles = new ArrayList<>();
    private VehicleRegistry() {}

    public static synchronized VehicleRegistry getInstance() {
        if (instance == null) {
            instance = new VehicleRegistry();
        }
        return instance;
    }

    public void register(Vehicle vehicle) {
        vehicles.add(vehicle);
        System.out.println("[Registry] Vehicle added: " + vehicle.getDescription());
    }

    public void printAll() {
        System.out.println("--- Vehicle Registry ---");
        for (Vehicle v : vehicles) {
            System.out.println(v.getDescription());
        }
    }
}
