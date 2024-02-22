package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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
	wait.until(ExpectedConditions.visibilityOfElementLocated(nextBtn));
	driver.findElement(nextBtn).click();
}
public void clickPlaceOrderBtn()
{
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
}
