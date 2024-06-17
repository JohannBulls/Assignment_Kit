# Assignment_Kit

This project is a statistical analysis tool for calculating means and standard deviations from data stored in CSV files.

## Class Diagram

The class diagram can be found in [Class Diagram](src/test/resources/Class Diagram Assignment_Kit.asta).

### Classes and Description

1. **Main**:
    - Main class containing the `main` method to start the application.
    - Uses `FileHandler` to read CSV files and `StatisticsCalculator` to perform statistical calculations.

2. **FileHandler**:
    - Provides static methods to read files and obtain data as a `LinkedList`.

3. **StatisticsCalculator**:
    - Contains static methods to calculate mean and standard deviation for lists of numbers.

4. **LinkedList**:
    - A simple implementation of a generic linked list.
    - Implements `Iterable` to provide iteration over elements.
    - Supports operations like adding elements, retrieving elements by index, and iterating over elements.

5. **StatisticsCalculatorTest**:
    - Automated tests to validate the functionality of `StatisticsCalculator`.

## Getting Started

These instructions will help you get a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

To build and run this project, ensure you have the following installed:

- Java Development Kit (JDK) 8 or higher
- Apache Maven
- Git

### Installation

Follow these steps to set up your development environment:

1. Clone the repository to your local machine:

   ```
   git clone https://github.com/your-username/Assignment_Kit.git
   ```

2. Navigate into the project directory:

   ```
   cd Assignment_Kit
   ```

3. Compile the project using Maven:

   ```
   mvn compile
   ```

### Running the tests

To run the automated tests for this system:

```
mvn test
```

### Detailed Tests

The tests validate the accuracy of mean and standard deviation calculations on different datasets.

```
Example: The testCalculateMeanAndStdDeviation method verifies that calculated values match the expected results.
```

### Coding Style

Coding style tests ensure that the source code adheres to defined standards.

```
Example: The testCalculateMeanAndStdDeviation method verifies the accuracy of mean and standard deviation calculations.
```

## Deployment

To deploy this application on a live system:

1. **Ensure all dependencies are installed:**

    - Java Runtime Environment (JRE) 8 or higher

2. **Compile the project:**

   ```
   mvn clean package
   ```

3. **Run the application:**

   ```
   java -jar target/Assignment_Kit.jar <filename>
   ```

   Replace `<filename>` with the path to the CSV file containing the data.

   **Example:**
   ```
   java -jar target/Assignment_Kit.jar src/main/resources/metadata.csv
   ```

   Expected results could be similar to:

   ```
   Column 1:
     Mean: 550.6
     Standard deviation: 542.67

   Column 2:
     Mean: 51.29
     Standard deviation: 57.65
   ```

## Built With

- [Java](https://www.java.com/) - Programming language
- [Apache Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [Git](https://git-scm.com/) for version control.

## Author

- Johann Amaya Lopez - *JohannBulls* - [JohannBulls GitHub](https://github.com/JohannBulls)

See also the list of [contributors](https://github.com/your-username/Assignment_Kit/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE](https://github.com/JohannBulls/Assignment_Kit/blob/main/LICENSE) file for details.