package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.TestBase;

public class LoginPage extends TestBase {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	By loginPge = By.xpath("//span[contains(text(),'Customer Login')]");
	By emailField = By.cssSelector("input[title='Email']");
    By passwordField =By.cssSelector("input[title='Password']");
    By signInBtn = By.xpath("//span[text()='Sign In'][1]");
	
	public void loginPgDisplayed(String loginPage)
	{
		driver.findElement(loginPge).getText().equalsIgnoreCase(loginPage);
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

}
