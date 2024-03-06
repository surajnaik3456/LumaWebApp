package Hooks;

import TestBase.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	TestBase base = new TestBase();

	@Before
	public void browserSetup()	
	{
		base.browserLaunch();
		System.out.println("I'm inside browser setup");
	}
	@After
	public void tearDown(Scenario scenario)
	{
		base.quitBrowser(scenario);
		System.out.println("Browser closed");
	}
} 
