package lab2.client;

import lab1.domain.builder.CarBuilder;
import lab1.domain.models.Car;
import lab2.domain.adapter.LegacyVehicleAdapter;
import lab2.domain.adapter.LegacyVehicleData;
import lab2.domain.decorator.ChildSeatDecorator;
import lab2.domain.decorator.GPSDecorator;
import lab2.domain.decorator.InsuranceDecorator;
import lab2.domain.facade.VehicleRentalFacade;
import lab2.domain.models.BasicRentalVehicle;
import lab2.domain.models.RentalVehicle;
import lab2.domain.proxy.VehicleInspectionProxy;

/**
 * Client code demonstrating the four structural design patterns:
 * 1. Decorator - Dynamically adding features to rental vehicles
 * 2. Adapter - Integrating legacy vehicle data systems
 * 3. Facade - Simplifying the complex rental system interface
 * 4. Proxy - Controlling access to expensive inspection operations
 */
public class Main {
    static void main() {
        System.out.println("=== Structural Design Patterns Demo ===\n");

        // DECORATOR PATTERN DEMO
        demonstrateDecoratorPattern();

        // ADAPTER PATTERN DEMO
        demonstrateAdapterPattern();

        // FACADE PATTERN DEMO
        demonstrateFacadePattern();

        // PROXY PATTERN DEMO
        demonstrateProxyPattern();
    }

    /**
     * DECORATOR PATTERN - Add features/services dynamically to rental vehicles.
     */
    private static void demonstrateDecoratorPattern() {
        System.out.println("1. DECORATOR PATTERN - Adding Features Dynamically");
        System.out.println("   Creating a base rental vehicle and adding services...\n");

        // Create a base vehicle
        CarBuilder builder = new CarBuilder();
        Car car = builder
                .brand("Toyota")
                .model("Camry")
                .color("Silver")
                .engine("2.5L 4-cylinder")
                .year(2024)
                .build();

        // Start with basic rental
        RentalVehicle rental = new BasicRentalVehicle(car, 40.0);
        System.out.println("   Base: " + rental.getFeatures());
        System.out.println("   Price: $" + rental.getPrice() + "/day\n");

        // Add insurance
        rental = new InsuranceDecorator(rental);
        System.out.println("   Added Insurance: " + rental.getFeatures());
        System.out.println("   Price: $" + rental.getPrice() + "/day\n");

        // Add GPS
        rental = new GPSDecorator(rental);
        System.out.println("   Added GPS: " + rental.getFeatures());
        System.out.println("   Price: $" + rental.getPrice() + "/day\n");

        // Add a child seat
        rental = new ChildSeatDecorator(rental);
        System.out.println("   Final Package: " + rental.getFeatures());
        System.out.println("   Final Price: $" + rental.getPrice() + "/day");
        System.out.println("   Vehicle: " + rental.getDescription());
        System.out.println();
    }

    /**
     * ADAPTER PATTERN - Integrate third-party legacy vehicle data systems.
     */
    private static void demonstrateAdapterPattern() {
        System.out.println("\n2. ADAPTER PATTERN - Integrating Legacy Systems");
        System.out.println("   Adapting third-party vehicle data to our system...\n");

        // Legacy system data (incompatible format)
        LegacyVehicleData legacyData1 = new LegacyVehicleData(
                "Ford", "Explorer", 2023, "Blue");
        LegacyVehicleData legacyData2 = new LegacyVehicleData(
                "Honda", "Accord", 2024, "White");

        System.out.println("   Legacy format: " + legacyData1.getLegacyInfo());

        // Adapt to our system
        LegacyVehicleAdapter adapter1 = new LegacyVehicleAdapter(legacyData1);
        LegacyVehicleAdapter adapter2 = new LegacyVehicleAdapter(legacyData2);

        System.out.println("   Adapted format: " + adapter1.getDescription());
        System.out.println("   Adapted format: " + adapter2.getDescription());

        // Can now use adapted vehicles in our rental system
        RentalVehicle rental = new BasicRentalVehicle(adapter1, 45.0);
        rental = new InsuranceDecorator(rental);

        System.out.println("\n   Created rental from legacy data:");
        System.out.println("   " + rental.getFeatures());
        System.out.println("   Price: $" + rental.getPrice() + "/day");
        System.out.println();
    }

    /**
     * FACADE PATTERN - Simplified interface for complex rental operations.
     */
    private static void demonstrateFacadePattern() {
        System.out.println("\n3. FACADE PATTERN - Simplified Rental Interface");
        System.out.println("   Using facade to simplify complex rental operations...\n");

        VehicleRentalFacade rentalFacade = new VehicleRentalFacade();

        // Simple one-line rentals instead of complex multi-step operations
        System.out.println("   Renting basic economy car (one simple call):");
        RentalVehicle economy = rentalFacade.rentBasicEconomyCar();
        System.out.println("   Features: " + economy.getFeatures());
        System.out.println("   Price: $" + economy.getPrice() + "/day");
        System.out.println("   Vehicle: " + economy.getDescription() + "\n");

        System.out.println("   Renting family package (everything configured automatically):");
        RentalVehicle family = rentalFacade.rentFamilyPackage();
        System.out.println("   Features: " + family.getFeatures());
        System.out.println("   Price: $" + family.getPrice() + "/day");
        System.out.println("   Vehicle: " + family.getDescription() + "\n");

        System.out.println("   Renting sports premium package:");
        RentalVehicle sports = rentalFacade.rentSportsPremiumPackage();
        System.out.println("   Features: " + sports.getFeatures());
        System.out.println("   Price: $" + sports.getPrice() + "/day");
        System.out.println("   Vehicle: " + sports.getDescription());
        System.out.println();
    }

    /**
     * PROXY PATTERN - Control access to expensive inspection operations.
     */
    private static void demonstrateProxyPattern() {
        System.out.println("\n4. PROXY PATTERN - Controlling Access to Expensive Operations");
        System.out.println("   Using proxy for caching and lazy initialization...\n");

        // Create a vehicle
        CarBuilder builder = new CarBuilder();
        Car car = builder
                .brand("Tesla")
                .model("Model 3")
                .color("Red")
                .engine("Electric")
                .year(2024)
                .build();

        // Create inspection proxy
        VehicleInspectionProxy inspectionProxy = new VehicleInspectionProxy(car);

        // First detailed inspection (will create real object and perform inspection)
        System.out.println("   First detailed inspection:");
        String report1 = inspectionProxy.performDetailedInspection();
        System.out.println(report1 + "\n");

        // Second detailed inspection (will use cached result)
        System.out.println("   Second detailed inspection (should be cached):");
        String report2 = inspectionProxy.performDetailedInspection();
        System.out.println(report2 + "\n");

        // Quick check (lighter operation)
        System.out.println("   Quick check:");
        String quickCheck = inspectionProxy.performQuickCheck();
        System.out.println(quickCheck + "\n");

        // Invalidate cache and inspect again
        inspectionProxy.invalidateCache();
        System.out.println("   Detailed inspection after cache invalidation:");
        String report3 = inspectionProxy.performDetailedInspection();
        System.out.println(report3);

        System.out.println("\n=== Demo Complete ===");
    }
}

