package stepDefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import TestBase.TestBase;
import io.cucumber.java.en.*;

public class CheckOrderDetailsMatches extends TestBase {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	HomePage homePg = new HomePage();
	LoginPage loginPg = new LoginPage();
	MyAccountPage myAccountPg = new MyAccountPage();
	
	
	@When("user clicks on account menu")
	public void user_clicks_on_account_menu() {
		homePg.clickMyAccountMenu();
	    
	}
	@And("selects my account menu")
	public void selects_my_account() {
		homePg.selectFromMenu();
	}
	@And("my account page is displayed")
	public void my_account_page_is_displayed() {
		Assert.assertTrue("My account page not displayed..", myAccountPg.myAccountPageDisplayed());
	   
	}
	@And("click my orders button")
	public void click_my_orders_button() {
		myAccountPg.clickMyOrders();
	}
	@Then("my orders page is displayed")
	public void my_orders_page_is_displayed() {
		Assert.assertTrue("My orders page is not displayed", myAccountPg.myOrderPgDisplayed());
	}
	@And("User clicks on view order for the ordered number")
	public void user_clicks_on_view_order_for_the_ordered_number() {
		myAccountPg.clickViewOrderForOrderNo();
	  
	}
	@And("Checks for the details are as expected")
	public void checks_for_the_details_are_as_expected() {
		myAccountPg.verifyDetails();
		Assert.assertEquals(HomePage.productDetail, MyAccountPage.productDetailsInOrderPg);
	    
	}

}
