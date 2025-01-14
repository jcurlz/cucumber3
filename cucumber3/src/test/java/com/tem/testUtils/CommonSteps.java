package com.tem.testUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CommonSteps {

	private WebDriver driver;
	
	
	@Before
	public void beforeTest(Scenario scenario) {
		System.out.println("------------------- Before each Scenario----------------------");
		System.out.println("##################### TEST STARTS ##########################");
	
		System.out.println("\nScenario Title : " +scenario.getName().toUpperCase());
		WebDriverManager.chromedriver().setup();

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--headless");
		driver = new ChromeDriver(option);

		driver.get("https://www.ebay.com/");

	}
	
	@After
	public void afterTest(Scenario scenario) {
		if (scenario.isFailed()) {
			// Capture screenshot when the scenario fails
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

			// Attach the screenshot to the scenario (works in Cucumber with JDK 1.8)
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
		System.out.println("------------------- After each Scenario----------------------");
		System.out.println("##################### TEST ENDS ##########################");
	}

	public WebDriver returnURL() {
		return driver;
	}

}
