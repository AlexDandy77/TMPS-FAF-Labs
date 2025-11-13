package lab1.domain.singleton;

import lab1.domain.models.Vehicle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Singleton pattern implementation for VehicleRegistry.
 * Ensures only one registry instance exists throughout the application.
 * Thread-safe using double-checked locking.
 */
public class VehicleRegistry {
    private static volatile VehicleRegistry instance;
    private final List<Vehicle> vehicles = new ArrayList<>();

    // Private constructor prevents direct instantiation
    private VehicleRegistry() {}

    /**
     * Thread-safe lazy initialization with double-checked locking.
     */
    public static VehicleRegistry getInstance() {
        if (instance == null) {
            synchronized (VehicleRegistry.class) {
                if (instance == null) {
                    instance = new VehicleRegistry();
                }
            }
        }
        return instance;
    }

    /**
     * Register a vehicle in the registry.
     */
    public void register(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("vehicle must be non-null");
        }
        vehicles.add(vehicle);
        System.out.println("[Registry] Registered: " + vehicle.getDescription());
    }

    /**
     * Get all registered vehicles (unmodifiable).
     */
    public List<Vehicle> getAll() {
        return Collections.unmodifiableList(vehicles);
    }

    /**
     * Get total count of registered vehicles.
     */
    public int count() {
        return vehicles.size();
    }

    /**
     * Print all registered vehicles.
     */
    public void printAll() {
        System.out.println("\n========== Vehicle Registry ==========");
        System.out.println("Total vehicles: " + vehicles.size());
        System.out.println("--------------------------------------");
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println((i + 1) + ". " + vehicles.get(i).getDescription());
        }
        System.out.println("======================================\n");
    }

    /**
     * Clear all vehicles (useful for testing).
     */
    public void clear() {
        vehicles.clear();
    }
}
