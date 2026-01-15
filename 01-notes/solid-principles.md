# SOLID Principles — Detailed Notes (LLD)

SOLID is a set of object-oriented design principles that help build systems which are:

- easy to maintain
- safe to extend
- simple to test
- resilient to change

Important note: SOLID does not mean more classes. It means controlled change.

---

## 1. Single Responsibility Principle (SRP)

**Definition:** A class should have only one reason to change.

What it means:

- One responsibility
- One actor (who requests the change)
- One type of behavior

### Bad example

```java
class Invoice {
    void calculateTotal() {}
    void printInvoice() {}
    void saveToDatabase() {}
}
```

Problems: changes in business logic, printing format, or DB cause this class to change.

### Good design

```java
class InvoiceCalculator {
    void calculateTotal() {}
}

class InvoicePrinter {
    void printInvoice() {}
}

class InvoiceRepository {
    void save() {}
}
```

Benefits: easier debugging, smaller classes, faster tests, fewer merge conflicts.

Interview tip: SRP is about isolating reasons to change, not minimizing class size.

---

## 2. Open / Closed Principle (OCP)

**Definition:** Software entities should be open for extension, but closed for modification.

Meaning: add new behavior without modifying existing, tested code.

### Bad example

```java
double calculateFee(String vehicleType) {
    if(vehicleType.equals("CAR")) return 50;
    if(vehicleType.equals("BIKE")) return 20;
    return 0;
}
```

Problem: adding new vehicle types requires editing this method.

### Good design

```java
interface Vehicle {
    double calculateFee();
}

class Car implements Vehicle {
    public double calculateFee() { return 50; }
}

class Bike implements Vehicle {
    public double calculateFee() { return 20; }
}
```

To add Truck, implement Vehicle — no existing code modification.

Benefits: fewer bugs, plug-and-play features, better scalability.

Interview tip: OCP reduces regression risk.

---

## 3. Liskov Substitution Principle (LSP)

**Definition:** Objects of a superclass should be replaceable with objects of its subclass without breaking behavior.

Meaning: child classes must honor parent promises.

### Bad example

```java
class Bird {
    void fly() {}
}

class Ostrich extends Bird {
    void fly() {
        throw new UnsupportedOperationException();
    }
}
```

Problem: Ostrich breaks the Bird contract by throwing an exception.

### Good design

```java
interface Bird {}

interface FlyingBird extends Bird {
    void fly();
}

class Sparrow implements FlyingBird {
    public void fly() {}
}

class Ostrich implements Bird {}
```

Rule of thumb: if you need exceptions, empty overrides, or unsupported ops, inheritance is probably wrong.

Interview tip: LSP is about behavioral compatibility, not syntax.

---

## 4. Interface Segregation Principle (ISP)

**Definition:** No client should be forced to depend on methods it does not use.

Meaning: prefer small, focused interfaces; avoid fat interfaces.

### Bad example

```java
interface Worker {
    void code();
    void cook();
    void clean();
}

class SoftwareEngineer implements Worker {
    public void cook() {} // meaningless
}
```

### Good design

```java
interface Coder {
    void code();
}

interface Cook {
    void cook();
}

class SoftwareEngineer implements Coder {
    public void code() {}
}
```

Benefits: cleaner APIs, less unused code, fewer breaking changes.

Interview tip: ISP avoids “god interfaces”.

---

## 5. Dependency Inversion Principle (DIP)

**Definition:** High-level modules should not depend on low-level modules. Both should depend on abstractions.

### Bad example

```java
class OrderService {
    private MySQLDatabase db = new MySQLDatabase();
}
```

Problem: tight coupling, hard to test, DB changes require code change.

### Good design

```java
interface Database {
    void save();
}

class MySQLDatabase implements Database {
    public void save() {}
}

class OrderService {
    private Database db;

    OrderService(Database db) {
        this.db = db;
    }
}
```

Benefits: testability, flexibility, loose coupling.

Interview tip: DIP enables dependency injection.

---

## Summary (Printable)

| Principle | Focus          | Core Idea               |
| --------- | -------------- | ----------------------- |
| SRP       | Responsibility | One reason to change    |
| OCP       | Extension      | Add without modifying   |
| LSP       | Substitution   | No behavioral surprises |
| ISP       | Interfaces     | No forced dependencies  |
| DIP       | Dependencies   | Depend on abstractions  |

---

## Practical guidance

- SOLID is not a checklist — apply where change is expected.
- Avoid over-engineering; unnecessary abstraction is worse than no engineering.

## How SOLID appears in interviews

- Parking Lot → SRP, OCP, DIP
- Elevator → LSP, ISP
- Payment Systems → OCP, DIP
- Notification Systems → ISP, DIP
