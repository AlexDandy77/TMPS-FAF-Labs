package lab2.domain.decorator;

import lab2.domain.models.RentalVehicle;

/**
 * DECORATOR PATTERN - Concrete decorator that adds child safety seat.
 */
public class ChildSeatDecorator extends RentalVehicleDecorator {
    private static final double CHILD_SEAT_COST = 5.0;

    public ChildSeatDecorator(RentalVehicle vehicle) {
        super(vehicle);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + CHILD_SEAT_COST;
    }

    @Override
    public String getFeatures() {
        return super.getFeatures() + " + Child Safety Seat";
    }
}


