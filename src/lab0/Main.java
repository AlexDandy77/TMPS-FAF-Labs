package lab0;

import lab0.domain.Order;
import lab0.domain.Product;
import lab0.payment.*;
import lab0.repo.*;
import lab0.service.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrderRepository repo = new InMemoryOrderRepository();     // DIP: depends on abstraction
        PaymentMethod payment = new CardPayment("4111-****");     // OCP: swap to new payment without changing OrderService
        InvoiceService invoiceService = new InvoiceService();      // SRP: only formats invoices

        OrderService orderService = new OrderService(repo, payment, invoiceService); // DIP via constructor

        Order order = new Order(List.of(
                new Product("Book", 199.0),
                new Product("Pen", 5.5)
        ));
        orderService.checkout(order);
    }
}