###Design
The current framework is a WebDriver based framework for UI testing. It uses Maven for dependency management and TestNG framework.

It is a page model based framework where each of the application pages are modelled to a WebPage with the elements on the page and user actions modelled into the attribute and methods.

The tests then use these pages to drive the automation.

####`com.citrix.qa.webinar.core`
`WebDriverFactory` - returns correct instace of WebDriver based on testng parameter. Will default to using chromedriver included with the package.

`WebPage` - Base page class for all common functionalities.

`WebTest` - Base test class for common setup, cleanup and initialization logic.

####`com.citrix.qa.webinar.pages`
Contains all the pages for the identified flow.

####`com.citrix.qa.webinar.util`
Utility methods and constants.

####`com.citrix.qa.webinar.tests`
Actual Automation Tests

###How to run?
You need to have `maven` installed on your machine.
Either update the `testng.xml` with browser of your choice 

- Chrome for ChromeDriver
- Will also need the chromedriver parameter if you want to use your own chromedriver instead of the included one.
- Any other value will let the test use HtmlUnitDriver.

Go at the terminal and run `mvn test` to run the tests.

You can see the reports in `target/surefire-reports` directory.