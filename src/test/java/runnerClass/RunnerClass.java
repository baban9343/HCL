package runnerClass;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.ExtentCucumberFormatter;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import drivers.StaticVariables;
import reusableFunctions.ConfigFileReader;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = { "stepDefinitions" }, plugin = {
		"com.cucumber.listener.ExtentCucumberFormatter:", }, tags = { "@MyProfile" }, monochrome = true)
public class RunnerClass {

	ConfigFileReader config = new ConfigFileReader();

	static String reportPath = StaticVariables.CurrentHomeDirectory + "//target//cucumber-reports//report.html";

	@BeforeClass
	public static void startExecution() {
		File file = new File(reportPath);
		ExtentCucumberFormatter extent = new ExtentCucumberFormatter(file);
	}

	@AfterClass
	public static void createReport() {
		Reporter.loadXMLConfig("config/report.xml");
	}
}
