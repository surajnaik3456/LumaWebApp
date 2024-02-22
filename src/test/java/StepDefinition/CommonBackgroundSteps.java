package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.HomePage;
import Pages.LoginPage;
import TestBase.TestBase;
import io.cucumber.java.en.*;

public class CommonBackgroundSteps extends TestBase {
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	HomePage homePg = new HomePage();
	LoginPage loginPg = new LoginPage();
	
	@Given("User is on the home page")
	public void user_is_on_the_home_page() {
	    homePg.verifyLogo();
	}
	
	@And("the page title is {string}")
	public void the_page_title_is(String title) {
	    driver.getTitle().equalsIgnoreCase(title);
	}
	
	@And("User clicks on the header sign-in link")
	public void user_clicks_on_the_header_sign_in_link() {
		homePg.clickSignIn();
	}
	@And("{string} page is displayed")
	public void page_displayed(String loginPage) {
		loginPg.loginPgDisplayed(loginPage);   
	}
	@When("User enters the email address {string} and password {string}")
	public void user_enters_the_email_address_and_password(String email, String password) {
		loginPg.enterEmail(email);
		loginPg.enterPwd(password);
	   
	}
	@When("User clicks on the sign-in button")
	public void user_clicks_on_the_sign_in_button() {
		loginPg.clickSignInBtn();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.action.more.button")));
	}
	@Then("User should be logged in")
	public void user_should_be_logged_in() {
		driver.getTitle().equalsIgnoreCase("Home Page");
	}
}
