# 📚 Strategy Pattern - Complete LLD Guide

> **Exactly** how LLD should be learned — slowly, brutally clear, no magic ✨

## 📋 What You'll Learn

1. **Problem without Strategy Pattern** (why it breaks)
2. **Fix using Strategy Pattern**
3. Line-by-line explanation
4. Constructor Injection (what, why, how)
5. Key design principles involved
6. Mental models + interview cues

---

## 🚗 Problem Statement (Common in LLD)

We want to model different types of **Vehicles**:

- Normal Car
- Sports Car
- Offroad Car

Each vehicle has **drive behavior**, which may differ.

---

# ❌ WITHOUT STRATEGY PATTERN (Inheritance-based approach)

## Approach 1: Put everything in base class

```java
class Vehicle {
    public void drive() {
        System.out.println("Normal driving");
    }
}
```

Now extend:

```java
class SportsCar extends Vehicle {
    @Override
    public void drive() {
        System.out.println("Sports driving");
    }
}

class OffroadCar extends Vehicle {
    @Override
    public void drive() {
        System.out.println("Offroad driving");
    }
}
```

---

## 🚨 Problems with this approach

### ❌ Problem 1: Code duplication

If multiple vehicles share same driving logic:

```java
SportsCar → sports drive
SuperCar → sports drive
```

Same logic repeated → violation of **DRY**.

---

### ❌ Problem 2: Rigid hierarchy

What if tomorrow:

- ElectricCar
- HybridCar

Now behavior combinations explode.

Inheritance **locks behavior at compile-time**.

---

### ❌ Problem 3: OCP violation (Open/Closed Principle)

If tomorrow:

> “SportsCar can have normal driving mode also”

You must:

- Modify existing classes
- Add conditionals

Bad design smell 🚨

---

### ❌ Problem 4: `if-else` hell

People try this:

```java
class Vehicle {
    void drive(String type) {
        if(type.equals("SPORTS")) {
            System.out.println("Sports drive");
        } else if(type.equals("NORMAL")) {
            System.out.println("Normal drive");
        }
    }
}
```

🔥 This is the **worst** version:

- Tight coupling
- Impossible to extend safely
- Interviewers hate this

---

# ✅ WITH STRATEGY PATTERN (Correct LLD)

## 🎯 Core idea

> Separate **what changes** (drive behavior) from **what stays same** (vehicle)

---

## Step 1️⃣ Create Strategy Interface

```java
public interface DriveStrategy {
    void drive();
}
```

### Why interface?

- Defines **contract**
- Allows multiple interchangeable implementations
- Enables polymorphism

🧠 **No object is created here**

---

## Step 2️⃣ Concrete Strategy Implementations

```java
public class NormalDriveStrategy implements DriveStrategy {
    public void drive() {
        System.out.println("Normal driving");
    }
}
```

```java
public class SportsDriveStrategy implements DriveStrategy {
    public void drive() {
        System.out.println("Sports driving");
    }
}
```

### Key points

- Each class has **single responsibility**
- Behavior is reusable
- No duplication

---

## Step 3️⃣ Context Class (Vehicle)

```java
public class Vehicle {

    DriveStrategy driveStrategy;
```

### 🔍 Explanation

- `DriveStrategy` is an **interface reference**
- This is **composition**
- Vehicle _has-a_ DriveStrategy

---

## Step 4️⃣ Constructor Injection (IMPORTANT 🔥)

```java
    Vehicle(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }
```

### What is Constructor Injection?

> Passing dependencies through the constructor

### Why constructor injection?

- Dependency is **mandatory**
- Object is always in valid state
- Easy to test
- Promotes immutability

❌ Avoid:

```java
Vehicle v = new Vehicle();
v.driveStrategy = new SportsDriveStrategy(); // bad practice
```

---

## Step 5️⃣ Delegation

```java
    public void drive() {
        driveStrategy.drive();
    }
}
```

### What is happening?

- Vehicle does NOT implement driving logic
- It **delegates** responsibility
- This is **Strategy Pattern in action**

---

## Step 6️⃣ Concrete Vehicles

```java
public class SportsCar extends Vehicle {
    SportsCar() {
        super(new SportsDriveStrategy());
    }
}
```

```java
public class NormalCar extends Vehicle {
    NormalCar() {
        super(new NormalDriveStrategy());
    }
}
```

### Key Insight

- Vehicle type decides strategy
- Strategy can be swapped easily

---

## Step 7️⃣ Usage

```java
public class Main {
    public static void main(String[] args) {
        Vehicle v = new SportsCar();
        v.drive();
    }
}
```

### Output

```
Sports driving
```

---

# 🧠 WHY THIS DESIGN IS SUPERIOR

## ✔ Open/Closed Principle

Add new behavior:

```java
class SnowDriveStrategy implements DriveStrategy { }
```

No existing code changes.

---

## ✔ Composition over Inheritance

Behavior is **composed**, not inherited.

---

## ✔ Runtime flexibility

You can even change strategy at runtime:

```java
vehicle.driveStrategy = new NormalDriveStrategy();
```

---

## ✔ Unit Testing becomes trivial

```java
Vehicle v = new Vehicle(new FakeDriveStrategy());
```

---

# 🧪 Comparison Table

| Aspect      | Without Strategy | With Strategy |
| ----------- | ---------------- | ------------- |
| Flexibility | ❌ Low           | ✅ High       |
| Code reuse  | ❌ Poor          | ✅ Excellent  |
| OCP         | ❌ Violated      | ✅ Followed   |
| Testing     | ❌ Hard          | ✅ Easy       |
| Readability | ❌ Messy         | ✅ Clean      |

---

# 🎤 Interview-ready Explanation (Use this)

> “Strategy Pattern encapsulates varying behavior into separate classes and injects them using composition. This avoids inheritance explosion, follows Open/Closed Principle, and allows behavior to change at runtime.”

---

# 🔥 Common Mistakes (Watch Out)

❌ Creating strategy inside class

```java
this.driveStrategy = new SportsDriveStrategy(); // tight coupling
```

❌ Using enums + switch

```java
switch(type) { }
```

---

# 🧠 Final Mental Model

- **Interface** → What can be done
- **Strategy** → How it is done
- **Context (Vehicle)** → Who uses it
- **Constructor Injection** → How dependency is supplied

---
