package Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	By checkOutPage = By.xpath("//div[text()='Shipping Address']");
	By newAddress = By.cssSelector("button.action.action-show-popup");
	By shippingAddPopUp = By.cssSelector("h1.modal-title");
	By companyField = By.cssSelector("input[name='company']");
	By streetField = By.cssSelector("input[name='street[0]']");
	By cityField = By.cssSelector("input[name='city']");
	By stateDropdown = By.xpath("//select[@name='region_id']");
	By zipCode = By.cssSelector("input[name='postcode']");
	By countryDropdown = By.xpath("//select[@name='country_id']");
	By phNumb = By.cssSelector("input[name='telephone']");
	By shipHere = By.xpath("//span[text()='Ship here']");
	By nextBtn = By.xpath("//span[text()='Next']");
	By placeOrder = By.xpath("//span[text()='Place Order']");
	By orderNumb = By.cssSelector("a.order-number");
	By paymentPg = By.xpath("//div[text()='Payment Method']");
	By sortDropdown = By.cssSelector("select#sorter");
	By searchField = By.cssSelector("input#search");
	By hotSellersSection = By.xpath("//h2[text()='Hot Sellers']");
	By actionCompare = By.cssSelector("a.action.compare");
	By myAccountMenu = By.cssSelector("button.action.switch");
	By myAccount = By.xpath("//a[text()='My Account']");
	By myAccountPg = By.cssSelector("h1.page-title");
	By myOrder = By.xpath("//a[text()='My Orders']");
	By myOrderPg = By.xpath("//span[text()='My Orders']");
	
	
	//Variables used for product comparison
	List<String> firstProduct = new ArrayList<String>();
	List<String> secoundProduct = new ArrayList<String>();
	List<String> firstProductInComparePage = new ArrayList<String>();
	List<String> secoundProductInComparePage = new ArrayList<String>();
	public static List<String> productDetail = new ArrayList<String>();
	List<String> productDetailsInOrderPg = new ArrayList<String>();
	
	
	public void clickLogo()
    {
    	driver.findElement(logo).click();
    }
	public void verifyLogo()
	{
		if(driver.findElement(logo).isDisplayed())
		{
			System.out.println("User is on Luma website");
		}
		else
		{
			System.out.println("User is not on Luma website");
		}
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
    public void yogaCollectionPgDisplayed(String pageDisplayed)
    {
    	driver.findElement(yogaCollectionPg).getText().equalsIgnoreCase(pageDisplayed);
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
    public void added()
    {
    	wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//span[text()='Added']"))));
    	driver.findElement(By.xpath("//span[text()='Added']")).isDisplayed();
    	
    }
    public void scrollToCart()
    {
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].scrollIntoView();", driver.findElement(cart));
    }
    public void clickCart()
    {
    	//wait.until(ExpectedConditions.elementToBeClickable(cartCount));
    	driver.findElement(cart).click();
    }
    public void clickCheckOutBtn()
    {
    	driver.findElement(checkoutBtn).click();
    }
    public void checkOutPageDisplayed()
    {
    	driver.findElement(checkOutPage).getText().equalsIgnoreCase("Shipping Address");
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
    }
    public void clickNewAddressBtn() throws InterruptedException
    {
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
    	Thread.sleep(2000);
    	driver.findElement(newAddress).click();
    }
public void shipingAdPopUpShowsUp()
{
	if(driver.findElement(shippingAddPopUp).isDisplayed())
	{
		System.out.println("shipping address pop up is not appears");
	}
	else
	{
		System.out.println("Pop up is not appearing");
	}
}
public void enterCompanyName(String company)
{
	driver.findElement(companyField).sendKeys(company);
}
public void enterStreetName(String streetAddress)
{
	wait.until(ExpectedConditions.visibilityOfElementLocated(streetField));
	driver.findElement(streetField).sendKeys(streetAddress);
}
public void enterCityName(String city)
{
	driver.findElement(cityField).sendKeys(city);
}
public void selectState(String state)
{
	wait.until(ExpectedConditions.visibilityOfElementLocated(stateDropdown));
	WebElement stateSelect = driver.findElement(stateDropdown);
	Select state1 =new Select (stateSelect);
	state1.selectByVisibleText(state);
}
public void enterZipCode(String zip)
{
	driver.findElement(zipCode).sendKeys(zip);
}
public void selectCountry(String country)
{
	WebElement countrySelect = driver.findElement(countryDropdown);
	Select country1 =new Select (countrySelect);
	country1.selectByVisibleText(country);
	WebElement countrySelect1 = driver.findElement(countryDropdown);
	Select country2 =new Select (countrySelect1);
	country2.selectByVisibleText(country);
}

public void enterPhnNumb(String phoneNumber)
{
	driver.findElement(phNumb).sendKeys(phoneNumber);
}
public void clickShipHere()
{
	driver.findElement(shipHere).click();
}
public void selectShippingMethod()
{
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Flat Rate']/preceding-sibling::td")));
	driver.findElement(By.xpath("//td[text()='Flat Rate']/preceding-sibling::td")).click();
}
public void clickNextBtn()
{
	//wait.until(ExpectedConditions.visibilityOfElementLocated(nextBtn));
	driver.findElement(nextBtn).click();
}
public void clickPlaceOrderBtn() throws InterruptedException
{
	Thread.sleep(3000);
	//wait.until(ExpectedConditions.elementToBeClickable(placeOrder));
	driver.findElement(placeOrder).click();
}
public void orderPlacedNumb()
{
	
	driver.findElement(orderNumb).getText();
}
public void paymentPageDisplayed()
{
	driver.findElement(paymentPg).isDisplayed();
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
	String price1 = null;
	String price2 = null;
	List<WebElement> afterFilter = driver.findElements(By.xpath("//span[@class='price']"));
	boolean isSorted = true;
	for (int i = 0; i < afterFilter.size(); i++) {
	   // System.out.println(afterFilter.get(i).getText().replace("$", "").trim());
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
	Assert.assertEquals(price2, price1);
}
public void sortingByProductName()
{
	try {
		Thread.sleep(4000);
	} catch (InterruptedException e) {
	
		e.printStackTrace();
	}
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
	List<WebElement> suggestion = driver.findElements(By.xpath("//li[@role='option']"));
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
public void checkResultsForSelectedOptionPageDisplayed(String resultPageDisplayed)
{
	boolean expectedResultPage =true;
	if(!driver.findElement(By.cssSelector("span.base")).getText().contains(resultPageDisplayed))
	{
		expectedResultPage=false;
	}
	Assert.assertTrue("Expected result page is not displayed ", expectedResultPage);
}
public void captureOrderNo()
{
	WebElement orderNumber = driver.findElement(orderNumb);
	System.out.println(orderNumber.getText());
}
public void checkSkuNumber() 
{
	List<WebElement> resultedProducts = driver.findElements(By.cssSelector("a.product-item-link"));
	boolean expectedSku =true;
	for(WebElement check:resultedProducts)
	{
		wait.until(ExpectedConditions.elementToBeClickable(check)).click();
		
		if(!driver.findElement(By.xpath("//div[@itemprop='sku']")).getText().startsWith("M"))
		{
			expectedSku = false;
			break;
		}
		else
		{
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
public void verifyFirstProductAddedSuccessMsg(String product1)
{
	if(driver.findElement(By.xpath("//div[text()='You added product "+product1+" to the ']")).isDisplayed())
	{
		System.out.println("Product one added succesfully..");
	}
	else
	{
		System.out.println("Product is not getting added to compare list..");
	}
}
public void addSecondProductToCompare(String product2)
{
	Actions actions = new Actions(driver);
	WebElement productHover = driver.findElement(By.xpath("//a[@title='"+product2+"']"));
	actions.moveToElement(productHover).perform();
	driver.findElement(By.xpath("//a[@title='"+product2+"']/following::a[@class='action tocompare'][1]")).click();
}
public void verifySecondProductAddedSuccessMsg(String product2)
{
	if(driver.findElement(By.xpath("//div[text()='You added product "+product2+" to the ']")).isDisplayed())
	{
		System.out.println("Secound Product added succesfully..");
	}
	else
	{
		System.out.println("Product is not getting added to compare list..");
	}
}
public void clickCompareProduct()
{
	driver.findElement(actionCompare).click();
}
public void verifyComparePageDisplays(String comparePgDisplayed)
{
	WebElement comparePg = driver.findElement(By.xpath("//span[text()='Compare Products']"));
	Assert.assertEquals(comparePg.getText(), comparePgDisplayed);
}

public void verifyProductsAddedToComparePgAreTheSameProducts(String product1, String product2)
{
	driver.navigate().back();
	driver.findElement(By.xpath("//a[@title='"+product1+"']")).click();

	firstProduct.add(driver.findElement(By.cssSelector("div[itemprop='sku']")).getText());
	firstProduct.add(driver.findElement(By.xpath("//span[text()='"+product1+"']")).getText());
	firstProduct.add(driver.findElement(By.xpath("//div[@class='product attribute description']//following::p[1]")).getText());
	System.out.println(firstProduct);
	driver.navigate().back();
	driver.findElement(By.xpath("//a[@title='"+product2+"']")).click();
	
	secoundProduct.add(driver.findElement(By.cssSelector("div[itemprop='sku']")).getText());
	secoundProduct.add(driver.findElement(By.xpath("//span[text()='"+product2+"']")).getText());
	secoundProduct.add(driver.findElement(By.xpath("//div[@class='product attribute description']//following::p[1]")).getText());
	System.out.println(secoundProduct);
	driver.navigate().back();
	driver.findElement(actionCompare).click();
	
	firstProductInComparePage.add(driver.findElement(By.xpath("//tr/following::td[3]")).getText());
	firstProductInComparePage.add(driver.findElement(By.xpath("//a[contains(text(),'"+product1+"')]")).getText());
	firstProductInComparePage.add(driver.findElement(By.xpath("//tr/following::td[5]/div/p[1]")).getText());
	System.out.println(firstProductInComparePage);
	
	secoundProductInComparePage.add(driver.findElement(By.xpath("//tr/following::td[4]")).getText());
	secoundProductInComparePage.add(driver.findElement(By.xpath("//a[contains(text(),'"+product2+"')]")).getText());
	secoundProductInComparePage.add(driver.findElement(By.xpath("//tr/following::td[6]/div/p[1]")).getText());
	System.out.println(secoundProductInComparePage);
	
	Assert.assertEquals(firstProduct, firstProductInComparePage);
	Assert.assertEquals(secoundProduct, secoundProductInComparePage);
}
public void captureDetails()
{
	productDetail.add(driver.findElement(By.xpath("//span[@itemprop='name']")).getText());
	productDetail.add(driver.findElement(By.xpath("//div[@itemprop='sku']")).getText());
	productDetail.add(driver.findElement(By.xpath("//input[@value='1']")).getAttribute("value"));
	System.out.println(	productDetail);
}
public void captureDetails2()
{
	productDetail.add(driver.findElement(By.xpath("//span[@data-bind='text: getTitle()']")).getText());
	productDetail.add(driver.findElement(By.xpath("//span[@data-th='Cart Subtotal']")).getText().replace("$", "").trim());
	//productDetails.add(driver.findElement(By.cssSelector("div.shipping-information-content")).getText());
	
}

public void captureOrderNumber()
{
	productDetail.add(driver.findElement(By.cssSelector("a.order-number")).getText());
	System.out.println(	productDetail);
}
public void clickMyAccountMenu()
{
	driver.findElement(myAccountMenu).click();
	
}
public void selectFromMenu()
{
	driver.findElement(myAccount).click();
	
}
public void myAccountPageDisplayed()
{
	if(driver.findElement(myAccountPg).isDisplayed())
	{
		System.out.println("My Account page is displayed");
	}
	else
	{
		System.out.println("My Account page is not displayed");	
	}
}
public void clickMyOrders()
{
	driver.findElement(myOrder).click();
}
public void myOrderPgDisplayed()
{
	WebElement pg = driver.findElement(myOrderPg);
	Assert.assertEquals(pg.getText(), "My Orders");
	
}
public void clickViewOrderForOrderNo()
{
	driver.findElement(By.xpath("//td//following::td[5]/a[@class='action view'][1]")).click();
	
}
public void verifyDetails()
{

	WebElement productNm = driver.findElement(By.cssSelector("strong.product.name.product-item-name"));
	WebElement sku = driver.findElement(By.cssSelector("td.col.sku"));
	WebElement qty = driver.findElement(By.cssSelector("span.content"));
	WebElement paymentMethod = driver.findElement(By.cssSelector("dl.payment-method.checkmemo"));
	WebElement subTotalPrice = driver.findElement(By.xpath("//span[@class='cart-price'][1]"));
	WebElement productOrderNo = driver.findElement(By.xpath("//span[@data-ui-id='page-title-wrapper']"));
	System.out.println(productDetail);
	productDetailsInOrderPg.add(productNm.getText());
	productDetailsInOrderPg.add(sku.getText().substring(0, 5));
	productDetailsInOrderPg.add(qty.getText());
	productDetailsInOrderPg.add(paymentMethod.getText());
	productDetailsInOrderPg.add(subTotalPrice.getText().replace("$", "").trim());
	productDetailsInOrderPg.add(productOrderNo.getText().replaceAll("\\D", "").trim());
	System.out.println(productDetailsInOrderPg);
	Assert.assertEquals(productDetail, productDetailsInOrderPg);
}
}
