## Interview questions

🛠️ 1. Singleton Pattern
🔸 Real-World Use Case:

Logger class

DB connection manager

Configuration loader

🔹 Practice/Interview Questions:

Implement a singleton logger that writes logs to a file, and make it thread-safe.

Design a ConfigManager that reads app config once and can be used anywhere.

How would you ensure that only one instance of a Kafka producer is used in a microservice?

Explain the dangers of using Singleton in multi-threaded environments and how to mitigate them.

🏭 2. Factory Method Pattern
🔸 Real-World Use Case:

UI components (e.g., Button for Windows/Mac)

Notification systems (SMS, Email, Push)

Parsing different file formats (XML, JSON, CSV)

🔹 Practice/Interview Questions:

Design a notification system that supports SMS, Email, and Push. Each type should be created by a factory.

How would you refactor an object creation logic that uses too many if-else or switch statements?

Implement a parser that takes a file format and returns the correct parser object (e.g., ParserFactory.getParser("xml")).

🏢 3. Abstract Factory Pattern
🔸 Real-World Use Case:

Cross-platform UI (Windows vs Mac components)

Families of related objects: e.g., creating different types of databases (SQL, NoSQL)

Theming components: light theme vs dark theme widgets

🔹 Practice/Interview Questions:

Design a UI toolkit for Mac and Windows where each OS has different buttons, textboxes, etc.

Implement a cloud provider factory that can create storage and compute services for AWS, Azure, or GCP.

What’s the difference between Abstract Factory and Factory Method? When to use which?

🧱 4. Builder Pattern
🔸 Real-World Use Case:

Creating complex objects (e.g., HTTP requests, documents)

Fluent APIs

Building immutable objects with optional parameters

🔹 Practice/Interview Questions:

Design a User class with many optional fields (name, age, phone, address), and use the Builder pattern to create instances.

Implement a query builder that constructs SQL queries in a chainable way.

Build a complex meal object with food, drink, and dessert using a MealBuilder.

📦 5. Prototype Pattern
🔸 Real-World Use Case:

Object cloning where instantiation is expensive

Game development (clone character with small modifications)

Undo operations (deep copying object states)

🔹 Practice/Interview Questions:

Suppose object creation is expensive (e.g., a deep-loaded configuration object), how can you avoid creating it from scratch every time?

Implement a prototype registry for cloning shapes (circle, square) in a graphics editor.

What's the difference between shallow and deep copy in prototype? Show with an example.

💼 Bonus: Combine Patterns for Real Projects
🔹 Practice Scenarios:

You're building an e-commerce system. Use:

Singleton for DB connection

Factory for payment method creation (CreditCard, PayPal)

Builder for generating invoices

Abstract Factory for product UI themes

You're building a microservice for notifications:

Use Factory to get appropriate sender (SMS, Email, Push)

Use Singleton for shared resources (like API clients)

Use Builder to create messages or payloads

📚 Pro Tips for Interviews & Work

Don’t just name the pattern — explain why it fits.

Think in terms of flexibility and maintainability, not just reuse.

Show how patterns reduce code complexity in larger systems.

When discussing with teammates or interviewers, ask: “What if requirements change? Would this pattern help us adapt?”
