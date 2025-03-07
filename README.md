# Serenity-Junit-Maven-Java for OpenWeatherMap Sample & Serenity-RestAssured-Maven-Java for SeleniumHQ Sample

## Introduction

This project is built for automated API and UI testing using Serenity with Junit and Rest Assured.

- **Serenity JUnit**: Used for UI testing on [OpenWeatherMap](https://openweathermap.org/)
- **Serenity Rest Assured**: Used for API testing on [SeleniumHQ](https://github.com/SeleniumHQ/)
- **Maven**: Dependency management and project build tool

## Technologies Used

- Java
- Serenity BDD
- JUnit
- Rest Assured
- Maven

## Required Environment

### System Requirements

- **Operating System**: Windows, macOS, or Linux
- **Java**: Version 11 or later (Check with `java -version`)
- **Maven**: Version 3.6+ (Check with `mvn -version`)
- **Browser**: Google Chrome (latest version recommended)
- **ChromeDriver**: Version matching your Chrome installation (Check with `chromedriver --version`)
- **Environment Variables**:
  - `JAVA_HOME`: Points to the Java installation directory
  - `MAVEN_HOME`: Points to the Maven installation directory
  - `PATH`: Ensure `JAVA_HOME/bin` and `MAVEN_HOME/bin` are included

## Installation and Running Tests

### How to Run Tests

1. **Clone the repository**

```sh
git clone https://github.com/trangnt998/JitsuChallenge.git
cd JitsuChallenge
```

2. **Run UI tests (Serenity Selenium JUnit)**

```sh
mvn clean verify -Dgroups="weather"
```
 **=> View Serenity report: Open Weather Map**
After running the tests, the Serenity report can be accessed from:

```sh
target/site/serenity/index.html
```
3. **Run API tests (Serenity Rest Assured)**

```sh
mvn clean verify -Dgroups="github"
```
**=> View Serenity report: SeleniumHQ**
After running the tests, the Serenity report can be accessed from:

```sh
target/site/serenity/index.html
```

## Project Structure

```
JitsuChallenge/
├── src/
│   ├── test/java/
│   │   ├── openweathermap/   # UI testing with Selenium
│   │   │   ├── pages/         # Page Object Model (POM) classes
│   │   │   ├── steps/         # Step definitions
│   │   │   ├── tests/         # UI test cases
│   │   ├── seleniumhq/       # API testing with Rest Assured
│   │   │   ├── requests/      # API request definitions
│   │   │   ├── responses/     # API response models
│   │   │   ├── tests/         # API test cases
│   ├── test/resources/data   # Test data for city want to search
├── target/               # Compiled output and test reports
├── pom.xml               # Maven configuration file
├── README.md             # Documentation
```

