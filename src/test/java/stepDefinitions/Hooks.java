package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import drivers.GetDrivers;
import io.github.bonigarcia.wdm.WebDriverManager;
import reusableFunctions.ConfigFileReader;

public class Hooks {

	@Before
	public void openBrowser(Scenario scenario) {
		ConfigFileReader config = new ConfigFileReader();
		int maxWaitTime = Integer.parseInt(config.getPropertyfromPropertiesFile("MaxWaitTime"));
		System.out.println("Starting the execution of scenario " + scenario.getName());
		System.out.println("Opening Chrome!!");
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(maxWaitTime, TimeUnit.SECONDS);
		GetDrivers.driver = driver;
	}

	@After
	public void tearDown() {
		GetDrivers.driver.quit();
	}
}
