package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.TestBase;

public class ProductPage extends TestBase{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	By category =By.xpath("//div[text()='Category']");
	By products = By.xpath("//a[@class='product-item-link']");
	By moreInfo = By.xpath("//a[contains(text(),'More Information')]");
	By categoryInfo = By.xpath("//td[@data-th='Category']");
	By patternInfo = By.xpath("//td[@data-th='Pattern']");
	By colorFilter = By.xpath("//div[text()='Color']");
	By highlightedColor = By.xpath("//div[@class='swatch-option color selected']");
	By patternFilter = By.xpath("//div[text()='Pattern']");
	By price =By.xpath("//div[text()='Price']");
	By productPrice = By.xpath("//span[@class='price']");

	public static boolean isFiltered;
	public static boolean isColorFiltered;
	public static boolean isFilteredByPattern;
	public static boolean filteredByPrice;

	public void selectsCategoryFilter()
	{
		driver.findElement(category).click();
	}
	public void selectsAnCategory(String category)
	{
		driver.findElement(By.xpath("//a[contains(text(),'"+category+"')][1]")).click();
	}
	public boolean verifyCategoryFilterIsApplied(String category)
	{
		List<WebElement> filteredProducts = driver.findElements(products);
		isFiltered = true;
		int size = filteredProducts.size(); 
		for (int i = 0; i < size; i++) {
			WebElement check = filteredProducts.get(i);
			boolean clickedSuccessfully = false; 
			try {
				check.click();
				clickedSuccessfully = true; 
			} catch (StaleElementReferenceException e) {
				System.out.println("StaleElementReferenceException occurred.. Re-finding elements");
				filteredProducts = driver.findElements(products); 
				size = filteredProducts.size(); 
				if (i >= size) {
					break; 
				}
				check = filteredProducts.get(i);
				try {
					check.click();
					clickedSuccessfully = true; 
				} catch (Exception ex) {

					System.out.println("Exception occurred while clicking element: " + ex.getMessage());
				}
			}

			if (clickedSuccessfully) {
				driver.findElement(moreInfo).click();
				if (!driver.findElement(categoryInfo).getText().contains(category)) {
					isFiltered = false;
					break;
				} else {
					driver.navigate().back();
				}
			}
		}
		return isFiltered;
	}
	public void selectColorFilter() {
		driver.findElement(colorFilter).click();


	}
	public void selectAnColor(String color) {
		driver.findElement(By.xpath("//div[@class='swatch-option color ' and @option-label='"+color+"']")).click();

	}
	public boolean verifyColorFilterApplied(String color)
	{
		List<WebElement> color1 = driver.findElements(highlightedColor);
		isColorFiltered =true;
		for(WebElement check :color1 )
		{
			if(!check.getAttribute("aria-label").contains(color))
			{
				isColorFiltered =false;
				break;
			}
			else 
			{
				System.out.println("Filter is applied and colour is : "+color);

			}

		}
		return isColorFiltered;
	}
	public void selectPatternFilter() {
		driver.findElement(patternFilter).click();
	}
	public void selectAnPattern(String pattern) {
		driver.findElement(By.xpath("//a[contains(text(),'"+pattern+"')]")).click();

	}
	public boolean verifyPatternFilterIsApplied(String pattern)
	{
		List<WebElement> product = driver.findElements(products);
		isFilteredByPattern = true;
		int size =product.size();
		for(int i =0;i<size;i++)
		{
			WebElement check = product.get(i);
			boolean clickedSuccessfully =false;
			try{
				check.click();
				clickedSuccessfully = true;
			}
			catch(StaleElementReferenceException s)
			{
				product = driver.findElements(products);
				size =product.size();
				if(i>=size)
				{
					break;
				}
				check = product.get(i);
				try{
					check.click();
					clickedSuccessfully = true;
				}
				catch(Exception e)
				{
					System.out.println("Exception occurred while clicking element: " + e.getMessage());
				}
			}
			if(clickedSuccessfully)
			{
				driver.findElement(moreInfo).click();
				if(!driver.findElement(patternInfo).getText().contains(pattern))
				{
					isFilteredByPattern = false;
					break;
				}
				else {
					driver.navigate().back();			
				}
			}
		}
		return isFilteredByPattern;
	}

	public void selectPriceFilter() 
	{
		driver.findElement(price).click();
	}

	public void selectAnPriceRange(String minPrice, String maxPrice) 
	{
		driver.findElement(By.xpath("//span[contains(text(),'"+minPrice+"')]/following::span[contains(text(),'"+maxPrice+"')]/parent::a")).click();

	}
	public boolean verifyPriceFilterIsApplied(String minPrice, String maxPrice )
	{
		double minimum = Double.parseDouble(minPrice.replace("$", "").trim());
		double maximum = Double.parseDouble(maxPrice.replace("$", "").trim());

		List<WebElement> priceRange = driver.findElements(productPrice);
		filteredByPrice = true;

		for (WebElement check : priceRange) {
			String pricing = check.getText().replace("$", "").trim();
			double price = Double.parseDouble(pricing);

			if (!(price >= minimum && price <= maximum)) {
				filteredByPrice = false;
				break;
			}
		}

		if (filteredByPrice) {
			System.out.println("Filtered by price range is as expected");
		}
		return filteredByPrice;
	}

	public void verifyCombinationOfFilterIsApplied(String minPrice, String maxPrice,String color,String pattern) 
	{
		double minimum = Double.parseDouble(minPrice.replace("$", "").trim());
		double maximum = Double.parseDouble(maxPrice.replace("$", "").trim());

		List<WebElement> priceRange = driver.findElements(productPrice);
		filteredByPrice = true;

		for (WebElement check : priceRange) {
			wait.until(ExpectedConditions.elementToBeClickable(check));
			String pricing = check.getText().replace("$", "").trim();
			double price = Double.parseDouble(pricing);

			if (!(price >= minimum && price <= maximum)) {
				filteredByPrice = false;
				break;
			}
		}

		if (filteredByPrice) {
			System.out.println("Filtered by price range is as expected");
		}
		else
		{
			System.out.println("Filtered by price range is not as expected");
		}

		List<WebElement> color1 = driver.findElements(highlightedColor);
		isColorFiltered =true;
		for(WebElement check :color1 )
		{
			if(!check.getAttribute("aria-label").contains(color))
			{
				isColorFiltered =false;
				break;
			}
			else 
			{
				System.out.println("Filter is applied and colour is : "+color);

			}

		}

		List<WebElement> product = driver.findElements(products);
		isFilteredByPattern = true;
		int size =product.size();
		for(int i =0;i<size;i++)
		{
			WebElement check = product.get(i);
			boolean clickedSuccessfully =false;
			try{
				check.click();
				clickedSuccessfully = true;
			}
			catch(StaleElementReferenceException s)
			{
				product = driver.findElements(products);
				size =product.size();
				if(i>=size)
				{
					break;
				}
				check = product.get(i);
				try{
					check.click();
					clickedSuccessfully = true;
				}
				catch(Exception e)
				{
					System.out.println("Exception occurred while clicking element: " + e.getMessage());
				}
			}
			if(clickedSuccessfully)
			{
				driver.findElement(moreInfo).click();
				if(!driver.findElement(patternInfo).getText().contains(pattern))
				{
					isFilteredByPattern = false;
					break;
				}
				else {
					driver.navigate().back();			
				}
			}
		}
	}}
