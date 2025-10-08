package lab1.service;

import lab1.domain.Order;
import lab1.payment.PaymentMethod;
import lab1.repo.OrderRepository;

// SRP: orchestrates checkout only (not formatting invoice, not persistence logic itself)
// DIP: depends on abstractions PaymentMethod & OrderRepository
public class OrderService {
    private final OrderRepository repository;
    private final PaymentMethod paymentMethod;
    private final InvoiceService invoiceService;

    public OrderService(OrderRepository repository, PaymentMethod paymentMethod, InvoiceService invoiceService) {
        this.repository = repository;
        this.paymentMethod = paymentMethod;
        this.invoiceService = invoiceService;
    }

    public void checkout(Order order) {
        if (paymentMethod.charge(order.total())) {
            repository.save(order);
            System.out.println(invoiceService.buildInvoice(order));
            System.out.println("[OrderService] Checkout complete.");
        } else {
            System.out.println("[OrderService] Payment failed.");
        }
    }
}