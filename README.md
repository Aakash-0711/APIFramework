# API Testing Framework

## Overview
This framework is designed for testing RESTful APIs using Java, Rest-Assured. It is modular, reusable, and follows best practices to ensure maintainability and scalability.



## Framework Components

### 1. hooks package
- **Setup Class:** Manages the base URI from accessing it in config file.


### 2. features package
- **Feature files:** Conatins sample testcase writen in gherkin keyword

### 3. Runner Package
- **RunTest:** Entry point for running Cucumber feature-based tests



### 4. Step package
- **MessageApiStepDefinitions Class:** Mapping feature files to implkement actual code.
- **`src/test/resources/testdata/` directory for maintaing payloads and Config file




## Steps to Execute the Tests

### Prerequisites
- **Java Development Kit (JDK):** Ensure JDK 11 or higher is installed.
- **Maven:** Ensure Maven is installed and configured.
- **IDE:** Use an IDE like IntelliJ IDEA or Eclipse.

### Execution Steps

1. **Clone the Repository**
   ```bash
   git clone https://github.com/Aakash-0711/APIFramework.git
   cd <repository_directory>
   ```

2. **Build the Project**
   ```bash
   mvn clean install
   ```

3. **Run Unit Tests**
   Execute unit tests using Maven:
   ```bash
   mvn test
   ```

4. **View Reports**
   After execution, find the Cucumber reports in the `target/cucumber-reports/` directory.
   

## Future Enhancements
- Add more scenarios for test coverage.
- Integrate with CI/CD pipelines (e.g., Jenkins).



