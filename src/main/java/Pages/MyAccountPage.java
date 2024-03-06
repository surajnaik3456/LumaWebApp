package Pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import TestBase.TestBase;

public class MyAccountPage extends TestBase{
	By myAccountPg = By.cssSelector("h1.page-title");
	By myOrder = By.xpath("//a[text()='My Orders']");
	By myOrderPg = By.xpath("//span[text()='My Orders']");
	By recentOrderNoViewOrder = By.xpath("//td//following::td[5]/a[@class='action view'][1]");
	By productNameInOrderPg = By.cssSelector("strong.product.name.product-item-name");
	By skuNoInOrderPg = By.cssSelector("td.col.sku");
	By productQuantityInOrderPg = By.cssSelector("span.content");
	By productPaymentMthdInOrderPg = By.cssSelector("dl.payment-method.checkmemo");
	By subTotalPriceInOrderPg = By.xpath("//span[@class='cart-price'][1]");
	By productOrderNoInOrderPg = By.xpath("//span[@data-ui-id='page-title-wrapper']");


	public static List<String> productDetailsInOrderPg = new ArrayList<String>();

	public boolean myAccountPageDisplayed()
	{
		return driver.findElement(myAccountPg).isDisplayed();

	}
	public void clickMyOrders()
	{
		driver.findElement(myOrder).click();
	}
	public boolean myOrderPgDisplayed()
	{
		WebElement pg = driver.findElement(myOrderPg);
		return pg.isDisplayed();

	}
	public void clickViewOrderForOrderNo()
	{
		driver.findElement(recentOrderNoViewOrder).click();

	}
	public void verifyDetails()
	{
		WebElement productNm = driver.findElement(productNameInOrderPg);
		WebElement sku = driver.findElement(skuNoInOrderPg);
		WebElement qty = driver.findElement(productQuantityInOrderPg);
		WebElement paymentMethod = driver.findElement(productPaymentMthdInOrderPg);
		WebElement subTotalPrice = driver.findElement(subTotalPriceInOrderPg);
		WebElement productOrderNo = driver.findElement(productOrderNoInOrderPg);
		System.out.println(HomePage.productDetail);
		productDetailsInOrderPg.add(productNm.getText());
		productDetailsInOrderPg.add(sku.getText().substring(0, 5));
		productDetailsInOrderPg.add(qty.getText());
		productDetailsInOrderPg.add(paymentMethod.getText());
		productDetailsInOrderPg.add(subTotalPrice.getText().replace("$", "").trim());
		productDetailsInOrderPg.add(productOrderNo.getText().replaceAll("\\D", "").trim());
		System.out.println(productDetailsInOrderPg);

	}
}
