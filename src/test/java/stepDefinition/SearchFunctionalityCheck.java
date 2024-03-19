package stepDefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.HomePage;
import Pages.LoginPage;
import TestBase.TestBase;
import io.cucumber.java.en.*;

public class SearchFunctionalityCheck extends TestBase{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	HomePage homePg = new HomePage();
	LoginPage loginPg = new LoginPage();

	@When("User clicks on search bar")
	public void user_clicks_on_search_bar() {
		homePg.clickSearchBox();

	}
	@And("^Enter required product (.*)$")
	public void enter_required_product_tshirt(String name)  {
		homePg.enterRequiredProductInSearchBox(name);
	}
	@Then("^Suggestions appears with (.*) as initials$")
	public void suggestions_appears_with_tshirt_as_initials(String name)  {
		homePg.checkSuggestionWithInitial(name);
		Assert.assertTrue(HomePage.startsWithInitial);

	}
	@And("User selects {string}")
	public void user_selects(String selectSuggestion) {
		homePg.selectsOption(selectSuggestion);
	}
	@Then("Search results page for {string} appears")
	public void search_results_page_for_appears(String resultPageDisplayed) {
		Assert.assertTrue("Result page is not displayed", homePg.checkResultsForSelectedOptionPageDisplayed(resultPageDisplayed));

	}

	@And("Checks if the SKU value for all the resulted product starts with {string}")
	public void checks_if_the_sku_value_starts_with(String category)   {
		homePg.checkSkuNumber(category);
		Assert.assertTrue(HomePage.expectedSku);
	}




}
