# Parallel Tests - Maven + JUnit + Kotlin

A simple temperature converter project for testing parallel test execution with Maven, JUnit 5, and Kotlin.

## Building

```bash
mvn clean compile
```

## Running Tests

### Run all tests
```bash
mvn test
```

### Run successful tests only
```bash
mvn test -Psuccessful-tests
```

### Run failing tests only
```bash
mvn test -Pfailing-tests
```

### Run dependent tests
```bash
mvn test -Pdependent-tests
```

### Run mixed tests (successful + failing + dependent)
```bash
mvn test -Pmixed-tests
```
