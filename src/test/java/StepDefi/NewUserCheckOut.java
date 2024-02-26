package StepDefi;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.CreateAccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import TestBase.TestBase;
import io.cucumber.java.en.*;

public class NewUserCheckOut extends TestBase{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	HomePage homePg = new HomePage();
	LoginPage loginPg = new LoginPage();
	CreateAccountPage createAcnt =new CreateAccountPage();
	

	@Given("User clicks on the header create an account link")
	public void user_clicks_on_the_header_create_an_account_link() {
		createAcnt.clickCreateAccountLink();
	}
	@And("Create New Customer Account page is displayed")
	public void create_new_customer_account_page_is_displayed() {
		createAcnt.createAccountPgDisplays();
	}
	@When("^User enters the (.*),(.*),(.*),(.*) and (.*)$")
	public void user_fills_all_the_parameters(String firstname,String lastname,String email,String password,String confirmPassword) {
		createAcnt.enterFirstName(firstname);
		createAcnt.enterLastName(lastname);
		createAcnt.enterEmailId(email);
		createAcnt.enterPassword(password);
		createAcnt.enterConfirmPwd(confirmPassword);
		  
	}
	@When("User clicks on the create account button")
	public void user_clicks_on_the_create_account_button() {
		createAcnt.clickCreateAccountBtn(); 
	}
	@Then("{string} shows up")
	public void shows_up(String RegsuccessMsg) {
		WebElement RegistrationSuccessMsg = driver.findElement(By.xpath("//div[text()='Thank you for registering with Main Website Store.']"));
		Assert.assertEquals("Registration is not successfull", RegistrationSuccessMsg.getText(), RegsuccessMsg);
	    
	}
	@Then("User clicks on Luma logo")
	public void user_clicks_on_luma_logo() {
		homePg.clickLogo();
	}
	@Then("^Select a (.*) method$")
	public void select_a_fixed_method(String shipping) {
		driver.findElement(By.xpath("//td[text()='"+shipping+"']/preceding-sibling::td")).click();
	   
	}



	

}
