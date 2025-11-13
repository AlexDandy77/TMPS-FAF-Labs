# Lab 2 – Structural Design Patterns
### Student: Alexei Pavlovschii  
**Topic:** Structural Design Patterns in Java  
**Deadline:** 16/11/2025

---

## Objectives
1. Study and understand Structural Design Patterns
2. Implement at least 3 structural design patterns in a sample project
3. Build upon the previous lab's domain (Vehicle System)
4. Ensure implementations respect SOLID principles

---

## Project Domain: Vehicle Rental System
This lab extends the vehicle manufacturing system from Lab 1 by adding a rental system that demonstrates how structural patterns enable flexible feature composition, system integration, simplified interfaces, and controlled access.

---

## Design Patterns Implemented

### 1. **Decorator Pattern** - RentalVehicleDecorator
Dynamically adds responsibilities and services to rental vehicles without modifying their structure.

**Implementation Details:**
- `RentalVehicle` - Component interface extending `Vehicle` with pricing and features
- `BasicRentalVehicle` - Concrete component wrapping a vehicle with base price
- `RentalVehicleDecorator` - Abstract decorator base class
- `InsuranceDecorator` - Adds insurance coverage (+$15/day)
- `GPSDecorator` - Adds GPS navigation system (+$10/day)
- `ChildSeatDecorator` - Adds child safety seat (+$5/day)

**Why Decorator?**
- Rental services can be added/removed dynamically at runtime
- Avoids class explosion (no need for classes like CarWithGPSAndInsurance)
- Each decorator has single responsibility
- Services can be stacked in any combination
- Follows Open/Closed Principle - new decorators can be added without modifying existing code

**Example Usage:**
```java
RentalVehicle rental = new BasicRentalVehicle(car, 40.0);
rental = new InsuranceDecorator(rental);  // $40 + $15 = $55
rental = new GPSDecorator(rental);         // $55 + $10 = $65
rental = new ChildSeatDecorator(rental);   // $65 + $5  = $70
```

**Class Diagram:**
```
RentalVehicle (interface)
    ├── BasicRentalVehicle (concrete component)
    └── RentalVehicleDecorator (abstract decorator)
            ├── InsuranceDecorator
            ├── GPSDecorator
            └── ChildSeatDecorator
```

---

### 2. **Adapter Pattern** - LegacyVehicleAdapter
Converts the interface of legacy vehicle data systems into our Vehicle interface, enabling integration with third-party systems.

**Implementation Details:**
- `LegacyVehicleData` - Third-party class with incompatible interface (vehicleMake, vehicleType, productionYear, paintColor)
- `LegacyVehicleAdapter` - Adapter implementing `Vehicle` interface
- Translates legacy format to our system's format

**Why Adapter?**
- Integrates third-party vehicle databases without modifying their code
- Our system works with `Vehicle` interface uniformly
- Isolates incompatibility in adapter class
- Enables reuse of existing legacy systems
- Follows Dependency Inversion Principle - depends on abstractions

**Before Adapter:**
```
Legacy Format: Ford Explorer (2023) - Blue
```

**After Adapter:**
```
Our Format: Legacy Vehicle: Ford Explorer (2023), Color: Blue
```

**Key Benefits:**
- No modification to legacy code needed
- Adapter can be swapped without affecting clients
- Multiple adapters can coexist for different legacy systems

---

### 3. **Facade Pattern** - VehicleRentalFacade
Provides a simplified, unified interface to the complex subsystems of vehicle creation, decoration, and registration.

**Implementation Details:**
- Encapsulates `VehicleRegistry`, `CarBuilder`, and `CarDirector`
- Provides high-level methods like `rentBasicEconomyCar()`, `rentFamilyPackage()`, `rentSportsPremiumPackage()`
- Hides complexity of creating vehicles, applying decorators, and registering
- Custom rental method with configurable options

**Why Facade?**
- Reduces complexity for clients - one simple call vs multiple steps
- Provides default configurations for common use cases
- Loose coupling - clients don't depend on subsystem classes
- Makes the system easier to use and understand
- Follows Interface Segregation Principle

**Without Facade (complex):**
```java
Car car = carDirector.constructFamilySedan();
registry.register(car);
RentalVehicle rental = new BasicRentalVehicle(car, 50.0);
rental = new InsuranceDecorator(rental);
rental = new GPSDecorator(rental);
rental = new ChildSeatDecorator(rental);
```

**With Facade (simple):**
```java
RentalVehicle rental = facade.rentFamilyPackage();
```

---

### 4. **Proxy Pattern** - VehicleInspectionProxy
Controls access to expensive vehicle inspection operations with caching, lazy initialization, and access control.

**Implementation Details:**
- `VehicleInspection` - Interface for inspection operations
- `RealVehicleInspection` - Real subject performing expensive operations (simulates 500ms delay)
- `VehicleInspectionProxy` - Proxy with caching and lazy initialization
- Cache validity: 5 seconds
- `invalidateCache()` method for cache management

**Why Proxy?**
- Expensive operations (database queries, external APIs) cached to improve performance
- Real inspection object created only when needed (lazy initialization)
- Controls access and adds logic without modifying real subject
- Transparent to clients - same interface as real object
- Follows Single Responsibility Principle

**Benefits Demonstrated:**
1. **Lazy Initialization** - RealVehicleInspection created only on first use
2. **Caching** - Results cached for 5 seconds to avoid repeated expensive calls
3. **Access Control** - Proxy can add authentication/authorization (not shown but possible)
4. **Logging** - Proxy logs operations for monitoring

**Performance Impact:**
- First call: ~500ms (performs real inspection)
- Subsequent calls within 5s: ~0ms (returns cached result)

---

## Class Structure

```
lab2/
├── client/
│   └── Main.java                          // Demonstrates all 4 patterns
├── domain/
│   ├── adapter/
│   │   ├── LegacyVehicleData.java         // Third-party incompatible class
│   │   └── LegacyVehicleAdapter.java      // Adapter to Vehicle interface
│   ├── decorator/
│   │   ├── RentalVehicleDecorator.java    // Abstract decorator base
│   │   ├── InsuranceDecorator.java        // Concrete decorator
│   │   ├── GPSDecorator.java              // Concrete decorator
│   │   └── ChildSeatDecorator.java        // Concrete decorator
│   ├── facade/
│   │   └── VehicleRentalFacade.java       // Simplified interface
│   ├── models/
│   │   ├── RentalVehicle.java             // Component interface
│   │   └── BasicRentalVehicle.java        // Concrete component
│   └── proxy/
│       ├── VehicleInspection.java         // Subject interface
│       ├── RealVehicleInspection.java     // Real subject
│       └── VehicleInspectionProxy.java    // Proxy with caching
```

---

## How to Run

### Compile
```bash
javac -d out $(find src/lab1 src/lab2 -name "*.java")
```

### Run
```bash
java -cp out lab2.client.Main
```

---

## Expected Output

```
=== Structural Design Patterns Demo ===

1. DECORATOR PATTERN - Adding Features Dynamically
   Creating a base rental vehicle and adding services...

   Base: Basic rental
   Price: $40.0/day

   Added Insurance: Basic rental + Full Insurance Coverage
   Price: $55.0/day

   Added GPS: Basic rental + Full Insurance Coverage + GPS Navigation System
   Price: $65.0/day

   Final Package: Basic rental + Full Insurance Coverage + GPS Navigation System + Child Safety Seat
   Final Price: $70.0/day
   Vehicle: Car: Toyota Camry (2024), Silver, engine: 2.5L 4-cylinder


2. ADAPTER PATTERN - Integrating Legacy Systems
   Adapting third-party vehicle data to our system...

   Legacy format: Ford Explorer (2023) - Blue
   Adapted format: Legacy Vehicle: Ford Explorer (2023), Color: Blue
   Adapted format: Legacy Vehicle: Honda Accord (2024), Color: White

   Created rental from legacy data:
   Basic rental + Full Insurance Coverage
   Price: $60.0/day


3. FACADE PATTERN - Simplified Rental Interface
   Using facade to simplify complex rental operations...

   Renting basic economy car (one simple call):
   Features: Basic rental
   Price: $30.0/day
   Vehicle: Car: Honda Civic (2023), Blue, engine: 4-Cylinder

   Renting family package (everything configured automatically):
   Features: Basic rental + Full Insurance Coverage + GPS Navigation System + Child Safety Seat
   Price: $80.0/day
   Vehicle: Car: Toyota Camry (2024), Silver, engine: 4-Cylinder, GPS, Sunroof

   Renting sports premium package:
   Features: Basic rental + Full Insurance Coverage + GPS Navigation System
   Price: $125.0/day
   Vehicle: Car: Porsche 911 (2024), Red, engine: Twin-Turbo Flat-6, GPS


4. PROXY PATTERN - Controlling Access to Expensive Operations
   Using proxy for caching and lazy initialization...

   First detailed inspection:
   [Proxy] Creating real inspection object (lazy initialization)
   [RealInspection] Performing detailed inspection (expensive operation)...
   Detailed Inspection Report for: Car: Tesla Model 3 (2024), Red, engine: Electric
   - Engine: OK
   - Brakes: OK
   - Tires: OK
   - Electronics: OK

   Second detailed inspection (should be cached):
   [Proxy] Returning cached inspection result
   Detailed Inspection Report for: Car: Tesla Model 3 (2024), Red, engine: Electric
   - Engine: OK
   - Brakes: OK
   - Tires: OK
   - Electronics: OK
   (Cached result)

   Quick check:
   [RealInspection] Performing quick check...
   Quick Check: Car: Tesla Model 3 (2024), Red, engine: Electric - Basic Status: OK

   [Proxy] Cache invalidated
   Detailed inspection after cache invalidation:
   [RealInspection] Performing detailed inspection (expensive operation)...
   Detailed Inspection Report for: Car: Tesla Model 3 (2024), Red, engine: Electric
   - Engine: OK
   - Brakes: OK
   - Tires: OK
   - Electronics: OK

=== Demo Complete ===
```

---

## Design Benefits

1. **Flexibility**: Services can be added/removed dynamically (Decorator)
2. **Integration**: Legacy systems integrated seamlessly (Adapter)
3. **Simplicity**: Complex operations simplified for clients (Facade)
4. **Performance**: Expensive operations cached intelligently (Proxy)
5. **Maintainability**: Each pattern has clear, focused responsibility
6. **Extensibility**: New features can be added without modifying existing code
7. **Reusability**: Patterns promote code reuse and composition

---

## Pattern Interactions

The four structural patterns work together to create a robust rental system:

1. **Decorator** - Enables flexible feature composition for rentals
2. **Adapter** - Integrates external vehicle data sources  
3. **Facade** - Provides simple interface that uses Decorator internally
4. **Proxy** - Optimizes performance of inspection operations

Together with Lab 1's creational patterns:
- **Factories & Builders** create vehicles
- **Singleton Registry** stores all vehicles
- **Decorators** add rental features
- **Adapters** integrate legacy data
- **Facade** simplifies the entire process
- **Proxy** optimizes expensive operations

This demonstrates how creational and structural patterns complement each other in a real-world system.

---

## Key Takeaways

### Decorator Pattern
✓ Prefer composition over inheritance  
✓ Add responsibilities dynamically  
✓ Avoid class explosion with feature combinations  

### Adapter Pattern
✓ Make incompatible interfaces work together  
✓ Integrate third-party/legacy systems  
✓ Don't modify code you don't own  

### Facade Pattern
✓ Simplify complex subsystem interactions  
✓ Provide default configurations  
✓ Reduce client coupling to subsystems  

### Proxy Pattern
✓ Control access to expensive resources  
✓ Add caching, lazy initialization, logging  
✓ Transparent to clients - same interface  
