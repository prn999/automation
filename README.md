This is a BDD automation framework designed in page object pattern

Languages/tools used: JAVA,maven,selenium Webdriver and Cucumber for BDD.

IDE used: Intellij Idea

Web app used for automation: http://automationpractice.com/

PROJECT STRUCTURE: Page Object model.
There are two directories under SRC - main and test.

main: [contains( Test base, Test utils, chromedriver and properties files)]

Two properties files created: 'config' for framework config data and 'userData' for user input data
Test base class loads properties files and also to instantiate browser driver. (additional resusable methods to be created later)

test: [contains( feature files, page object classes,runner and step defs)]

-There are 2 feature files with 1 scenario each and two corresponding step def classes. Additional step def class "HomePageSteps" created for 
modularising steps related to home page for better maintainance. 

-Driver initialisation method from test base class is implemented in homepagesteps class as a execution start point and @After hook implemented in the 
same class. (Seperate Hooks class for both @Before and @After to be implemented later)

TEST EXECUTION: 

Executing individual scenarios: Open Scenario file and rightclick and select run

Executing Multiple: Open RunCukesTest under runners, rightclick and run. (additional configuration can be used such as tags)
Open RunCukesTest class -rightclick on either RunnerTest or the Feature file and click run.

YET TO IMPLEMENT:

-screenshot capture for failed scenarios

-Further assertions to verify

-Implement additional reporting plugin such as Extent or Allure

-For Log generation, implement logging api such as SLF4J

