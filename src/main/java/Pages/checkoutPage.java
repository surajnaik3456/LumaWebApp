package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.TestBase;
import java.time.Duration;

public class checkoutPage extends TestBase {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	By checkOutPage = By.xpath("//div[text()='Shipping Address']");
	By newAddress = By.cssSelector("button.action.action-show-popup");
	By shippingAddPopUp = By.xpath("//h1[contains(text(),'Shipping Address')]");
	By companyField = By.cssSelector("input[name='company']");
	By streetField = By.cssSelector("input[name='street[0]']");
	By cityField = By.cssSelector("input[name='city']");
	By stateDropdown = By.xpath("//select[@name='region_id']");
	By zipCode = By.cssSelector("input[name='postcode']");
	By countryDropdown = By.xpath("//select[@name='country_id']");
	By phNumb = By.cssSelector("input[name='telephone']");
	By shipHere = By.xpath("//span[text()='Ship here']");
	By nextBtn = By.xpath("//button[@data-role='opc-continue' and @type ='submit']");
	By placeOrder = By.xpath("//span[text()='Place Order']");
	By orderNumb = By.cssSelector("a.order-number");
	By paymentPg = By.xpath("//div[text()='Payment Method']");
	//
	
	
	public boolean checkOutPageDisplayed()
    {
		return driver.findElement(checkOutPage).isDisplayed();
    	
    }	
    public void clickNewAddressBtn() 
    {
    	WebElement newAddressElement = null;
    	try {
             newAddressElement = wait.until(ExpectedConditions.elementToBeClickable(newAddress));
            newAddressElement.click();
        } catch (ElementClickInterceptedException e) {
			newAddressElement.click();
        }
    }
public boolean shipingAdPopUpShowsUp()
{
	wait.until(ExpectedConditions.visibilityOfElementLocated(shippingAddPopUp));
	return driver.findElement(shippingAddPopUp).isDisplayed();
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
public void selectShippingMethod(String shipping )
{
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='"+shipping+"']/preceding-sibling::td")));
	try{
		driver.findElement(By.xpath("//td[text()='"+shipping+"']/preceding-sibling::td")).click();
	}
	catch(StaleElementReferenceException s)
	{
		driver.findElement(By.xpath("//td[text()='"+shipping+"']/preceding-sibling::td")).click();	
	}
}
public void clickNextBtn()
{
	JavascriptExecutor scroll = (JavascriptExecutor)driver;
	scroll.executeScript("arguments[0].scrollIntoView();",driver.findElement(nextBtn));
	wait.until(ExpectedConditions.visibilityOfElementLocated(nextBtn));
	driver.findElement(nextBtn).click();
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
