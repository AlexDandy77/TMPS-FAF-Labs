# Lab 1 – Creational Design Patterns
### Student: Alexei Pavlovschii  
**Topic:** Creational Design Patterns in Java  
**Deadline:** 31/10/2025

---

## Objectives
1. Study and understand Creational Design Patterns
2. Define main domain classes and appropriate instantiation mechanisms
3. Implement at least 3 creational design patterns in a sample project
4. Ensure implementations respect SOLID principles

---

## Project Domain: Vehicle Manufacturing System
This simulation models a vehicle manufacturing and registration system using three creational design patterns.

---

## Design Patterns Implemented

### 1. **Singleton Pattern** - VehicleRegistry
Ensures only one instance of the vehicle registry exists throughout the application.

**Implementation Details:**
- Thread-safe using double-checked locking with `volatile`
- Private constructor prevents direct instantiation
- Lazy initialization - instance created only when first needed
- Provides global access point via `getInstance()`

**Why Singleton?**
- Only one central registry should exist to maintain all vehicles
- Global access ensures all parts of the application use the same registry

---

### 2. **Factory Method Pattern** - VehicleFactory
Defines an interface for creating vehicles, but lets subclasses decide which vehicle to instantiate.

**Implementation Details:**
- `VehicleFactory` - Abstract creator with factory method `createVehicle()`
- `LuxuryCarFactory` - Concrete creator producing luxury cars
- `EconomyCarFactory` - Concrete creator producing economy cars

**Why Factory Method?**
- Delegates object creation to subclasses
- Client code works with abstract factory interface
- Easy to add new vehicle types without modifying existing code
- Follows Open/Closed Principle

**Class Diagram:**
```
VehicleFactory (abstract)
    ├── LuxuryCarFactory (creates luxury cars)
    └── EconomyCarFactory (creates economy cars)
```

---

### 3. **Builder Pattern with Director** - CarBuilder & CarDirector
Separates the construction of complex Car objects from their representation.

**Implementation Details:**
- `CarBuilder` - Provides fluent interface to build cars step-by-step
- `CarDirector` - Encapsulates common construction sequences
- Supports properties: brand, model, color, engine, year, GPS, sunroof

**Why Builder with Director?**
- Car has many optional properties (GPS, sunroof, etc.)
- Director encapsulates common configurations (sports car, family sedan, economy)
- Builder can still be used directly for custom configurations
- Improves code readability with fluent API

**Example Usage:**
```java
// Using Director for predefined configurations
CarBuilder builder = new CarBuilder();
CarDirector director = new CarDirector(builder);
Car sportsCar = director.constructSportsCar();

// Or use Builder directly for custom build
Car customCar = builder
    .brand("BMW")
    .model("M3")
    .engine("Inline-6 Turbo")
    .withGPS(true)
    .build();
```

---

## Class Structure

```
lab1/
├── client/
│   └── Main.java                    // Demonstrates all patterns
├── domain/
│   ├── builder/
│   │   ├── CarBuilder.java          // Builder pattern
│   │   └── CarDirector.java         // Director for builder
│   ├── factory/
│   │   ├── VehicleFactory.java      // Abstract creator
│   │   ├── LuxuryCarFactory.java    // Concrete creator 1
│   │   └── EconomyCarFactory.java   // Concrete creator 2
│   ├── models/
│   │   ├── Vehicle.java             // Product interface
│   │   └── Car.java                 // Concrete product
│   └── singleton/
│       └── VehicleRegistry.java     // Singleton registry
```

---

## SOLID Principles Compliance

### ✓ Single Responsibility Principle (SRP)
- **VehicleRegistry**: Only manages vehicle storage and retrieval
- **VehicleFactory**: Only responsible for vehicle creation
- **CarBuilder**: Only handles car construction logic
- **CarDirector**: Only encapsulates construction recipes
- **Vehicle/Car**: Only represent vehicle data

### ✓ Open/Closed Principle (OCP)
- New factory types can extend `VehicleFactory` without modifying existing code
- New vehicle types can implement `Vehicle` interface
- Director can add new construction methods without changing builder

### ✓ Liskov Substitution Principle (LSP)
- Any `VehicleFactory` subclass can replace the parent class
- `LuxuryCarFactory` and `EconomyCarFactory` are fully interchangeable
- All factories return `Vehicle` interface, maintaining contracts

### ✓ Interface Segregation Principle (ISP)
- `Vehicle` interface is minimal (only `getDescription()`)
- No client is forced to depend on methods it doesn't use
- Builder methods are optional, use only what's needed

### ✓ Dependency Inversion Principle (DIP)
- `Main` depends on `VehicleFactory` abstraction, not concrete factories
- Works with `Vehicle` interface, not concrete implementations
- High-level modules don't depend on low-level modules

---

## How to Run

### Compile
```bash
javac -d out $(find src/lab1 -name "*.java")
```

### Run
```bash
java -cp out lab1.client.Main
```

---

## Expected Output

```
=== Creational Design Patterns Demo ===

1. SINGLETON PATTERN - VehicleRegistry
   Both references point to same instance: true

2. FACTORY METHOD PATTERN - Vehicle Factories
[Registry] Registered: Car: Mercedes-Benz S-Class (2024), Black, engine: V8 Twin-Turbo, GPS, Sunroof
[Registry] Registered: Car: Dacia Logan (2023), White, engine: 1.0L 3-Cylinder

3. BUILDER WITH DIRECTOR PATTERN
   Director constructing Sports Car:
[Registry] Registered: Car: Porsche 911 (2024), Red, engine: Twin-Turbo Flat-6, GPS
   Director constructing Family Sedan:
[Registry] Registered: Car: Toyota Camry (2024), Silver, engine: 4-Cylinder, GPS, Sunroof
   Director constructing Economy Car:
[Registry] Registered: Car: Honda Civic (2023), Blue, engine: 4-Cylinder
   Builder used directly (custom configuration):
[Registry] Registered: Car: BMW M3 (2024), Blue, engine: Inline-6 Turbo, GPS, Sunroof

========== Vehicle Registry ==========
Total vehicles: 6
--------------------------------------
1. Car: Mercedes-Benz S-Class (2024), Black, engine: V8 Twin-Turbo, GPS, Sunroof
2. Car: Dacia Logan (2023), White, engine: 1.0L 3-Cylinder
3. Car: Porsche 911 (2024), Red, engine: Twin-Turbo Flat-6, GPS
4. Car: Toyota Camry (2024), Silver, engine: 4-Cylinder, GPS, Sunroof
5. Car: Honda Civic (2023), Blue, engine: 4-Cylinder
6. Car: BMW M3 (2024), Blue, engine: Inline-6 Turbo, GPS, Sunroof
======================================

=== SOLID Principles Compliance ===
...
```

---

## Design Benefits

1. **Flexibility**: Easy to add new vehicle types or factories
2. **Maintainability**: Each pattern has clear responsibility
3. **Testability**: Patterns can be tested independently
4. **Reusability**: Director encapsulates reusable construction recipes
5. **Thread Safety**: Singleton ensures safe concurrent access
6. **Extensibility**: New features can be added without breaking existing code

---

## Pattern Interactions

The three patterns work together cohesively:
1. **Factories** create vehicles using different strategies
2. **Builder/Director** constructs complex cars with many options
3. **Singleton Registry** maintains all created vehicles in one place

This demonstrates how multiple design patterns can complement each other in a real system.

