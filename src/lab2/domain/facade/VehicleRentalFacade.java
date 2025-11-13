package lab2.domain.facade;

import lab1.domain.builder.CarBuilder;
import lab1.domain.builder.CarDirector;
import lab1.domain.models.Car;
import lab1.domain.models.Vehicle;
import lab1.domain.singleton.VehicleRegistry;
import lab2.domain.decorator.ChildSeatDecorator;
import lab2.domain.decorator.GPSDecorator;
import lab2.domain.decorator.InsuranceDecorator;
import lab2.domain.models.BasicRentalVehicle;
import lab2.domain.models.RentalVehicle;

/**
 * FACADE PATTERN - Provides a simplified interface to the complex vehicle rental system.
 * Hides the complexity of creating vehicles, adding features, and registering them.
 */
public class VehicleRentalFacade {
    private final VehicleRegistry registry;
    private final CarBuilder carBuilder;
    private final CarDirector carDirector;

    public VehicleRentalFacade() {
        this.registry = VehicleRegistry.getInstance();
        this.carBuilder = new CarBuilder();
        this.carDirector = new CarDirector(carBuilder);
    }

    /**
     * Simplified method to rent a basic economy car.
     */
    public RentalVehicle rentBasicEconomyCar() {
        Car car = carDirector.constructEconomyCar();
        registry.register(car);
        return new BasicRentalVehicle(car, 30.0);
    }

    /**
     * Simplified method to rent a family sedan with full package.
     */
    public RentalVehicle rentFamilyPackage() {
        Car car = carDirector.constructFamilySedan();
        registry.register(car);

        RentalVehicle rental = new BasicRentalVehicle(car, 50.0);
        rental = new InsuranceDecorator(rental);
        rental = new GPSDecorator(rental);
        rental = new ChildSeatDecorator(rental);

        return rental;
    }

    /**
     * Simplified method to rent a sports car with insurance and GPS.
     */
    public RentalVehicle rentSportsPremiumPackage() {
        Car car = carDirector.constructSportsCar();
        registry.register(car);

        RentalVehicle rental = new BasicRentalVehicle(car, 100.0);
        rental = new InsuranceDecorator(rental);
        rental = new GPSDecorator(rental);

        return rental;
    }

    /**
     * Simplified method to create a custom rental with selected options.
     */
    public RentalVehicle rentCustomVehicle(Vehicle vehicle, double basePrice,
                                           boolean needsInsurance, boolean needsGPS, boolean needsChildSeat) {
        registry.register(vehicle);

        RentalVehicle rental = new BasicRentalVehicle(vehicle, basePrice);

        if (needsInsurance) {
            rental = new InsuranceDecorator(rental);
        }
        if (needsGPS) {
            rental = new GPSDecorator(rental);
        }
        if (needsChildSeat) {
            rental = new ChildSeatDecorator(rental);
        }

        return rental;
    }

    /**
     * Get the vehicle registry instance.
     */
    public VehicleRegistry getRegistry() {
        return registry;
    }
}

