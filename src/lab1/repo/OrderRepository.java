package lab1.repo;

import lab1.domain.Order;

public interface OrderRepository {
    void save(Order order);
}