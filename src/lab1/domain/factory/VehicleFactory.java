package lab1.domain.factory;

import lab1.domain.models.Vehicle;

/**
 * Abstract Creator for Factory Method pattern.
 * Declares the factory method that returns a Vehicle object.
 * Subclasses will provide the actual implementation.
 */
public abstract class VehicleFactory {

    /**
     * Factory method - to be implemented by concrete creators.
     * Each concrete factory will create a specific type of vehicle.
     */
    public abstract Vehicle createVehicle();

    /**
     * Business logic that works with the product returned by factory method.
     * This demonstrates that the creator can work with vehicles without
     * knowing their concrete classes.
     */
    public void deliverVehicle() {
        Vehicle vehicle = createVehicle();
        System.out.println("Factory produced: " + vehicle.getDescription());
    }
}

