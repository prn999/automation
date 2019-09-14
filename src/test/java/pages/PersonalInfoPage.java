package pages;

import base.TestBase;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalInfoPage extends TestBase {
  WebDriverWait wait = new WebDriverWait(driver, 60);

  //Page Object Repo
  @FindBy(id = "firstname")
  @CacheLookup
  WebElement firstName;

  @FindBy(id = "old_passwd")
  @CacheLookup
  WebElement currentPassword;

  @FindBy(xpath = "//span[contains(.,'Save')]")
  @CacheLookup
  WebElement save;

  @FindBy(xpath = "//p[@class='alert alert-success']")
  @CacheLookup
  WebElement updateSuccessAlert;


  // Methods
  public String inputFirstName() {
    firstName.clear();
    firstName.sendKeys(userData.getProperty("firstname"));
    String updatedName = firstName.getAttribute("value");

    return updatedName;
  }

  public void inputCurrentPassword() {
    currentPassword.sendKeys(userData.getProperty("password"));
  }

  public void clickSave() {
    save.click();
  }

  public void verifyUpdateConfirmMsg() {

    String confirmMsg = updateSuccessAlert.getText();
    if (confirmMsg.equalsIgnoreCase("Your personal information has been successfully updated.")) {
      System.out.println("**Update Successful!!");
    } else System.out.println("**Failed to update!!");
    Assert.assertTrue(confirmMsg.equalsIgnoreCase("Your personal information has been successfully updated."));
  }
}


