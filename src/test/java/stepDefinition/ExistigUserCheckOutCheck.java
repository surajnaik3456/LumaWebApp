package stepDefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.OrderSuccessPage;
import Pages.checkoutPage;
import TestBase.TestBase;
import io.cucumber.java.en.*;


public class ExistigUserCheckOutCheck extends TestBase{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	HomePage homePg = new HomePage();
	LoginPage loginPg = new LoginPage();
	checkoutPage checkOutPg = new checkoutPage();
	OrderSuccessPage successPg = new OrderSuccessPage();
	
	
	@When("User clicks on shop new yoga button")
	public void user_clicks_on_shop_new_yoga_button() {
		homePg.shopNewYogaBtnClick();

	}
	@Then ("The {string} page is displayed")
	public void yoga_collection_page_displayed(String pageDisplayed)
	{
		homePg.yogaCollectionPgDisplayed(pageDisplayed);
	}

	@And("^User clicks on the required (.*)$")
	public void click_on_the_required_product(String yogaPant) {
		homePg.selectItem(yogaPant);
	}

	@And("^The required (.*) page is displayed$")
	public void the_required_product_page_is_displayed(String yogaPant) {
		Assert.assertTrue(homePg.selectedItemPgDisplayed(yogaPant));
		homePg.captureDetails();
	}

	@And("^User selects (.*) and (.*)$")
	public void select_size_and_colour(String size,String colour) {
		homePg.selectSize(size);
		homePg.selectColour(colour);

	}
	@And("User clicks on Add to card button")
	public void click_on_add_to_card_button() {
		homePg.clickAddCart();
	}
	@Then("Button text changes to Added")
	public void button_text_changes_to_added() {
		Assert.assertTrue(homePg.btnTextChangesToAdded());
	}
	@And("User should scroll to the top")
	public void user_should_scroll_to_the_top() {
		homePg.scrollToCart();
	}
	@And("User clicks on cart")
	public void click_on_cart()  {
		homePg.clickCart();
	}
	@And("User clicks on proceed to checkout button")
	public void click_on_proceed_to_checkout_button() {
		homePg.clickCheckOutBtn();
	}
	@Then("Checkout page is displayed")
	public void checkout_page_is_displayed() {
		Assert.assertTrue("Checkout page is not displayed..",checkOutPg.checkOutPageDisplayed());

	}
	@And ("User clicks on add new address")
	public void click_new_address_Button() throws InterruptedException 
	{
		checkOutPg.clickNewAddressBtn();
	}
	@And ("The shipping address pop-up appears")
	public void shipping_address_pop_up_displays()
	{
		Assert.assertTrue(checkOutPg.shipingAdPopUpShowsUp());

	}
	@And("^User fills in all the parameters (.*),(.*),(.*),(.*),(.*),(.*) and (.*)$")
	public void user_fills_in_all_the_parameters(String company,String streetAddress,String city,String state,String zip,String country,String phoneNumber) throws InterruptedException {
		checkOutPg.enterCompanyName(company);

		checkOutPg.enterStreetName(streetAddress);

		checkOutPg.enterCityName(city);

		checkOutPg.enterZipCode(zip);

		checkOutPg.selectCountry(country);

		checkOutPg.selectState(state);

		checkOutPg.enterPhnNumb(phoneNumber);

	}
	@And ("User clicks on ship here")
	public void click_ship_here() {
		checkOutPg.clickShipHere();
	}

	@When("User clicks next button")
	public void clicked_on_next_button() {
		checkOutPg.clickNextBtn();
	}
	@Then ("{string} page is getting displayed")
	public void payment_screen(String paymentPage)
	{
		WebElement paymentPg = driver.findElement(By.xpath("//div[text()='Payment Method']"));
		Assert.assertEquals("payment screen is not displaced", paymentPg.getText(), paymentPage);
		homePg.captureDetails2();
	}

	@And("User clicks on place order")
	public void click_on_place_order() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.action.action-edit")));
		homePg.clickPlaceOrderBtn();
	}

	@And ("{string} screen should be displayed with the order number")
	public void screen_should_be_displayed_with_the_order_number(String orderPlacedConfirm) {
		Assert.assertTrue("Order is not placed", successPg.successPageDisplayed(orderPlacedConfirm));
		successPg.captureOrderNumber();

	}





}
