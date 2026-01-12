# State Pattern

## 🔍 Definition

**State** is a behavioral design pattern that lets an object alter its behavior when its internal state changes. It appears as if the object changed its class.

## 🧩 The Problem

You are coding a Vending Machine.
`processRequest()` is a monster switch statement:

```java
if (state == "NO_MONEY") { prompt(); }
else if (state == "HAS_MONEY") { dispense(); }
else if (state == "OUT_OF_STOCK") { refund(); }
```

Adding a new state (e.g., "Under Maintenance") requires editing all methods and risking bugs.

## 💡 The Solution

Create a class for each state (`NoMoneyState`, `HasMoneyState`).
The Context (`VendingMachine`) holds a reference to the `CurrentState` object.
The Context delegates the work: `currentState.insertCoin()`.
Transitions happen by swapping the state object: `this.state = new HasMoneyState()`.

## 🏗️ Real-World Analogy

**Your Smartphone**:

1.  **Unlocked State**: Touching screen -> Opens app.
2.  **Locked State**: Touching screen -> Shows notification shade.
3.  **Low Battery State**: Touching screen -> Shows "Recharge" warning.
    The phone is the same, but its behavior changes depending on its "State".

## 💻 Code Snippet

```java
public interface State {
    void pressButton(Phone phone);
}

public class LockedState implements State {
    public void pressButton(Phone phone) {
        System.out.println("Unlocking...");
        phone.setState(new UnlockedState());
    }
}

public class Phone {
    private State state; // Current state
    public void pressButton() {
        state.pressButton(this);
    }
}
```

## ✅ Applicability

- Use the State pattern when you have an object that behaves differently depending on its current state, the number of states is enormous, and the state-specific code changes frequently.
- Use the pattern when you have a class polluted with massive conditionals (switching on state).

## ⚖️ Pros and Cons

| Pros                                                                                                   | Cons                                                                                             |
| :----------------------------------------------------------------------------------------------------- | :----------------------------------------------------------------------------------------------- |
| Single Responsibility Principle. Organize the code related to particular states into separate classes. | Applying the pattern can be overkill if a state machine has only a few states or rarely changes. |
| Open/Closed Principle. Introduce new states without changing existing state classes or the context.    |                                                                                                  |
| Simplify the code of the context by eliminating bulky state machine conditionals.                      |                                                                                                  |
