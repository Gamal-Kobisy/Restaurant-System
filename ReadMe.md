# Restaurant Ordering & Billing System — README

---

## Project Structure

```
src/
  menu/
    Menu.java
    MenuItem.java
  factories/
    MenuFactory.java
    VeganMenuFactory.java
    NonVegMenuFactory.java
  decorator/
    AddOnDecorator.java
    ExtraCheese.java
    ExtraSauce.java
  order/
    Order.java
    OrderItem.java
  discount/
    DiscountStrategy.java
    NoDiscount.java
    ChickenDiscount.java
  observers/
    OrderObserver.java
    Kitchen.java
    Waiter.java
    OrderNotifier.java
  RestaurantSystem.java   // facade / main integration class (optional)
  Main.java               // optional test harness
plantuml/diagram.puml
README.md
```

---

## How to Compile & Run

Assuming JDK 11+ and all source files are in `src/`:

```bash
# Compile all Java files
javac -d out $(find src -name "*.java")

# Run main test harness (replace package if needed)
java -cp out Main
```

Or if using an IDE like IntelliJ IDEA, import the project and run `Main.java`.

---

## Example Test Cases

### Test Case 1 — Single item, no add-ons, no discount

* Item: Vegan Salad — price: 80.0
* Qty: 1
* Discount: NoDiscount

**Expected output:**

```
1. Vegan Salad – Mixed greens, avocado, nuts, and citrus dressing. – Qty: 1 – $80.00
Total: $80.00
Total (no discount): 80.0
```

### Test Case 2 — Single item with decorators, no discount

* Item: Vegan Burger (95.0)
* Decorators: ExtraCheese (+2.0), ExtraSauce (+1.0) → decorated price: 98.0
* Qty: 2
* Discount: NoDiscount

**Expected calculations:**

* Line subtotal = 98.0 * 2 = 196.0
* Total after discount = 196.0

**Expected output excerpt:**

```
1. Vegan Burger+ Extra Cheese+ Extra Sauce – Plant-based patty with lettuce, tomato, and vegan mayo. – Qty: 2 – $196.00
Total: $196.00
Total (no discount): 196.0
```

### Test Case 3 — Multiple items, apply discount

* Items: Grilled Chicken (120.0) x1, Vegan Salad (80.0) x1
* Discount: ChickenDiscount (15%)

**Expected calculations:**

* subtotal = 120 + 80 = 200
* discount = 200 * 0.15 = 30
* total after discount = 170

**Expected output:**

```
Total (chicken discount): 170.0
```

---

## Discount Scenarios

* **NoDiscount** — no change to total price.
* **ChickenDiscount** — applies 15% discount to total order.

    * Implementation: `applyDiscount(total) => total * 0.15` (returns discount amount to subtract).
    * Ensure `Order.calculateTotal` subtracts this value to compute final total.

> Note: If implementing item-specific discounts in future (e.g., only chicken items), update `DiscountStrategy.applyDiscount` to accept `Order` as parameter instead of total amount.

---

## Observers

* Kitchen and Waiter are automatically notified when a new order is created.
* Notifications show order details and totals.

---


```bash
docker run --rm -v $(pwd):/workspace plantuml/plantuml -tpng plantuml/diagram.puml
```

---

## Running the Project Summary

1. Compile all source code.
2. Run the main class (`Main.java`) to test ordering system.
3. Verify observers print notifications.
4. Check totals with `NoDiscount` and `ChickenDiscount`.
5. Add or remove decorators and re-run to see price changes.

---

End of README
