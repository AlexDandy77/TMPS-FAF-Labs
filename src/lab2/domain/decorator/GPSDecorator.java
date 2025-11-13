package lab2.domain.decorator;

import lab2.domain.models.RentalVehicle;

/**
 * DECORATOR PATTERN - Concrete decorator that adds GPS navigation service.
 */
public class GPSDecorator extends RentalVehicleDecorator {
    private static final double GPS_COST = 10.0;

    public GPSDecorator(RentalVehicle vehicle) {
        super(vehicle);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + GPS_COST;
    }

    @Override
    public String getFeatures() {
        return super.getFeatures() + " + GPS Navigation System";
    }
}

