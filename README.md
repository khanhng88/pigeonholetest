# Pigeonhole QA Automation Test

This repository contains the source code for an automation test suite built using Java, Selenium, and TestNG. The test suite is designed to execute automated tests on both Firefox and Chrome browsers.

To run the test suite, you will need to have the following software installed:
- Java SDK 17
- Maven

To run the tests, simply run the following command:

```
mvn test -Dsurefire.suiteXmlFiles=testng.xml
```


This will execute the test suite using the default settings. You can customize the test run by modifying the testng.xml file or by passing in command-line arguments.