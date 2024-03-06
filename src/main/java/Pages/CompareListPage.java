package Pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import TestBase.TestBase;

public class CompareListPage extends TestBase {

	By productSkuNumb = By.cssSelector("div[itemprop='sku']");
	By productDescription = By.xpath("//div[@class='product attribute description']//following::p[1]");
	By firstProductSkuNumbInComparePg = By.xpath("//tr/following::td[3]");
	By firstProductDescriptionInComparePg = By.xpath("//tr/following::td[5]/div/p[1]");
	By secondProductSkuNumbInComparePg = By.xpath("//tr/following::td[4]");
	By secondtProductDescriptionInComparePg = By.xpath("//tr/following::td[6]/div/p[1]");
	By actionCompare = By.cssSelector("a.action.compare");
	By productCompareListPage = By.xpath("//span[text()='Compare Products']");


	public static List<String> firstProduct = new ArrayList<String>();
	public static List<String> secoundProduct = new ArrayList<String>();
	public static List<String> firstProductInComparePage = new ArrayList<String>();
	public static List<String> secoundProductInComparePage = new ArrayList<String>();

	public boolean verifyComparePageDisplays(String comparePgDisplayed)
	{
		WebElement comparePg = driver.findElement(productCompareListPage);
		return comparePg.isDisplayed();
	}

	public void verifyProductsAddedToComparePgAreTheSameProducts(String product1, String product2)
	{
		driver.navigate().back();
		driver.findElement(By.xpath("//a[@title='"+product1+"']")).click();

		firstProduct.add(driver.findElement(productSkuNumb).getText());
		firstProduct.add(driver.findElement(By.xpath("//span[text()='"+product1+"']")).getText());
		firstProduct.add(driver.findElement(productDescription).getText());
		System.out.println(firstProduct);
		driver.navigate().back();
		driver.findElement(By.xpath("//a[@title='"+product2+"']")).click();

		secoundProduct.add(driver.findElement(productSkuNumb).getText());
		secoundProduct.add(driver.findElement(By.xpath("//span[text()='"+product2+"']")).getText());
		secoundProduct.add(driver.findElement(productDescription).getText());
		System.out.println(secoundProduct);
		driver.navigate().back();
		driver.findElement(actionCompare).click();

		firstProductInComparePage.add(driver.findElement(firstProductSkuNumbInComparePg).getText());
		firstProductInComparePage.add(driver.findElement(By.xpath("//a[contains(text(),'"+product1+"')]")).getText());
		firstProductInComparePage.add(driver.findElement(firstProductDescriptionInComparePg).getText());
		System.out.println(firstProductInComparePage);

		secoundProductInComparePage.add(driver.findElement(secondProductSkuNumbInComparePg).getText());
		secoundProductInComparePage.add(driver.findElement(By.xpath("//a[contains(text(),'"+product2+"')]")).getText());
		secoundProductInComparePage.add(driver.findElement(secondtProductDescriptionInComparePg).getText());
		System.out.println(secoundProductInComparePage);

	}

}
