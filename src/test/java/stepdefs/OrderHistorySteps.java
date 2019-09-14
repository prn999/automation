package stepdefs;

import base.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import pages.OrderHistoryPage;
import pages.OrderProcessPage;
import pages.TshirtsPage;

public class OrderHistorySteps extends TestBase {

  HomePage homePage;
  TshirtsPage tshirtsPage;
  OrderProcessPage orderProcessPage;
  OrderHistoryPage orderHistoryPage;

  public OrderHistorySteps() {

    tshirtsPage = new TshirtsPage();
    orderProcessPage = new OrderProcessPage();
    orderHistoryPage = new OrderHistoryPage();
    PageFactory.initElements(driver, tshirtsPage);
    PageFactory.initElements(driver, orderProcessPage);
    PageFactory.initElements(driver, orderHistoryPage);
  }

  String orderRef;


  @And("add an item to the cart")
  public void add_an_item_to_the_cart() {
    tshirtsPage.addItemToCart();
  }

  @And("proceed to checkout")
  public void proceed_to_checkout() {
    tshirtsPage.proceedToCheckout();
    orderProcessPage.proceedToSignin();
    orderProcessPage.signin();
    orderProcessPage.proceedToShipping();
    orderProcessPage.proceedToPayment();
  }

  @When("they make the payment")
  public String they_make_the_payment() {
    orderProcessPage.payByBankwire();
    orderRef = orderProcessPage.orderReference();
    return orderRef;
  }

  @And("navigate to order history page")
  public void navigate_to_order_history_page() {
    orderProcessPage.navigateToOrderHistory();
  }

  @Then("purchased order details should be displayed")
  public void purchased_item_details_should_be_displayed() {
    orderHistoryPage.verifyOrder(orderRef);
  }


}
