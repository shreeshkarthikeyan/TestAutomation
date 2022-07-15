package utils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserManager {
	
	public static WebDriver driver;
	
	public static WebDriver getDriver(String browser) {
				
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+File.separator+"driver"+File.separator+"chromedriver.exe");
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		
		return driver;
	}

}