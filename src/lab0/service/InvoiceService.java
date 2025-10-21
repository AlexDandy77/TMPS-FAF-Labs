package lab0.service;

import lab0.domain.Order;

public class InvoiceService {
    // SRP: only builds a printable invoice string
    public String buildInvoice(Order order) {
        return "Invoice: total = " + order.total();
    }
}
