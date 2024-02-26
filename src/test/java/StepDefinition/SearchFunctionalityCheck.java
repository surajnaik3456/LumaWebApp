package StepDefinition;

import java.time.Duration;

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
	@When("Suggestions appears with {string} as initials")
	public void suggestions_appears_with_tshirt_as_initials(String initial)  {
		homePg.checkSuggestionWithInitial(initial);

	}
	@When("User selects {string}")
	public void user_selects(String selectSuggestion) {
		homePg.selectsOption(selectSuggestion);
	}
	@Then("Search results page for {string} appears")
	public void search_results_page_for_appears(String resultPageDisplayed) {
		homePg.checkResultsForSelectedOptionPageDisplayed(resultPageDisplayed);

	}

	@And("Checks if the SKU value for all the resulted product starts with {string}")
	public void checks_if_the_sku_value_starts_with(String string)   {
		homePg.checkSkuNumber();
	}




}
