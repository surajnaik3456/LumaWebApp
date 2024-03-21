package TestBase;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Scenario;
import java.io.IOException;
import java.time.Duration;
import util.ConfigReader;

public class TestBase {

	public static WebDriver driver;

	public void browserLaunch() throws IOException
	{
		switch (ConfigReader.getBrowser().toLowerCase()) {
	    case "chrome":
	        driver = new ChromeDriver();
	        break;
	    case "firefox":
	        driver = new FirefoxDriver();
	        break;
	    case "edge":
	        driver = new EdgeDriver();
	        break;
	    default:
	        System.out.println("Provide a valid browser..");
	}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get(ConfigReader.getUrl());

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
