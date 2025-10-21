package lab0.repo;

import lab0.domain.Order;

public interface OrderRepository {
    void save(Order order);
}