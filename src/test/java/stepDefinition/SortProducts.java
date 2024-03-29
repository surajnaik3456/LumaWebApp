package stepDefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.HomePage;
import Pages.LoginPage;
import TestBase.TestBase;
import io.cucumber.java.en.*;

public class SortProducts extends TestBase{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	HomePage homePg = new HomePage();
	LoginPage loginPg = new LoginPage();

	@And("User clicks on the sort by dropdown")
	public void click_on_the_sort_by_dropdown() 
	{
		homePg.clickDropdown();
	}
	
	@And("User selects sort by price")
	public void select_sort_by_price()
	{
		homePg.selectSortByPrice(); 

	}

	@Then("Check sorting is done according to the price")
	public void check_sorting_is_done_according_to_the_price()  {
		
		homePg.sortingByPrice();
		Assert.assertTrue(HomePage.isSortedByPrice);
	}
	

	@And("User selects sort by Product Name")
	public void select_sort_by_product_name() {
		homePg.selectSortByProductName();
	    
	}
	@Then("Check sorting is done according to the Product Name")
	public void check_sorting_is_done_according_to_the_product_name()  {
		homePg.sortingByProductName();
		Assert.assertEquals(HomePage.store1, HomePage.store2);
	}







}
