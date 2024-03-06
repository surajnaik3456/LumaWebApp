package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.TestBase;

public class LoginPage extends TestBase {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	By signInLink = By.xpath("//a[contains(text(),'Sign In')][1]");
	By loginPge = By.xpath("//span[contains(text(),'Customer Login')]");
	By emailField = By.cssSelector("input[title='Email']");
	By passwordField =By.cssSelector("input[title='Password']");
	By signInBtn = By.xpath("//span[text()='Sign In'][1]");
	By loggedInSuccess = By.xpath("//span[contains(text(),'Welcome')]");

	public boolean loginPgDisplayed(String loginPage)
	{
		return driver.findElement(loginPge).isDisplayed();
	}
	public void enterEmail(String email)
	{
		driver.findElement(emailField).sendKeys(email);
	}
	public void enterPwd(String password)
	{
		driver.findElement(passwordField).sendKeys(password);
	}
	public void clickSignInBtn()
	{
		driver.findElement(signInBtn).click();
	}
	public boolean loginAsUser(String email, String password)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(signInLink));
		driver.findElement(signInLink).click();
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(signInBtn).click();
		return driver.findElement(loggedInSuccess).isDisplayed();
		
	}

}
