package lab1.domain.models;

public class Car implements Vehicle{
    private String model;
    private String color;
    private String engine;
    private int year;

    public Car(String model, String color, String engine, int year) {
        this.model = model;
        this.color = color;
        this.engine = engine;
        this.year = year;
    }

    @Override
    public String getDescription() {
        return "Car: " + model + ", " + color + ", engine " + engine + ", year " + year;
    }
}
