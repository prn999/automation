package stepdefs;

import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;

/*
 *   Landing home page of all step classes
 */
public class HomePageSteps extends TestBase {

  HomePage homePage;

  public HomePageSteps() {
    initialization();
    homePage = new HomePage();
    PageFactory.initElements(driver, homePage);

  }

  @Given("user is on the home page")
  public void the_user_is_on_the_home_page() {
    System.out.println("Opening home page");
  }

  @And("navigate to t-shirts section")
  public void navigate_to_t_shirts_section() {
    homePage.clickTshirts();
  }

  @And("navigate to sign in page")
  public void navigate_to_sign_in_page() {
    homePage.clickSignIn();
  }

  /*
    Cucumber hooks tag @After used to close driver instance after every scenario
   */
  @After
  public void tearDown() {
    driver.quit();
  }

}
