package StepDef;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.BrowserManager;


public class HomeScreenStepDef {

	WebDriver driver;
	@Given("User logs into the application in {string} browser")
	public void user_logs_into_the_application_in_browser(String string) {
	    // Write code here that turns the phrase above into concrete actions
		
		String url = "https://jupiter.cloud.planittesting.com/#/";
		
		driver = BrowserManager.getDriver(string);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
	}

	@Then("User checks wether {string} menu are available in the top section")
	public void user_checks_wether_menu_are_available_in_the_top_section(String sections) {
		
		boolean isFound = false;
		String[] section = sections.split(",");
		List<WebElement> menuBars= driver.findElements(By.xpath("//div[@class='nav-collapse']//li"));
		
		for(String s : section) {
			isFound = false;
			for (int i=0; i<menuBars.size();i++){
			      if(menuBars.get(i).getText().contains(s)) {
			    	  isFound = true;
			    	  break;
			      }
			}
			if(!isFound) {
				Reporter.log(s+" menu is not available at the top section", false);
			}
		}
		
	}

	@Then("User checks wether it is navigated to {string} menu")
	public void user_checks_wether_it_is_navigated_to_menu(String menu) {
	    
		String focusElement = driver.findElement(By.xpath("//li[@class='active']/a")).getText();
		if(focusElement.trim().equals(menu)) {
			Reporter.log("User is navigated to "+menu+" menu", true);
		}else {
			Reporter.log("User is not navigated to "+menu+" menu", false);
		}
		
	}

	@Given("User clicks {string} button")
	public void user_clicks_button(String buttonName) throws InterruptedException {
	    
		String xpath = "//a[contains(text(),'"+ buttonName +"')] | //button[contains(text(),'"+ buttonName +"')]";
		List<WebElement> element = driver.findElements(By.xpath(xpath));
		if(element.size() == 1) {
			element.get(0).click();
			Thread.sleep(5000);
			Reporter.log("User clicks "+buttonName+" button successfully", true);
		} else {
			Reporter.log("User click "+buttonName+" button", false);
		}
		
	}
	
	@Given("User clicks {string} button in the modal")
	public void user_clicks_button_in_the_modal(String buttonName) throws InterruptedException {
	    
		String xpath = "//button[contains(text(),'"+ buttonName +"')]";
		List<WebElement> element = driver.findElements(By.xpath(xpath));
		if(element.size() == 1) {
			element.get(0).click();
			Thread.sleep(5000);
			Reporter.log("User clicks "+buttonName+" button successfully", true);
		} else {
			Reporter.log("User click "+buttonName+" button", false);
		}
		
	}
}
