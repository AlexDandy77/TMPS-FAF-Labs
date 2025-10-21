package lab0.domain;

import java.util.List;

public class Order {
    private final List<Product> items;

    public Order(List<Product> items) { this.items = items; }

    public List<Product> items() { return items; }

    public double total() {
        return items.stream().mapToDouble(Product::price).sum();
    }
}