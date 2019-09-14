package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage extends TestBase {
  /*
  Page object repo
   */
  @FindBy(id = "email")
  @CacheLookup
  WebElement email;

  @FindBy(id = "passwd")
  @CacheLookup
  WebElement password;

  @FindBy(xpath = "//span[contains(.,'Sign in')]")
  @CacheLookup
  WebElement signIn;

  public void signInToAccount() {
    email.sendKeys(userData.getProperty("email"));
    password.sendKeys(userData.getProperty("password"));
    signIn.click();
  }
}
