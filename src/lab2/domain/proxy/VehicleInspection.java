package lab2.domain.proxy;

import lab1.domain.models.Vehicle;

/**
 * Interface for vehicle inspection operations.
 * Used with the Proxy pattern to control access to expensive operations.
 */
public interface VehicleInspection {
    String performDetailedInspection();
    String performQuickCheck();
    Vehicle getVehicle();
}