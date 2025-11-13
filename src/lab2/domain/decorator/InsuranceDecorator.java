package lab2.domain.decorator;

import lab2.domain.models.RentalVehicle;

/**
 * DECORATOR PATTERN - Concrete decorator that adds insurance service.
 */
public class InsuranceDecorator extends RentalVehicleDecorator {
    private static final double INSURANCE_COST = 15.0;

    public InsuranceDecorator(RentalVehicle vehicle) {
        super(vehicle);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + INSURANCE_COST;
    }

    @Override
    public String getFeatures() {
        return super.getFeatures() + " + Full Insurance Coverage";
    }
}

