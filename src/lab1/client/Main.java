package lab1.client;

import lab1.domain.builder.CarBuilder;
import lab1.domain.builder.CarDirector;
import lab1.domain.factory.EconomyCarFactory;
import lab1.domain.factory.LuxuryCarFactory;
import lab1.domain.factory.VehicleFactory;
import lab1.domain.models.Car;
import lab1.domain.models.Vehicle;
import lab1.domain.singleton.VehicleRegistry;

/**
 * Client code demonstrating the three creational design patterns:
 * 1. Singleton - VehicleRegistry (single instance)
 * 2. Factory Method - VehicleFactory with LuxuryCarFactory and EconomyCarFactory
 * 3. Builder with Director - CarBuilder and CarDirector
 */
public class Main {
    void main() {
        System.out.println("=== Creational Design Patterns Demo ===\n");

        // SINGLETON PATTERN - Get the single registry instance
        System.out.println("1. SINGLETON PATTERN - VehicleRegistry");
        VehicleRegistry registry = VehicleRegistry.getInstance();
        VehicleRegistry sameRegistry = VehicleRegistry.getInstance();
        System.out.println("   Both references point to same instance: " + (registry == sameRegistry));
        System.out.println();

        // FACTORY METHOD PATTERN - Two concrete factories
        System.out.println("2. FACTORY METHOD PATTERN - Vehicle Factories");

        // Using Luxury Car Factory
        VehicleFactory luxuryFactory = new LuxuryCarFactory();
        Vehicle luxuryCar = luxuryFactory.createVehicle();
        registry.register(luxuryCar);

        // Using Economy Car Factory
        VehicleFactory economyFactory = new EconomyCarFactory();
        Vehicle economyCar = economyFactory.createVehicle();
        registry.register(economyCar);
        System.out.println();

        // BUILDER PATTERN WITH DIRECTOR
        System.out.println("3. BUILDER WITH DIRECTOR PATTERN");

        // Create builder and director
        CarBuilder builder = new CarBuilder();
        CarDirector director = new CarDirector(builder);

        // Director constructs different car types
        System.out.println("   Director constructing Sports Car:");
        Car sportsCar = director.constructSportsCar();
        registry.register(sportsCar);

        System.out.println("   Director constructing Family Sedan:");
        Car familySedan = director.constructFamilySedan();
        registry.register(familySedan);

        System.out.println("   Director constructing Economy Car:");
        Car basicCar = director.constructEconomyCar();
        registry.register(basicCar);

        // Builder can also be used directly without director
        System.out.println("   Builder used directly (custom configuration):");
        Car customCar = builder
                .brand("BMW")
                .model("M3")
                .color("Blue")
                .engine("Inline-6 Turbo")
                .year(2024)
                .withGPS(true)
                .withSunroof(true)
                .build();
        registry.register(customCar);
        System.out.println();

        // Display all registered vehicles
        registry.printAll();
    }
}
