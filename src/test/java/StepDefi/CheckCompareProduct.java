package StepDefi;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.HomePage;
import Pages.LoginPage;
import TestBase.TestBase;
import io.cucumber.java.en.*;

public class CheckCompareProduct extends TestBase{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	HomePage homePg = new HomePage();
	LoginPage loginPg = new LoginPage();
	

	@Then("User scrolls all the way down to hot seller section")
	public void user_scrolls_all_the_way_down_to_hot_seller_section() {
		homePg.scrollToHotSellerSection();
	}
	@When("^Clicks on three bar button to add first (.*) to compare list$")
	public void clicks_on_three_bar_button_to_add_first_compare_list(String product1) {
	  homePg.addFirstProductToCompare(product1);
	}
	@Then("^You added product (.*) to the comparison list shows up$")
	public void you_added_product_one_to_the_comparison_list_shows_up(String product1) {
		homePg.verifyFirstProductAddedSuccessMsg(product1);
	}
	@Then("^Clicks on three bar button to add secound (.*) to compare list$")
	public void clicks_on_three_bar_button_to_add_secound__to_compare_list(String product2) {
		homePg.addSecondProductToCompare(product2);
	}
	@Then("^You added secound product (.*) to the comparison list shows up$")
	public void you_added_secound_product__to_the_comparison_list_shows_up(String product2) {
	   homePg.verifySecondProductAddedSuccessMsg(product2);
	}
	@Then("Click compare products")
	public void click_compare_products() {
		homePg.clickCompareProduct();
	}
	@Then("User get directed to {string} page")
	public void user_get_directed_to_compare_products_page(String comparePgDisplayed) {
		homePg.verifyComparePageDisplays(comparePgDisplayed);
	    
	}
	@Then ("^Check the products added (.*) and (.*) to the list are same products user has added by comparing name,SKU and description$")
	public void check_the_products_added_to_the_list_are_same_products(String product1, String Product2) {
		homePg.verifyProductsAddedToComparePgAreTheSameProducts(product1, Product2);
	    
	}




}
