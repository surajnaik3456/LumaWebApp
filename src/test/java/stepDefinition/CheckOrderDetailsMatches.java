package stepDefinition;

import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.HomePage;
import Pages.LoginPage;
import TestBase.TestBase;
import io.cucumber.java.en.*;

public class CheckOrderDetailsMatches extends TestBase {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	HomePage homePg = new HomePage();
	LoginPage loginPg = new LoginPage();
	
	
	
	@When("user clicks on account menu")
	public void user_clicks_on_account_menu() {
		homePg.clickMyAccountMenu();
	    
	}
	@And("selects my account menu")
	public void selects_my_account_menu() {
		homePg.selectFromMenu();
	}
	@And("my account page is displayed")
	public void my_account_page_is_displayed() {
		homePg.myAccountPageDisplayed();
	   
	}
	@And("click my orders button")
	public void click_my_orders_button() {
		homePg.clickMyOrders();
	}
	@Then("my orders page is displayed")
	public void my_orders_page_is_displayed() {
		homePg.myOrderPgDisplayed();
	}
	@And("User clicks on view order for the ordered number")
	public void user_clicks_on_view_order_for_the_ordered_number() {
		homePg.clickViewOrderForOrderNo();
	  
	}
	@And("Checks for the details are as expected")
	public void checks_for_the_details_are_as_expected() {
		homePg.verifyDetails();
		
	    
	}




}
