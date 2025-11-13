package lab1.domain.models;

public class Car implements Vehicle {
    private final String brand;
    private final String model;
    private final String color;
    private final String engine;
    private final int year;
    private final boolean hasGPS;
    private final boolean hasSunroof;

    public Car(String brand, String model, String color, String engine, int year, boolean hasGPS, boolean hasSunroof) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.engine = engine;
        this.year = year;
        this.hasGPS = hasGPS;
        this.hasSunroof = hasSunroof;
    }

    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append("Car: ").append(brand).append(" ").append(model)
          .append(" (").append(year).append("), ")
          .append(color).append(", engine: ").append(engine);
        if (hasGPS) sb.append(", GPS");
        if (hasSunroof) sb.append(", Sunroof");
        return sb.toString();
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getEngine() {
        return engine;
    }

    public int getYear() {
        return year;
    }

    public boolean hasGPS() {
        return hasGPS;
    }

    public boolean hasSunroof() {
        return hasSunroof;
    }
}
