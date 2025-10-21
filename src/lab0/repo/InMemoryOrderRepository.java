package lab0.repo;

import lab0.domain.Order;
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