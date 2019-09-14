package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends TestBase {
  WebDriverWait wait = new WebDriverWait(driver, 60);

  @FindBy(xpath = "//span[contains(.,'My personal information')]")
  @CacheLookup
  WebElement myPersonalInfo;

  public void clickMyPersonalInfo() {
    wait.until(ExpectedConditions.elementToBeClickable(myPersonalInfo));
    myPersonalInfo.click();
  }

}
