# Command Pattern

## 🔍 Definition

**Command** is a behavioral design pattern that turns a request into a stand-alone object that contains all information about the request. This transformation lets you parameterize methods with different requests, delay or queue a request's execution, and support undoable operations.

## 🧩 The Problem

You have a **Smart Home Remote**. It has buttons. You have **Lights**, **Fans**, **Thermostats**.
If you hardcode `Button1` to `Light.turnOn()`, you can't re-map buttons. If you want a "Macro" button that does 5 things, it gets messy. If you want "Undo", you can't easily track what happened.

## 💡 The Solution

Create `Command` objects (`TurnOnLightCommand`, `SetTempCommand`).
The **Remote** (Invoker) doesn't know about `Light` classes. It just holds a `Command` object and calls `command.execute()`.
The **Command** holds the specific `Light` instance and calls the specific method.

## 🏗️ Real-World Analogy

**Restaurant Order**: You (Client) give an order to the Waiter (Invoker). The Waiter writes it on a Ticket (Command). The Waiter places the Ticket in the queuing rack. The Chef (Receiver) grabs the Ticket and cooks.
The Waiter doesn't invoke `cookBurger()` directly on the Chef; the Ticket decouples them.

## 💻 Code Snippet

```java
// Command Interface
public interface Command {
    void execute();
}

// Receiver
public class Light {
    public void on() { System.out.println("Light ON"); }
}

// Concrete Command
public class LightOnCommand implements Command {
    private Light light;
    public LightOnCommand(Light light) { this.light = light; }
    public void execute() { light.on(); }
}

// Invoker
public class RemoteControl {
    private Command slot;
    public void setCommand(Command command) { this.slot = command; }
    public void pressButton() { slot.execute(); }
}
```

## ✅ Applicability

- Use the Command pattern when you want to parameterize objects with operations.
- Use the Command pattern when you want to queue operations, schedule their execution, or execute them remotely.
- Use the Command pattern when you want to implement reversible operations (Undo/Redo).

## ⚖️ Pros and Cons

| Pros                                                                                                             | Cons                                                                                                           |
| :--------------------------------------------------------------------------------------------------------------- | :------------------------------------------------------------------------------------------------------------- |
| Single Responsibility Principle. You can decouple classes that invoke operations from classes that perform them. | The code may become more complicated since you're introducing a whole new layer between senders and receivers. |
| Open/Closed Principle. You can introduce new commands without breaking existing code.                            |                                                                                                                |
| You can implement undo/redo.                                                                                     |                                                                                                                |
