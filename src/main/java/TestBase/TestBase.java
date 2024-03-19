package TestBase;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Scenario;

public class TestBase {
	
	public static WebDriver driver;
	
	public void browserLaunch()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/");
	}
	
	public void quitBrowser(Scenario scenario)
	{
		String scenarioName = scenario.getName();
		if(scenario.isFailed()) {
			TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
			byte[] screenshot =	takeScreenshot.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenarioName);
		}
		driver.quit();
	}
}
