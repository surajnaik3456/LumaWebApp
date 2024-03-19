package stepDefinition;

import org.junit.Assert;

import Pages.ProductPage;
import TestBase.TestBase;
import io.cucumber.java.en.*;

public class CheckProductFilter extends TestBase{
	ProductPage productPg = new ProductPage();

	@And("^User selects category filter as (.*)$")
	public void user_selects_category_filter_as(String category) {
		productPg.selectsCategoryFilter();
		productPg.selectsAnCategory(category);

	}
	@And("^Verifies if the category filter for (.*) is applied correctly$")
	public void verifies_if_the_filter_is_applied_correctly(String category)  {

		productPg.verifyCategoryFilterIsApplied(category);
		Assert.assertTrue(ProductPage.isFiltered);
	}
	@And ("^User selects color filter as (.*)$")
	public void user_selects_color_filter(String color)
	{
		productPg.selectColorFilter();
		productPg.selectAnColor(color);
	}

	@And ("^Verifies if the category filter for (.*) is applied and is highlighted$")
	public void verifies_if_color_filter_is_applied_correctly(String color)  {

		productPg.verifyColorFilterApplied(color);
		Assert.assertTrue(ProductPage.isColorFiltered);
	}
	@And ("^User selects pattern filter as (.*)$")
	public void user_selects_pattern_filter(String pattern)
	{
		productPg.selectPatternFilter();
		productPg.selectAnPattern(pattern);
	}

	@And ("^Verifies if the pattern filter for (.*) is applied correctly$")
	public void verifies_if_pattern_filter_is_applied_correctly(String pattern)  {

		productPg.verifyPatternFilterIsApplied(pattern);
		Assert.assertTrue(ProductPage.isFilteredByPattern);
	}

	@And("^Selects the price filter with (.*) and (.*) range$")
	public void selects_the_price_filter_with_and_range(String minPrice, String maxPrice) {
		productPg.selectPriceFilter();
		productPg.selectAnPriceRange(minPrice,maxPrice);

	}


	@And("^Verifies if the price filter for (.*) and (.*) is applied correctly$")
	public void verifies_if_price_filter_is_applied_correctly(String minPrice, String maxPrice) {
		productPg.verifyPriceFilterIsApplied(minPrice, maxPrice);
		Assert.assertTrue(ProductPage.filteredByPrice);
	}

	@And("^Selects filter by price range (.*) to (.*), (.*) and (.*)$")
	public void selects_filter_by_combination(String minPrice, String maxPrice,String color,String pattern) {
		productPg.selectPriceFilter();
		productPg.selectAnPriceRange(minPrice, maxPrice);
		productPg.selectColorFilter();
		productPg.selectAnColor(color);
		productPg.selectPatternFilter();
		productPg.selectAnPattern(pattern);
	}
	@And("^Verifies if the combination of filter for (.*) to (.*), (.*) and (.*) is applied correctly$")
	public void verifies_if_the_combination_of_filter_is_applied_correctly(String minPrice, String maxPrice,String color,String pattern) {
		productPg.verifyCombinationOfFilterIsApplied(minPrice, maxPrice, color, pattern);
		Assert.assertTrue(ProductPage.filteredByPrice);
		System.out.println(ProductPage.filteredByPrice);
		Assert.assertTrue(ProductPage.isColorFiltered);
		System.out.println(ProductPage.isColorFiltered);
		Assert.assertTrue(ProductPage.isFilteredByPattern);
		System.out.println(ProductPage.isFilteredByPattern);
	}



}
