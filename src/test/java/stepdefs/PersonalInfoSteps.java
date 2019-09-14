package stepdefs;

import base.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pages.AuthenticationPage;
import pages.HomePage;
import pages.MyAccountPage;
import pages.PersonalInfoPage;

public class PersonalInfoSteps extends TestBase {
  HomePage homePage;
  AuthenticationPage authenticationPage;
  PersonalInfoPage personalInfoPage;
  MyAccountPage myAccountPage;

  public PersonalInfoSteps() {

    authenticationPage = new AuthenticationPage();
    personalInfoPage = new PersonalInfoPage();
    myAccountPage = new MyAccountPage();
    PageFactory.initElements(driver, authenticationPage);
    PageFactory.initElements(driver, personalInfoPage);
    PageFactory.initElements(driver, myAccountPage);
  }


  @And("enter signin details")
  public void enter_signin_details() {
    authenticationPage.signInToAccount();
  }

  @And("navigate to personal information")
  public void navigate_to_personal_information() {
    myAccountPage.clickMyPersonalInfo();
  }

  @And("update personal details")
  public void update_personal_details() {
    personalInfoPage.inputFirstName();
    personalInfoPage.inputCurrentPassword();
  }

  @When("they click save")
  public void they_click_save() {
    personalInfoPage.clickSave();
  }

  @Then("the changes are updated")
  public void the_changes_are_updated() {
    personalInfoPage.verifyUpdateConfirmMsg();
  }

}
