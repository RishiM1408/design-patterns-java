# Observer Pattern

## 🔍 Definition

**Observer** is a behavioral design pattern that lets you define a subscription mechanism to notify multiple objects about any events that happen to the object they're observing.

## 🧩 The Problem

You have two objects: `Customer` and `Store`. The customer wants to buy the new iPhone.

1.  **Polling (Bad)**: The Customer goes to the store every day to check availability. Wastes Customer's time.
2.  **Spamming (Bad)**: The Store sends emails to _all_ customers every time a new product arrives. Wastes Store's resources and annoys uninterested clients.

## 💡 The Solution

1.  The Store (`Subject`) maintains a list of interested subscribers (`Observers`).
2.  The Customer (`Observer`) subscribes (`addObserver`).
3.  When the iPhone arrives, the Store iterates through the list and calls `update()` on each subscriber.

## 🏗️ Real-World Analogy

**Newspaper Subscription**: You subscribe to a newspaper. You don't go to the printing press every morning to check if the news is ready. The publisher delivers it to your mailbox when it's printed.

## 💻 Code Snippet

```java
public interface Observer {
    void update(String event);
}

public class EmailUser implements Observer {
    public void update(String event) { System.out.println("Got email: " + event); }
}

public class Store {
    private List<Observer> subscribers = new ArrayList<>();

    public void subscribe(Observer s) { subscribers.add(s); }

    public void notifySubscribers(String event) {
        for (Observer s : subscribers) s.update(event);
    }
}
```

## ✅ Applicability

- Use the Observer pattern when changes to the state of one object may require changing other objects, and the actual set of objects is unknown beforehand or changes dynamically.
- Use the pattern when some objects in your app must observe others, but only for a limited time or in specific cases.

## ⚖️ Pros and Cons

| Pros                                                                                                                            | Cons                                      |
| :------------------------------------------------------------------------------------------------------------------------------ | :---------------------------------------- |
| Open/Closed Principle. You can introduce new subscriber classes without having to change the publisher's code (and vice versa). | Subscribers are notified in random order. |
| You can establish relations between objects at runtime.                                                                         |                                           |
