package Pages;

import org.openqa.selenium.By;

import TestBase.TestBase;

public class CreateAccountPage extends TestBase{
	By createAccount = By.xpath("//a[text()='Create an Account']");
	By createAccountPg = By.xpath("//span[text()='Create New Customer Account']");
	By firstNameField = By.cssSelector("input#firstname");
	By lastNameField = By.cssSelector("input#lastname");
	By emailField = By.cssSelector("input#email_address");
	By pwd = By.cssSelector("input#password");
	By pwdConfirm = By.cssSelector("input#password-confirmation");
	By createAccountBtn = By.xpath("//span[text()='Create an Account']");
	
	
	
	public void clickCreateAccountLink()
	{
		driver.findElement(createAccount).click();
	}
	public void enterFirstName(String firstname)
	{
		driver.findElement(firstNameField).sendKeys(firstname);
	}
	public void enterLastName(String lastname)
	{
		driver.findElement(lastNameField).sendKeys(lastname);
	}
	public void enterEmailId(String email)
	{
		driver.findElement(emailField).sendKeys(email);
	}
	public void enterPassword(String password)
	{
		driver.findElement(pwd).sendKeys(password);
	}
	public void enterConfirmPwd(String confirmPassword)
	{
		driver.findElement(pwdConfirm).sendKeys(confirmPassword);
	}
	public void clickCreateAccountBtn()
	{
		driver.findElement(createAccountBtn).click();
	}
}
