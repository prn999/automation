package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderProcessPage extends TestBase {

  WebDriverWait wait = new WebDriverWait(driver, 30);

  /************ Web Elements Repo ************/
  @FindBy(xpath = "(//span[contains(.,'Proceed to checkout')])[2]")
  @CacheLookup
  WebElement proceedToCheckout1;

  @FindBy(xpath = "//input[@id='email']")
  @CacheLookup
  WebElement email;

  @FindBy(xpath = "//input[@id='passwd']")
  @CacheLookup
  WebElement password;

  @FindBy(xpath = "(//span[contains(.,'Sign in')])[2]")
  @CacheLookup
  WebElement signin;

  @FindBy(xpath = "(//span[contains(.,'Proceed to checkout')])[2]")
  @CacheLookup
  WebElement proceedToCheckout2;

  @FindBy(xpath = "//input[@id='cgv']")
  @CacheLookup
  WebElement termsCheckbox;

  @FindBy(xpath = "(//span[contains(.,'Proceed to checkout')])[2]")
  @CacheLookup
  WebElement proceedToCheckout3;

  @FindBy(xpath = "//a[@class='bankwire']")
  @CacheLookup
  WebElement bankwirePay;

  @FindBy(xpath = "//span[contains(.,'I confirm my order')]")
  @CacheLookup
  WebElement confirmPay;

  @FindBy(xpath = "//div[@class='box']")
  @CacheLookup
  WebElement orderConfirmMsg;

  @FindBy(xpath = "//a[@title='Back to orders']")
  @CacheLookup
  WebElement backToOrders;


  public void proceedToSignin() {
    proceedToCheckout1.click();
  }

  public void signin() {
    String emailID = userData.getProperty("email");
    String pwd = userData.getProperty("password");
    email.sendKeys(emailID);
    password.sendKeys(pwd);
    signin.click();
  }

  public void proceedToShipping() {
    proceedToCheckout2.click();
  }

  public void proceedToPayment() {
    termsCheckbox.click();
    proceedToCheckout3.click();
  }

  public void payByBankwire() {
    bankwirePay.click();
    confirmPay.click();
  }

  public void navigateToOrderHistory() {
    backToOrders.click();
  }

  // Retrieve order reference from order confirmation message using regex
  public String orderReference() {
    String orderConfirmationMsg = orderConfirmMsg.getText();
    Pattern pattern = Pattern.compile("order reference (.+[A-Z]) in the subject");
    Matcher matcher = pattern.matcher(orderConfirmationMsg);
    matcher.find();
    String orderRef = matcher.group(1);
    return orderRef;
  }
}
