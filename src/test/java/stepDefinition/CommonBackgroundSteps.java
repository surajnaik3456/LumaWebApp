package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.HomePage;
import Pages.LoginPage;
import TestBase.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Duration;

public class CommonBackgroundSteps extends TestBase {
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	HomePage homePg = new HomePage();
	LoginPage loginPg = new LoginPage();
	
	@Given("User is on the home page")
	public void user_is_on_the_home_page() {
	    Assert.assertTrue("Homepage is been displayed", homePg.verifyLogo());
	    System.out.print("logo verified..");
	}
	
	@And("the page title is {string}")
	public void the_page_title_is(String title) {
	  Assert.assertEquals("Page title is not Home page", driver.getTitle(), title);
	}
	
	@And("User clicks on the header sign-in link")
	public void user_clicks_on_the_header_sign_in_link() {
		homePg.clickSignIn();
	}
	@And("{string} page is displayed")
	public void page_displayed(String loginPage) {
		Assert.assertTrue("Page is not displayed", loginPg.loginPgDisplayed(loginPage));
		
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
		Assert.assertEquals("User is not logged in...", driver.getTitle(), "Home Page");
	}
}
