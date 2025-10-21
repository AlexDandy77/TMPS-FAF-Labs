# Lab 1 – Creational Design Patterns
### Student: Alexei Pavlovschii  
**Topic:** Creational Design Patterns in Java  
**Deadline:** 31/10/2025

---

## Objectives
1. Study and understand Creational Design Patterns.
2. Define main domain classes and appropriate instantiation mechanisms.
3. Implement at least 3 creational design patterns in a sample project.

---

## Project Domain: Vehicle Manufacturing System
This simulation models a small factory that builds and registers vehicles using multiple object-creation strategies.

### Classes & Responsibilities
- `Vehicle` – base interface
- `Car`, `Bike`, `Truck` – specific vehicle types
- `CarBuilder` – constructs complex Car objects
- `VehicleFactory` – decides which vehicle to create
- `VehicleRegistry` – maintains a single list of all built vehicles (Singleton)

---

## Patterns Implemented
| Pattern | Description | Example Class |
|----------|--------------|----------------|
| **Singleton** | Ensures a single instance of a class | `VehicleRegistry` |
| **Factory Method** | Creates vehicles based on type | `VehicleFactory` |
| **Builder** | Builds complex objects step-by-step | `CarBuilder` |

---

## ⚙️ How to Run
```bash
javac -d out $(find src -name "*.java")
java -cp out client.Main
```

---