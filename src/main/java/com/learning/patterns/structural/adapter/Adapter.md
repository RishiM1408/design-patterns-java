# Adapter Pattern

## 🔍 Definition

**Adapter** is a structural design pattern that allows objects with incompatible interfaces to collaborate.

## 🧩 The Problem

You have a legacy analytics library that accepts data in **XML** format. You are introducing a new, modern client application that sends data in **JSON**. You can't change the legacy library (it's 3rd party or immutable), and you can't change the client to produce XML (it breaks modern standards).

## 💡 The Solution

Create an **Adapter** class.

1.  It implements the interface the client expects (JSON).
2.  It wraps the legacy object (XML).
3.  It translates the request from the client (JSON) into a call to the wrapped object (XML).

## 🏗️ Real-World Analogy

**Power Plug Adapter**: In the USA, plugs have flat pins. In Europe, they have round pins. An American tourist in Paris cannot plug their laptop into the wall. They use a "Physical Adapter": it accepts the US plug and fits into the EU socket, transferring the electricity.

## 💻 Code Snippet

```java
// Target Interface (Client expects this)
public interface AnalyticsLibrary {
    void analyzeData(String jsonData);
}

// Adaptee (Legacy/Incompatible)
public class LegacyXmlService {
    public void processXmlData(String xmlData) { ... }
}

// Adapter
public class XmlToJsonAdapter implements AnalyticsLibrary {
    private LegacyXmlService service;

    public XmlToJsonAdapter(LegacyXmlService service) {
        this.service = service;
    }

    @Override
    public void analyzeData(String jsonData) {
        // Translate JSON -> XML
        String xml = convertToXml(jsonData);
        // Delegate
        service.processXmlData(xml);
    }
}
```

## ✅ Applicability

- Use the Adapter class when you want to use some existing class, but its interface isn't compatible with the rest of your code.
- Use when you want to reuse several existing subclasses that lack some common functionality that can't be added to the superclass.

## ⚖️ Pros and Cons

| Pros                                                                                         | Cons                                                                                                |
| :------------------------------------------------------------------------------------------- | :-------------------------------------------------------------------------------------------------- |
| Single Responsibility Principle. Data conversion logic is separated from business logic.     | The overall complexity increases because you need to introduce a set of new interfaces and classes. |
| Open/Closed Principle. You can introduce new types of adapters without breaking client code. | sometimes it's simpler just to change the service class if it matches the rest of your code.        |
