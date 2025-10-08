# Lab 1 - SOLID Principles
### Author - **Alexei Pavlovschii**  
A small Java console application demonstrating **three SOLID principles**:  
**S**ingle Responsibility, **O**pen/Closed, and **D**ependency Inversion.

---

## Project Goal
To illustrate how SOLID design improves maintainability, readability, and scalability in even a small system.

---

## Project Overview
This project simulates a simple checkout process.  
You can:
- Create an order with products  
- Process payment using different methods  
- Save and print invoices  

---

## Folder Structure
```
lab1/
├── Main.java
├── domain/
│   ├── Product.java
│   └── Order.java
├── payment/
│   ├── PaymentMethod.java
│   ├── CardPayment.java
│   └── PaypalPayment.java
├── repo/
│   ├── OrderRepository.java
│   └── InMemoryOrderRepository.java
├── service/
│   ├── InvoiceService.java
│   └── OrderService.java
└── README.md
```

---

## How to Run
1. Compile all Java files:
   ```bash
   javac -d out $(find src -name "*.java")
   ```
2. Run the program:
   ```bash
   java -cp out Main
   ```
3. You should see output similar to:
   ```
   [Card] Charging 204.5 using 4111-****
   [Repo] Saved order with 2 items.
   Invoice: total = 204.5
   [OrderService] Checkout complete.
   ```

---

## Demonstrated SOLID Principles

### **S — Single Responsibility**
Each class has only one reason to change:
- `InvoiceService` → builds invoice text only  
- `OrderService` → coordinates checkout  
- `InMemoryOrderRepository` → handles data persistence  

### **O — Open/Closed**
The system is **open for extension** (add new payment types) but **closed for modification**:
- Add `CryptoPayment`, `BankTransfer`, etc. by implementing `PaymentMethod`
- No need to modify `OrderService`

### **D — Dependency Inversion**
`OrderService` depends on **abstractions**, not implementations:
- Works with any `PaymentMethod` and any `OrderRepository`
- These are injected via constructor, improving flexibility and testability

---

## Example Extension
To add a new payment type:

```java
public class CryptoPayment implements PaymentMethod {
    public boolean charge(double amount) {
        System.out.println("[Crypto] Paid " + amount + " in BTC");
        return true;
    }
}
```
Then in `Main.java`:
```java
PaymentMethod payment = new CryptoPayment();
```

---

## Key Benefits
✅ Easier testing (mock repositories or payments)  
✅ Faster feature addition  
✅ Clear separation of concerns  
✅ Reduced risk of bugs when modifying components  

---