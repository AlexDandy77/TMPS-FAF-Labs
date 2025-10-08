package lab1.service;

import lab1.domain.Order;

public class InvoiceService {
    // SRP: only builds a printable invoice string
    public String buildInvoice(Order order) {
        return "Invoice: total = " + order.total();
    }
}
