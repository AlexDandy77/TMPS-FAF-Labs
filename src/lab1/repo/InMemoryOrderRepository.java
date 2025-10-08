package lab1.repo;

import lab1.domain.Order;
import java.util.ArrayList;
import java.util.List;

public class InMemoryOrderRepository implements OrderRepository {
    private final List<Order> store = new ArrayList<>();

    @Override
    public void save(Order order) {
        store.add(order);
        System.out.println("[Repo] Saved order with " + order.items().size() + " items.");
    }
}