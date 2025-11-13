package lab2.domain.models;

import lab1.domain.models.Vehicle;

/**
 * Concrete implementation of RentalVehicle that wraps a Vehicle.
 * This is the base component for the Decorator pattern.
 */
public class BasicRentalVehicle implements RentalVehicle {
    private final Vehicle vehicle;
    private final double basePrice;

    public BasicRentalVehicle(Vehicle vehicle, double basePrice) {
        this.vehicle = vehicle;
        this.basePrice = basePrice;
    }

    @Override
    public String getDescription() {
        return vehicle.getDescription();
    }

    @Override
    public double getPrice() {
        return basePrice;
    }

    @Override
    public String getFeatures() {
        return "Basic rental";
    }
}

