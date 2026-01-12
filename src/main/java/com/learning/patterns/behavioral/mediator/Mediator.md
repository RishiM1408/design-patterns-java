# Mediator Pattern

## 🔍 Definition

**Mediator** is a behavioral design pattern that lets you reduce chaotic dependencies between objects. The pattern restricts direct communications between the objects and forces them to collaborate only via a mediator object.

## 🧩 The Problem

"Spaghetti Code". You have a Dialog box. It has `LoginButton`, `Checkbox`, `Textbox`.

- If `Checkbox` is checked, `Textbox` is enabled.
- If `Textbox` has text, `LoginButton` is enabled.
  If you put this logic inside `Checkbox`, it now depends on `Textbox`. Components become tightly coupled and reusable only together.

## 💡 The Solution

Create a Central `Mediator` (e.g., `DialogController`).
Components (`Colleagues`) only know about the Mediator. They notify the Mediator when something changes (`click`).
The Mediator handles the business logic: "Oh, Checkbox was clicked? I will enable the Textbox."

## 🏗️ Real-World Analogy

**Air Traffic Control**: Pilots (Colleagues) don't talk to each other ("Hey Flight 123, I'm landing, move over"). They talk to the Tower (Mediator). The Tower tells everyone what to do. This prevents crashes and chaos.

## 💻 Code Snippet

```java
public interface Mediator {
    void notify(Component sender, String event);
}

public class AuthenticationDialog implements Mediator {
    public void notify(Component sender, String event) {
        if (sender == checkbox && event.equals("check")) {
            textbox.setHidden(false);
        } else if (sender == loginBtn && event.equals("click")) {
            validate();
        }
    }
}
```

## ✅ Applicability

- Use the Mediator pattern when it's hard to change some of the classes because they are tightly coupled to a bunch of other classes.
- Use the pattern when you can't reuse a component in a different program because it's too dependent on other components.

## ⚖️ Pros and Cons

| Pros                                                                                                            | Cons                                                                 |
| :-------------------------------------------------------------------------------------------------------------- | :------------------------------------------------------------------- |
| Single Responsibility Principle. You can extract communications between various components into a single place. | The Mediator can evolve into a God Object, growing huge and complex. |
| Open/Closed Principle. You can introduce new mediators without changing the actual components.                  |                                                                      |
| You reduce coupling between various components of a program.                                                    |                                                                      |
