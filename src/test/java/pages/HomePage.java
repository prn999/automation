package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends TestBase {
  WebDriverWait wait = new WebDriverWait(driver, 60);

  @FindBy(xpath = "(//a[@title='T-shirts'])[2]")
  @CacheLookup
  WebElement tshirts;

  @FindBy(xpath = "//a[@class='login']")
  @CacheLookup
  WebElement signIn;

  public void clickTshirts() {
    tshirts.click();
  }

  public void clickSignIn() {
    signIn.click();
  }

}
