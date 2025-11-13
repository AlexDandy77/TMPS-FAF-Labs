package lab2.domain.decorator;

import lab2.domain.models.RentalVehicle;

/**
 * DECORATOR PATTERN - Base decorator for RentalVehicle.
 * Allows adding responsibilities to RentalVehicle objects dynamically.
 */
public abstract class RentalVehicleDecorator implements RentalVehicle {
    protected RentalVehicle wrappedVehicle;

    public RentalVehicleDecorator(RentalVehicle vehicle) {
        this.wrappedVehicle = vehicle;
    }

    @Override
    public String getDescription() {
        return wrappedVehicle.getDescription();
    }

    @Override
    public double getPrice() {
        return wrappedVehicle.getPrice();
    }

    @Override
    public String getFeatures() {
        return wrappedVehicle.getFeatures();
    }
}