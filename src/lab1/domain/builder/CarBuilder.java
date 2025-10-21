package lab1.domain.builder;
import lab1.domain.models.Car;

public class CarBuilder {
    private String model;
    private String color;
    private String engine;
    private int year;

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

    public Car build() {
        return new Car(model, color, engine, year);
    }
}
