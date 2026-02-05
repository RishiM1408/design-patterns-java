<div align="center">
  <h3>Project Views</h3>
  <img src="https://komarev.com/ghpvc/?username=RishiM1408-design-patterns-java&label=Project%20Views&color=0e75b6&style=flat" alt="Project Views" />
</div>

# Masterclass in Java Design Patterns

Welcome to the **Masterclass in Java Design Patterns**. This repository is an educational resource designed for backend engineers to master the 23 Gang of Four (GoF) design patterns using modern Java (17+).

Unlike typical "Foo/Bar" examples, this repository uses **Real-World Scenarios** relevant to enterprise backend development (e.g., Database drivers, Payment processing, Stock tickers).

## Table of Contents

1.  [Creational Patterns](#creational-patterns)
2.  [Structural Patterns](#structural-patterns)
3.  [Behavioral Patterns](#behavioral-patterns)

---

## <a name="creational-patterns"></a>1. Creational Patterns

_Deals with object creation mechanisms, increasing flexibility and reuse of existing code._

### 1.1 Singleton

- **Definition:** Ensures a class has only one instance and provides a global point of access to it.
- **The Problem:** You need to control access to a shared resource (e.g., database or file system), ensuring clients don't create multiple conflicting connections.
- **The Solution:** Make the constructor private and provide a static method that returns the existing instance or creates a new one if it doesn't exist.
- **Real-world Analogy:** The Government. A country can have only one official government. Wherever "The Government" is referenced, it refers to the same unique group of people holding authority.
- **When to use:**
  - Managing connections to a database.
  - Logging services.
  - Application configuration settings.

### 1.2 Factory Method

- **Definition:** Defines an interface for creating an object but lets subclasses alter the type of objects that will be created.
- **The Problem:** A framework needs to standardize the processing of objects (e.g., Documents) but allow users to define new types (e.g., PDF, Word) without changing the framework's core code.
- **The Solution:** Replace direct object construction calls (using `new`) with calls to a special factory method.
- **Real-world Analogy:** A Logistics Company. A unified logistics app can handle deliveries by Truck, Ship, or specialized Robots. The app's core logic plans the route, but a factory method decides _which_ transport vehicle "object" is created for the journey.
- **When to use:**
  - When you don't know beforehand the exact types and dependencies of the objects your code should work with.
  - To provide a library or framework where users can extend internal components.

### 1.3 Abstract Factory

- **Definition:** Produces families of related or dependent objects without specifying their concrete classes.
- **The Problem:** Your code needs to work with various families of related products (e.g., UI elements for Windows, macOS, Linux), and you want to avoid creating inconsistent sets of objects (e.g., a Windows button on a macOS menu).
- **The Solution:** Define an interface for creating each distinct product in the family (e.g., `createButton`, `createCheckbox`). Concrete factories implement this to produce specific product families.
- **Real-world Analogy:** A Furniture Scandi-Shop vs. Victorian Application. The furniture factory creates a "Chair" and "Sofa" and "Coffee Table". If you choose the "Modern" factory, you get a matching set. If you choose "Victorian", you get a different matching set. You never mix a plastic modern chair with a Victorian mahogany table.
- **When to use:**
  - Cross-platform UI toolkits (Java AWT/Swing/JavaFX).
  - Database abstraction layers (supporting multiple DB vendors).

### 1.4 Builder

- **Definition:** Lets you construct complex objects step by step. It allows you to produce different types and representations of an object using the same construction code.
- **The Problem:** You have a complex object (like a `DatabaseConfiguration`) with 10+ possible parameters, most of which are optional. A constructor with 10 arguments is messy/impossible to read.
- **The Solution:** Extract the object construction code out of its own class and move it to a separate object called a "Builder".
- **Real-world Analogy:** Building a Custom PC. You don't just "buy a PC" from a single pile of parts. You select a CPU, then a GPU, then RAM, then Storage. The assembly process is the same, but the resulting PC (Gaming vs. Office) depends on the parts selected step-by-step.
- **When to use:**
  - Constructing complex objects like SQL queries (QueryBuilder).
  - Building HTTP configurations (HttpRequest.Builder).
  - Generating documents (HTML, PDF) where the structure is built incrementally.

### 1.5 Prototype

- **Definition:** Lets you copy existing objects without making your code dependent on their classes.
- **The Problem:** You want to create an exact copy of an object, but some fields are private or the object creation is expensive (e.g., requires a database call or parsing a huge file).
- **The Solution:** Delegate the cloning process to the actual object that is being cloned. The object declares a `clone` method.
- **Real-world Analogy:** Mitotic Cell Division. A cell splits and produces an exact copy of itself. The cell uses its own internal knowledge to replicate, rather than an external doctor trying to build a cell from atoms.
- **When to use:**
  - Caching: Keeping a set of pre-initialized objects ready to be cloned.
  - When object creation is more expensive than copying.

---

## <a name="structural-patterns"></a>2. Structural Patterns

_Explains how to assemble objects and classes into larger structures while keeping these structures flexible and efficient._

### 2.1 Adapter

- **Definition:** Allows objects with incompatible interfaces to collaborate.
- **The Problem:** You have a legacy system expecting XML data, but a new 3rd-party analytics library only accepts JSON. You can't change the 3rd-party code.
- **The Solution:** Create a "wrapper" class that translates calls from the client interface to the adaptee's interface.
- **Real-world Analogy:** Power Plug Adapter. You travel from the US to Europe. Your laptop plug (US) doesn't fit the wall socket (EU). You use an adapter that accepts the US plug and fits into the EU socket, transferring electricity without changing the laptop or the wall.
- **When to use:**
  - Integrating legacy code with modern classes.
  - Using 3rd-party libraries that don't match your application's interface.

### 2.2 Bridge

- **Definition:** Lets you split a large class or a set of closely related classes into two separate hierarchies—abstraction and implementation—which can be developed independently.
- **The Problem:** You have a `Shape` class with subclasses `Circle` and `Square`. You want to extend this to support rendering on `Windows` and `Linux`. You end up with `WindowsCircle`, `LinuxCircle`, `WindowsSquare`, etc. The class explosion prevents scaling.
- **The Solution:** Separate the Abstraction (Shape) from the Implementation (Renderer). The Shape holds a reference to a Renderer.
- **Real-world Analogy:** Universal Remote. The remote (Abstraction) controls the TV (Implementation). You can change the TV (Implementation) without changing the remote. You can change the remote layout (Abstraction) without buying a new TV.
- **When to use:**
  - Cross-platform drivers (JDBC drivers bridging Java to Oracle/MySQL/Postgres).
  - GUI frameworks separating window logic from OS rendering.

### 2.3 Composite

- **Definition:** Lets you compose objects into tree structures and then work with these structures as if they were individual objects.
- **The Problem:** You have a structure of "Orders" and "Boxes". A Box can contain Products or smaller Boxes. You want to calculate the total price.
- **The Solution:** Create a common interface (Component) for both primitive (Product) and composite (Box) objects. The composite delegates work to its children recursively.
- **Real-world Analogy:** A Military Organization. A General gives an order to a Division. The Division passes it to Brigades... down to Platoons, until the Soldiers execute it. The General doesn't care about the hierarchy details; they just give a command.
- **When to use:**
  - File systems (Directories containing Files and other Directories).
  - GUI components (Panels containing Buttons and other Panels).

### 2.4 Decorator

- **Definition:** Lets you attach new behaviors to objects by placing these objects inside special wrapper objects that contain the behaviors.
- **The Problem:** You want to add features like "Encryption", "Compression", and "Logging" to a data stream. Inheritance creates a rigid static hierarchy (`EncryptedCompressedStream`, `EncryptedLoggedStream`, etc.).
- **The Solution:** Use composition. Create "Decorator" classes that implement the same interface as the wrapped object. You can stack them: `new Compression(new Encryption(new FileStream()))`.
- **Real-world Analogy:** Wearing Clothes. You are the base object. Any piece of clothing is a decorator. You can wear a shirt, then a jacket, then a raincoat. You gain the properties of each layer (warmth, rain protection) dynamically.
- **When to use:**
  - Java I/O Streams (`BufferedInputStream` wrapping `FileInputStream`).
  - Adding cross-cutting concerns (logging, transactional state) dynamically.

### 2.5 Facade

- **Definition:** Provides a simplified interface to a library, a framework, or any other complex set of classes.
- **The Problem:** To make a video conversion app work, you have to configure 10 complex classes (Codecs, BitrateReader, AudioMixer). Client code becomes tightly coupled to the implementation details of the library.
- **The Solution:** Create a `VideoConverter` class with a single method `convert(file, format)`. This class handles the complexity internally.
- **Real-world Analogy:** A Bank Teller. You want to transfer money. You don't go into the vault, update the ledgers, and check the security logs yourself. You talk to the teller (Facade), who handles all those complex subsystems for you.
- **When to use:**
  - Wrapping a complex API (like AWS SDKs or complex libraries) with a simpler helper class.
  - Structuring a system into layers, where a facade defines the entry point to each layer.

### 2.6 Flyweight

- **Definition:** Lets you fit more objects into the available amount of RAM by sharing common parts of state between multiple objects instead of keeping all of the data in each object.
- **The Problem:** You are building a game with 1,000,000 trees. Each tree object has mesh data, texture, position, and color. The RAM explodes because mesh/texture is duplicated 1,000,000 times.
- **The Solution:** Separate "Intrinsic" state (shared: mesh, texture) from "Extrinsic" state (unique: position). Store intrinsic state in one object and reference it.
- **Real-world Analogy:** A Library. Libraries don't buy a new copy of _Harry Potter_ for every single reader. They have a few copies (intrinsic) that are shared. The "borrowing record" (extrinsic) links a specific reader to a specific copy for a duration.
- **When to use:**
  - String interning in Java (`String pool`).
  - Rendering huge numbers of similar objects in graphics.
  - Caching often-used immutable objects.

### 2.7 Proxy

- **Definition:** Lets you provide a substitute or placeholder for another object. A proxy controls access to the original object, allowing you to perform something either before or after the request gets through to the original object.
- **The Problem:** You have a massive object (e.g., a High-Res Image or a Database connection) that consumes lots of resources. You don't want to load it until it's actually requested.
- **The Solution:** Create a Proxy class with the same interface. The Proxy loads the real object only when a method is called (Lazy Initialization).
- **Real-world Analogy:** A Credit Card. A credit card is a proxy for a bundle of cash. You can use it to pay, but the actual money (resource) is only moved from the bank account when the transaction is processed securely.
- **When to use:**
  - Lazy loading (Hibernate uses proxies for entity relationships).
  - Access control (Security proxy checking permissions).
  - Logging/Audit logging (recording requests).

---

## <a name="behavioral-patterns"></a>3. Behavioral Patterns

_Concerned with algorithms and the assignment of responsibilities between objects._

### 3.1 Chain of Responsibility

- **Definition:** Lets you pass requests along a chain of handlers. Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in the chain.
- **The Problem:** A web request needs to pass through Authentication, Authorization, Validation, and Rate Limiting. You don't want a giant `if-else` block.
- **The Solution:** Link these checks into a chain. The request travels down the chain until one handler processes it or rejects it, or it reaches the end.
- **Real-world Analogy:** Tech Support. You call level 1 support. If they can't fix it, they pass you to level 2. If they can't fix it, it goes to level 3 (Engineer).
- **When to use:**
  - Middleware pipelines (Servlet Filters, Spring Security, Logging frameworks).
  - Event bubbling in UI frameworks.

### 3.2 Command

- **Definition:** Turns a request into a stand-alone object that contains all information about the request.
- **The Problem:** You want to support Undo/Redo operations, or queue requests (e.g., "scheduler"), or parameterize objects with operations.
- **The Solution:** Encapsulate the method call (object, method name, arguments) into a `Command` object with an `execute()` method.
- **Real-world Analogy:** A Restaurant Order. You (Client) give an order to the Waiter (Invoker). The Waiter writes it on a pad (Command). The Waiter sticks it in the kitchen queue. The Chef (Receiver) picks it up and cooks. The Waiter doesn't need to know how to cook; the Pad decouples them.
- **When to use:**
  - GUI Buttons and Menu items.
  - Job Queues / Task Scheduling.
  - Undo/Redo functionality.

### 3.3 Interpreter

- **Definition:** Given a language, define a representation for its grammar along with an interpreter that uses the representation to interpret sentences in the language.
- **The Problem:** You need to parse and execute a specific expression language (like "5 + 10 - 2" or SQL-like queries) frequently.
- **The Solution:** Build a tree of expression classes (Number, Plus, Minus) that implement an `interpret()` interface.
- **Real-world Analogy:** Translating Music Notes. A musician reads a sheet of music (the language/grammar). The musician's brain (interpreter) translates the symbols into finger movements to produce sound.
- **When to use:**
  - Compilers / Parsers.
  - SQL parsing.
  - Regular Expression engines.

### 3.4 Iterator

- **Definition:** Lets you traverse elements of a collection without exposing its underlying representation (list, stack, tree, graph).
- **The Problem:** You have a collection (e.g., a Social Network Graph). You want to traverse "Friends", "Co-workers", or "Family". You don't want client code to know if it's stored as an Array or a Linked List.
- **The Solution:** Extract the traversal behavior into an `Iterator` object (`hasNext()`, `next()`).
- **Real-world Analogy:** A Tour Guide. You visit a museum. You can walk randomly, or you can hire a guide (Iterator). The guide knows the specific optimized path to show you all the exhibits without you needing to know the museum layout map.
- **When to use:**
  - Accessing contents of a collection without exposing internal structure.
  - Providing a uniform interface for traversing different data structures (`java.util.Iterator`).

### 3.5 Mediator

- **Definition:** Lets you reduce chaotic dependencies between objects. The pattern restricts direct communications between the objects and forces them to collaborate only via a mediator object.
- **The Problem:** In a classic "Airport", if every pilot talked to every other pilot to decide who lands first, there would be chaos and crashes.
- **The Solution:** Create a "Control Tower" (Mediator). Pilots (Colleagues) only talk to the tower. The tower decides who goes where.
- **Real-world Analogy:** Air Traffic Control Tower (as described above).
- **When to use:**
  - Chat rooms (Server is the mediator).
  - complex GUI forms where changing one field updates 5 others.

### 3.6 Memento

- **Definition:** Lets you save and restore the previous state of an object without revealing the details of its implementation.
- **The Problem:** You want to implement "Undo" in a text editor. You need to save the state of the editor, including private fields, without breaking encapsulation.
- **The Solution:** The object (Originator) creates a snapshop (Memento) of its state. Only the Originator can read the Memento. The Caretaker (History object) holds the Memento but can't tamper with it.
- **Real-world Analogy:** Save Game / Checkpoint. Before fighting a boss, you save your game. If you die, you reload. The save file (Memento) holds your health, inventory, and location, but you (the player) don't edit the binary save file manually.
- **When to use:**
  - Undo/Redo features.
  - Transactions (rolling back to a savepoint).

### 3.7 Observer

- **Definition:** Lets you define a subscription mechanism to notify multiple objects about any events that happen to the object they're observing.
- **The Problem:** You have a "Stock Market" data feed. 1000 different dashboard widgets need to update when a price changes. Polling the market every millisecond is inefficient.
- **The Solution:** The Dashboard widgets (Observers) "subscribe" to the Stock Market (Subject). When the Subject changes, it iterates through subscribers and calls `update()`.
- **Real-world Analogy:** Magazine Subscription. You don't go to the store every day to check for a new issue. You subscribe. The publisher sends the new issue to your mailbox when it's ready.
- **When to use:**
  - Event-driven systems (GUI listeners).
  - Pub/Sub messaging systems (Kafka, RabbitMQ concepts).

### 3.8 State

- **Definition:** Lets an object alter its behavior when its internal state changes. It appears as if the object changed its class.
- **The Problem:** A "Document" can be in "Draft", "Moderation", or "Published" state. The `publish()` method does different things in each state (Draft -> moves to Moderation; Moderation -> moves to Published; Published -> does nothing). Giant switch statements are bad.
- **The Solution:** Create concrete State classes (`DraftState`, `ModerationState`). The Document delegates the `publish()` call to the current state object.
- **Real-world Analogy:** A Vending Machine. If it's in "No Coin" state, pressing a button does nothing. If it's in "Has Coin" state, pressing a button dispenses a soda and switches to "No Coin" state.
- **When to use:**
  - Finite State Machines (Order processing systems, Game character AI).
  - Replacing large conditional state logic.

### 3.9 Strategy

- **Definition:** Defines a family of algorithms, puts each of them into a separate class, and makes their objects interchangeable.
- **The Problem:** A "Navigation App" can build routes for Walking, Driving, or Public Transport. The route building code is massive if it's all in one class.
- **The Solution:** Define a `outeStrategy` interface. Create `WalkingStrategy`, `DrivingStrategy`. The Navigator object holds a reference to a Strategy and delegates the calculation.
- **Real-world Analogy:** Getting to the Airport. You can choose a strategy: "Take Taxi", "Take Bus", "Drive Car". The goal is the same (Airport), but the execution method is interchangeable based on cost/time.
- **When to use:**
  - Payment processing (CreditCardStrategy, PayPalStrategy).
  - Sorting algorithms (QuickSort, MergeSort).
  - Compression algorithms.

### 3.10 Template Method

- **Definition:** Defines the skeleton of an algorithm in the superclass but lets subclasses override specific steps of the algorithm without changing its structure.
- **The Problem:** You have a "Data Miner" that opens a file, extracts data, parses it, and closes the file. The "Open" and "Close" steps are the same for PDF, CSV, and Doc, but the "Parse" step is different.
- **The Solution:** Create a base class with a `mine()` method that calls `open()`, `parse()`, `close()`. Make `open` and `close` standard, and keep `parse` abstract.
- **Real-world Analogy:** Home Building. The general process is: Build Foundation -> Build Walls -> Build Roof -> Install Windows. Every house follows this template. But "Build Walls" might mean "Brick Walls" for one house and "Wooden Walls" for another.
- **When to use:**
  - Frameworks where the overall flow is fixed but specific steps must be customizable (Spring `JdbcTemplate`).
  - Code reuse implementation.

### 3.11 Visitor

- **Definition:** Lets you separate algorithms from the objects on which they operate.
- **The Problem:** You have a graph of different node types (City, Industry, TouristSpot). You want to export this graph to XML. You shouldn't have to add an `exportToXML()` method to every node class (violates Single Responsibility).
- **The Solution:** Create a `Visitor` interface with methods `visit(City)`, `visit(Industry)`. Pass the visitor object to the nodes.
- **Real-world Analogy:** An Insurance Agent. The agent visits your House, your Car, and your Office. The agent performs a "Assess Value" operation on each. The House class doesn't need to know how to assess insurance value; the Visitor (Agent) does that.
- **When to use:**
  - Performing an operation on all elements of a complex object structure (e.g., Document Object Model / AST).
  - When you need to clean up data models without polluting them with business logic.

---

## 📚 Appendix: What to Study Next?

Mastering Design Patterns is a significant milestone, but it's just one step in the journey of a Senior Backend Engineer. Here is a curated roadmap of what you should tackle next:

### 1. System Design (High-Level Architecture)

Design patterns deal with class-level structure. System Design deals with the structure of the entire platform.

- **Concepts:** Scalability, Load Balancing, Caching, Database Sharding, CAP Theorem.
- **Resources:** _Designing Data-Intensive Applications_ by Martin Kleppmann (The Bible of backend engineering).

### 2. Microservices Patterns

The "Design Patterns" for distributed systems.

- **Patterns:** Circuit Breaker, Saga Pattern, CQRS (Command Query Responsibility Segregation), Event Sourcing, Sidecar, BFF (Backend for Frontend).
- **Goal:** Understand how to manage distributed transactions and failures.

### 3. Clean Architecture & DDD (Domain-Driven Design)

How to organize your code so it remains maintainable for 10+ years.

- **Concepts:** Hexagonal Architecture (Ports and Adapters), Onion Architecture, Entities, Value Objects, Aggregates, Bounded Contexts.
- **Goal:** Learn to decouple your business logic from frameworks (Spring/Hibernate) and infrastructure.

### 4. Concurrency & Multithreading

Java's strength lies in its concurrency model.

- **Concepts:** Java Memory Model, CompletableFuture, Virtual Threads (Project Loom), Locks, Atomic Variables, Fork/Join Framework.
- **Goal:** Write thread-safe code without just slapping `synchronized` everywhere.

### 5. Cloud Native Technologies

Modern backend runs on the cloud.

- **Tech Stack:** Docker, Kubernetes (K8s), AWS/GCP/Azure Services, Serverless (Lambda), Terraform (IaC).
