package StepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;


import io.cucumber.java.en.Then;
import utils.BrowserManager;

public class ShopScreenStepDef {

	WebDriver driver = BrowserManager.driver;
	
	@Then("User buys {string} toy")
	public void user_buys_toy(String toyName) {
		

		new WebDriverWait(driver, 40).until(
				webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
	    
		WebElement element = driver.findElement(By.xpath("//h4[text()='"+ toyName +"']/..//a[contains(text(),'Buy')]"));
		element.click();
	}
	
	
	@Then("User checks {string} items added near the Cart keyword at the top")
	public void user_checks_items_added_near_the_Cart_keyword_at_the_top(String items) {
		
		int expected = Integer.parseInt(items);
		
		WebElement element = driver.findElement(By.xpath("//a[contains(text(), 'Cart')]/span"));
		int actual = Integer.parseInt(element.getText());
		
		if(actual == expected) {
			Reporter.log("Value near the Cart keyword matches the expected value", true);
		} else {
			Reporter.log("Value near the Cart keyword matches the expected value", false);
		}
	}
}
