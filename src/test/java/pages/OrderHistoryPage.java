package pages;

import base.TestBase;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class OrderHistoryPage extends TestBase {

  OrderProcessPage orderProcessPage = new OrderProcessPage();

  @FindBy(xpath = "(//a[@class='color-myaccount'])[1]")
  @CacheLookup
  WebElement recentOrderRef;

  public void verifyOrder(String orderRef) {
    String orderConfirmation = recentOrderRef.getText();
    if (orderRef.equals(orderConfirmation)) {
      System.out.println("*** Purchase Order Reference: " + orderRef
        + "\n -Matches with order reference in orders history page: " + orderConfirmation);
    } else {
      System.out.println("Unable to verify purchase in order history page");
    }
    Assert.assertTrue(orderConfirmation.equalsIgnoreCase(orderRef));
  }
}
