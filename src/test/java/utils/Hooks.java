package utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks extends BrowserManager {

	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException {
		  byte[] fileContent = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		  scenario.attach(fileContent, "image/png", "screenshot");
		
	}
}
