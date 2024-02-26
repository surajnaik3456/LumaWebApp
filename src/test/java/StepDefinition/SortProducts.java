package StepDefinition;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.HomePage;
import Pages.LoginPage;
import TestBase.TestBase;
import io.cucumber.java.en.*;

public class SortProducts extends TestBase{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	HomePage homePg = new HomePage();
	LoginPage loginPg = new LoginPage();

	@And("Click on the sort by dropdown")
	public void click_on_the_sort_by_dropdown() 
	{
		homePg.clickDropdown();
	}
	
	@And("Select sort by price")
	public void select_sort_by_price()
	{
		homePg.selectSortByPrice(); 

	}

	@Then("check sorting is done according to the price")
	public void check_sorting_is_done_according_to_the_price()  {
		
		homePg.sortingByPrice();
	}
	

	@And("Select sort by Product Name")
	public void select_sort_by_product_name() {
		homePg.selectSortByProductName();
	    
	}
	@Then("check sorting is done according to the Product Name")
	public void check_sorting_is_done_according_to_the_product_name() throws InterruptedException {

		List<String> store1 = new ArrayList<String>();
		List<WebElement> Sort1= driver.findElements(By.xpath("//a[@class='product-item-link']"));
		
		for(WebElement store:Sort1)
		{
			String data1 = store.getText();
			store1.add(data1);
		}
		
		List<String> store2 = new ArrayList<String>();
		List<WebElement> Sort2= driver.findElements(By.xpath("//a[@class='product-item-link']"));
		
		for(WebElement stor:Sort2)
		{
			String data2 = stor.getText();
			store2.add(data2);
		}
	
		Collections.sort(store1);
		System.out.println(store1);
		System.out.println(store2);
		
		Assert.assertEquals(store1, store2);
	}







}
