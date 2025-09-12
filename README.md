# Java Tests and Tips

A collection of Java tests and tips demonstrating Java 8 features including lambdas, streams, optional types, and more.

## Project Structure

This project follows the standard Maven directory layout:

```
src/
├── main/
│   └── java/
│       └── jgisson/
│           └── java/
│               └── java8/
│                   ├── date/           # Date and time examples
│                   ├── defaultinterface/  # Default interface methods
│                   ├── foreach/        # ForEach examples
│                   ├── lambda/         # Lambda expressions
│                   ├── methodreference/ # Method references
│                   ├── optional/       # Optional type usage
│                   ├── stream/         # Stream API examples
│                   ├── string/         # String operations
│                   └── thread/         # Thread and executor examples
└── test/
    └── java/               # Test classes (to be added)
```

## Building and Running

### Prerequisites

- Java 8 or higher
- Maven 3.6 or higher

### Build Commands

```bash
# Compile the project
mvn clean compile

# Package into JAR
mvn clean package

# Clean build artifacts
mvn clean

# Run a specific example class
mvn exec:java -Dexec.mainClass="jgisson.java.java8.foreach.ForEachExample"

# Run with different main class
mvn exec:java -Dexec.mainClass="jgisson.java.java8.lambda.LambdaExample"
```

### Examples Available

- **ForEach**: Demonstrates Java 8 forEach operations
- **Lambda**: Lambda expression examples
- **Streams**: Stream API usage patterns
- **Optional**: Null-safe programming with Optional
- **Date/Time**: New Java 8 date and time API
- **Method References**: Method reference syntax
- **Default Interfaces**: Interface default methods
- **Threading**: Executor service examples

## Maven Configuration

This project is configured with:
- Java 8 source and target compatibility
- Maven Compiler Plugin 3.11.0
- Maven Surefire Plugin for testing
- Exec Maven Plugin for running examples
- JUnit 4.13.2 for testing (scope: test)
