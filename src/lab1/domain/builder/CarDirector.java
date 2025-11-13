package lab1.domain.builder;

import lab1.domain.models.Car;

/**
 * Director class that works with Builder.
 * Encapsulates common construction sequences for specific car types.
 */
public class CarDirector {
    private final CarBuilder builder;

    public CarDirector(CarBuilder builder) {
        this.builder = builder;
    }

    /**
     * Constructs a luxury sports car configuration.
     */
    public Car constructSportsCar() {
        builder.reset();
        return builder
                .brand("Porsche")
                .model("911")
                .color("Red")
                .engine("Twin-Turbo Flat-6")
                .year(2024)
                .withGPS(true)
                .withSunroof(false)
                .build();
    }

    /**
     * Constructs a family sedan configuration.
     */
    public Car constructFamilySedan() {
        builder.reset();
        return builder
                .brand("Toyota")
                .model("Camry")
                .color("Silver")
                .engine("4-Cylinder")
                .year(2024)
                .withGPS(true)
                .withSunroof(true)
                .build();
    }

    /**
     * Constructs a basic economy car configuration.
     */
    public Car constructEconomyCar() {
        builder.reset();
        return builder
                .brand("Honda")
                .model("Civic")
                .color("Blue")
                .engine("4-Cylinder")
                .year(2023)
                .withGPS(false)
                .withSunroof(false)
                .build();
    }
}

