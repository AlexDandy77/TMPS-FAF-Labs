package lab1.domain.builder;

import lab1.domain.models.Car;

/**
 * Builder pattern implementation for Car.
 * Allows step-by-step construction of complex Car objects.
 */
public class CarBuilder {
    private String brand;
    private String model;
    private String color;
    private String engine;
    private int year;
    private boolean hasGPS;
    private boolean hasSunroof;

    public CarBuilder brand(String brand) {
        this.brand = brand;
        return this;
    }

    public CarBuilder model(String model) {
        this.model = model;
        return this;
    }

    public CarBuilder color(String color) {
        this.color = color;
        return this;
    }

    public CarBuilder engine(String engine) {
        this.engine = engine;
        return this;
    }

    public CarBuilder year(int year) {
        this.year = year;
        return this;
    }

    public CarBuilder withGPS(boolean hasGPS) {
        this.hasGPS = hasGPS;
        return this;
    }

    public CarBuilder withSunroof(boolean hasSunroof) {
        this.hasSunroof = hasSunroof;
        return this;
    }

    public Car build() {
        return new Car(brand, model, color, engine, year, hasGPS, hasSunroof);
    }

    public void reset() {
        this.brand = null;
        this.model = null;
        this.color = null;
        this.engine = null;
        this.year = 0;
        this.hasGPS = false;
        this.hasSunroof = false;
    }
}
