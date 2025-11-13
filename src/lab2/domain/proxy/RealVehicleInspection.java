package lab2.domain.proxy;

import lab1.domain.models.Vehicle;

/**
 * Real subject that performs actual (expensive) vehicle inspection.
 */
public class RealVehicleInspection implements VehicleInspection {
    private final Vehicle vehicle;

    public RealVehicleInspection(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String performDetailedInspection() {
        // Simulate expensive operation (database query, external API call, etc.)
        System.out.println("   [RealInspection] Performing detailed inspection (expensive operation)...");
        simulateExpensiveOperation();
        return "Detailed Inspection Report for: " + vehicle.getDescription() +
               "\n   - Engine: OK\n   - Brakes: OK\n   - Tires: OK\n   - Electronics: OK";
    }

    @Override
    public String performQuickCheck() {
        System.out.println("   [RealInspection] Performing quick check...");
        return "Quick Check: " + vehicle.getDescription() + " - Basic Status: OK";
    }

    @Override
    public Vehicle getVehicle() {
        return vehicle;
    }

    private void simulateExpensiveOperation() {
        try {
            Thread.sleep(500); // Simulate delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

