package Pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.TestBase;

public class OrderSuccessPage extends TestBase{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	By orderno = By.cssSelector("a.order-number");

	public boolean successPageDisplayed(String orderPlacedConfirm)
	{
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='"+orderPlacedConfirm+"']")));
		WebElement orderPlaced = driver.findElement(By.xpath("//span[text()='"+orderPlacedConfirm+"']"));
		return orderPlaced.isDisplayed();
	}

	public void captureOrderNumber()
	{
		HomePage.productDetail.add(driver.findElement(orderno).getText());
		System.out.println(	HomePage.productDetail);
	}

}
