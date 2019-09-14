package pages;

import base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TshirtsPage extends TestBase {

  WebDriverWait wait = new WebDriverWait(driver, 60);

  @FindBy(xpath = "(//a[@title='Faded Short Sleeve T-shirts'])[1]")
  @CacheLookup
  WebElement tshirtDetails;

  @FindBy(xpath = "//a[@title='Add to cart']")
  @CacheLookup
  WebElement addToCart;

  @FindBy(xpath = "//span[contains(.,'Proceed to checkout')]")
  @CacheLookup
  WebElement proceedToCheckout;

  public void addItemToCart() {
    //scroll to locator
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,700)");

    //Hover over element to be visible
    Actions actions = new Actions(driver);
    wait.until(ExpectedConditions.visibilityOf(tshirtDetails));
    actions.moveToElement(tshirtDetails).build().perform();

    wait.until(ExpectedConditions.elementToBeClickable(addToCart));
    addToCart.click();
  }

  public void proceedToCheckout() {
    wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckout));
    proceedToCheckout.click();
  }
}
