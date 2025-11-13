package lab2.domain.models;

import lab1.domain.models.Vehicle;

/**
 * Extended interface for rental vehicles with pricing information.
 * This will be used with the Decorator pattern to add services.
 */
public interface RentalVehicle extends Vehicle {
    double getPrice();
    String getFeatures();
}
