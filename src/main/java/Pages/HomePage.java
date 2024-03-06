package Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.TestBase;

public class HomePage extends TestBase{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	By logo = By.cssSelector("a[class='logo']");
	By signInLink = By.xpath("//a[contains(text(),'Sign In')][1]");
	By shopNewYogaBtn = By.cssSelector("span.action.more.button");
	By yogaCollectionPg = By.xpath("//span[text()='New Luma Yoga Collection']");
	By addToCart = By.xpath("//span[text()='Add to Cart']");
	By cartCount = By.xpath("//span[text()='1']");
	By cart = By.cssSelector("a.action.showcart");
	By checkoutBtn = By.cssSelector("button#top-cart-btn-checkout");
	By placeOrder = By.xpath("//span[text()='Place Order']");
	By sortDropdown = By.cssSelector("select#sorter");
	By searchField = By.cssSelector("input#search");
	By hotSellersSection = By.xpath("//h2[text()='Hot Sellers']");
	By actionCompare = By.cssSelector("a.action.compare");
	By resultPgProducts = By.cssSelector("a.product-item-link");
	By suggestionFrameWebElements = By.xpath("//li[@role='option']");
	By searchResultPg = By.cssSelector("span.base");
	By myAccountMenu = By.cssSelector("button.action.switch");
	By myAccount = By.xpath("//a[text()='My Account']");
	By productName = By.xpath("//span[@itemprop='name']");
	By productSku = By.xpath("//div[@itemprop='sku']");
	By productQty = By.xpath("//input[@value='1']");
	By productPaymentMthd = By.xpath("//span[@data-bind='text: getTitle()']");
	By productSubTotal = By.xpath("//span[@data-th='Cart Subtotal']");
	By btnTxtChangesToAdded = By.xpath("//span[text()='Added']");
	By resultPage = By.cssSelector("span.base");
	By priceElement = By.xpath("//span[@class='price']");
	By productItems = By.xpath("//a[@class='product-item-link']");

	public static String price1=null;
	public static String price2=null;
	public static List<String> store1 = new ArrayList<String>();
	public static List<String> store2 = new ArrayList<String>();

	public static List<String> productDetail = new ArrayList<String>();


	public void clickLogo()
	{
		driver.findElement(logo).click();
	}
	public boolean verifyLogo()
	{
		return driver.findElement(logo).isDisplayed();

	}
	public void clickSignIn()
	{
		driver.findElement(signInLink).click();
	}
	public void shopNewYogaBtnClick()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(shopNewYogaBtn));
		driver.findElement(shopNewYogaBtn).click();
	}
	public boolean yogaCollectionPgDisplayed(String pageDisplayed)
	{
		return driver.findElement(yogaCollectionPg).getText().equals(pageDisplayed);
	}
	public void selectItem(String yogaPant)
	{
		driver.findElement(By.xpath("//a[contains(text(),'"+yogaPant+"')]")).click();
	}
	public void selectedItemPgDisplayed(String yogaPant)
	{
		driver.findElement(By.xpath("//span[contains(text(),'"+yogaPant+"')]")).isDisplayed();
	}
	public void selectSize(String size)
	{
		driver.findElement(By.xpath("//div[@option-label='"+size+"']")).click();
	}
	public void selectColour(String colour)
	{
		driver.findElement(By.xpath("//div[@option-label='"+colour+"']")).click();
	}
	public void clickAddCart()
	{
		driver.findElement(addToCart).click();
	}
	public boolean btnTextChangesToAdded()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(btnTxtChangesToAdded));
		return driver.findElement(btnTxtChangesToAdded).isDisplayed();

	}
	public void scrollToCart()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(cart));
	}
	public void clickCart()
	{
		wait.until(ExpectedConditions.elementToBeClickable(cartCount));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		driver.findElement(cart).click();
	}
	public void clickCheckOutBtn()
	{
		driver.findElement(checkoutBtn).click();
	}
	public void clickPlaceOrderBtn() 
	{
		wait.until(ExpectedConditions.elementToBeClickable(placeOrder));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		driver.findElement(placeOrder).click();
	}

	public void clickDropdown()
	{
		driver.findElement(sortDropdown).click();
	}
	public void selectSortByPrice()
	{
		WebElement sortDropdownSelect = driver.findElement(sortDropdown);
		Select sc = new Select(sortDropdownSelect);
		sc.selectByValue("price");
	}
	public void sortingByPrice() 
	{

		List<WebElement> afterFilter = driver.findElements(priceElement);
		boolean isSorted = true;
		for (int i = 0; i < afterFilter.size(); i++) {
			price1 = afterFilter.get(i).getText().replace("$", "").trim();
			price2 = afterFilter.get(i + 1).getText().replace("$", "").trim();

			if (Double.parseDouble(price1) > Double.parseDouble(price2)) {
				isSorted = false;
				break;
			} else if (Double.parseDouble(price1) == Double.parseDouble(price2)) {
				continue; 
			}
		}
		if (isSorted) {
			System.out.println("Products are sorted by price (low to high).");
		} else {
			System.out.println("Products are not sorted by price (low to high).");
		}
		System.out.println(price1);
		System.out.println(price2);
	}
	public void sortingByProductName()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		List<String> store1 = new ArrayList<String>();
		List<WebElement> Sort1= driver.findElements(productItems);

		for(WebElement store:Sort1)
		{
			String data1 = store.getText();
			store1.add(data1);
		}

		List<String> store2 = new ArrayList<String>();
		List<WebElement> Sort2= driver.findElements(productItems);

		for(WebElement stor:Sort2)
		{
			String data2 = stor.getText();
			store2.add(data2);
		}

		Collections.sort(store1);
		System.out.println(store1);
		System.out.println(store2);

	}

	public void selectSortByProductName()
	{
		WebElement sortDropdownSelect = driver.findElement(sortDropdown);
		Select sc = new Select(sortDropdownSelect);
		sc.selectByValue("name");
	}
	public void clickSearchBox()
	{
		driver.findElement(searchField).click();
	}
	public void enterRequiredProductInSearchBox(String name)
	{
		driver.findElement(searchField).sendKeys(name);
	}
	public void checkSuggestionWithInitial(String initial)
	{
		List<WebElement> suggestion = driver.findElements(suggestionFrameWebElements);
		boolean allStartsWithInitial =true;
		for(WebElement suggested : suggestion )
		{
			if (!suggested.getText().startsWith(initial))
			{
				allStartsWithInitial =false;
				break;
			}
		}
		Assert.assertTrue("All suggestions start with the initial: " +initial, allStartsWithInitial);
	}
	public void selectsOption(String selectSuggestion)
	{
		driver.findElement(By.xpath("//span[text()='"+selectSuggestion+"']")).click();
	}
	public boolean checkResultsForSelectedOptionPageDisplayed(String resultPageDisplayed)
	{

		return driver.findElement(searchResultPg).getText().contains(resultPageDisplayed);
	}

	public void checkSkuNumber(String category) 
	{
		List<WebElement> resultedProducts = driver.findElements(resultPgProducts);
		boolean expectedSku = true;

		for (int i = 0; i < resultedProducts.size(); i++) {
			WebElement check = resultedProducts.get(i);
			try {
				check.click();
			} catch (StaleElementReferenceException e) {

				System.out.println("StaleElementReferenceException occurred.. Re-finding elements");
				resultedProducts = driver.findElements(resultPgProducts);
				check = resultedProducts.get(i); 
				check.click(); 
			}


			if (!driver.findElement(productSku).getText().startsWith(category)) {
				expectedSku = false;
				break;
			} else {
				driver.navigate().back();
			}

		}
		Assert.assertTrue("The SKU values of the resulted products do not start with 'M'", expectedSku);
	}
	public void scrollToHotSellerSection()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement hotSeller = driver.findElement(hotSellersSection);
		js.executeScript("arguments[0].scrollIntoView();", hotSeller);
	}
	public void addFirstProductToCompare(String product1)
	{
		Actions actions = new Actions(driver);
		WebElement productHover = driver.findElement(By.xpath("//a[@title='"+product1+"']"));
		actions.moveToElement(productHover).perform();
		driver.findElement(By.xpath("//a[@title='"+product1+"']/following::a[@class='action tocompare'][1]")).click();
	}
	public boolean verifyFirstProductAddedSuccessMsg(String product1)
	{
		return driver.findElement(By.xpath("//div[text()='You added product "+product1+" to the ']")).isDisplayed();
	}
	public void addSecondProductToCompare(String product2)
	{
		Actions actions = new Actions(driver);
		WebElement productHover = driver.findElement(By.xpath("//a[@title='"+product2+"']"));
		actions.moveToElement(productHover).perform();
		driver.findElement(By.xpath("//a[@title='"+product2+"']/following::a[@class='action tocompare'][1]")).click();
	}
	public boolean verifySecondProductAddedSuccessMsg(String product2)
	{
		return driver.findElement(By.xpath("//div[text()='You added product "+product2+" to the ']")).isDisplayed();
	}
	public void clickCompareProduct()
	{
		driver.findElement(actionCompare).click();
	}

	public void captureDetails()
	{
		productDetail.add(driver.findElement(productName).getText());
		productDetail.add(driver.findElement(productSku).getText());
		productDetail.add(driver.findElement(productQty).getAttribute("value"));
		System.out.println(	productDetail);
	}
	public void captureDetails2()
	{
		productDetail.add(driver.findElement(productPaymentMthd).getText());
		productDetail.add(driver.findElement(productSubTotal).getText().replace("$", "").trim());
		System.out.println(productDetail);
	}

	public void clickMyAccountMenu()
	{
		driver.findElement(myAccountMenu).click();

	}
	public void selectFromMenu()
	{
		driver.findElement(myAccount).click();

	}

}
