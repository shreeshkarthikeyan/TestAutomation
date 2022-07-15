package StepDef;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import io.cucumber.java.en.And;
import utils.BrowserManager;
public class CartScreenStepDef {

	WebDriver driver = BrowserManager.driver;
	@And("User checks wether {string} toy with {string} quantity in the list")
	public void user_checks_wether_toy_with_quantity_in_the_list(String toyName, String quantity) {
		
		new WebDriverWait(driver, 40).until(
				webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
		
		int expected = Integer.parseInt(quantity);
		WebElement element = driver.findElement(By.xpath("//td[contains(text(),'"+ toyName +"')]/..//input"));
		int actual = Integer.parseInt(element.getAttribute("value"));
		
		if(actual == expected) {
			Reporter.log(toyName + " toy is updated with "+ quantity + " quantity", true);
		} else {
			Reporter.log(toyName + " toy is updated with "+ quantity + " quantity", false);
		}
	}
	
	@And("User checks the subtotal of {string} to be {string}")
	public void user_checks_the_subtotal_of_to_be(String toyName, String total) {
		
		WebElement element = driver.findElement(By.xpath("//td[contains(text(),'" + toyName +"')]/..//td[4]"));
		String actual = element.getText();
		
		if(actual.equals(total)) {
			Reporter.log(toyName + " toy is updated with "+ total + " subtotal", true);
		} else {
			Reporter.log(toyName + " toy is updated with "+ total + " subtotal", false);
		}
	}
	
	@And("User checks the total of the cart to be {string}")
	public void user_checks_the_total_of_the_cart_to_be(String total) {
		
		new WebDriverWait(driver, 40).until(
				webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
		
		WebElement element = driver.findElement(By.xpath("//td//*[contains(text(),'Total')]"));
		String actual = element.getText().split(":")[1].trim();
		
		if(actual.equals(total)) {
			Reporter.log("Total of the cart is updated successfully", true);
		} else {
			Reporter.log("Total of the cart is updated successfully", false);
		}
	}
	
	@And("User removes {string} toy from the cart list")
	public void user_removes_toy_from_the_cart_list(String toyName) {
		
		WebElement element = driver.findElement(By.xpath("//td[contains(text(),'" + toyName +"')]/..//a"));
		
		if(element.isEnabled()) {
			element.click();
			Reporter.log(toyName + " is successfully removed from the list", true);
		} else {
			Reporter.log(toyName + " is successfully removed from the list", false);
		}
	}
	
	@And("User checks wether {string} toy is not present in the cart list")
	public void user_checks_wether_toy_is_not_present_in_the_cart_list(String toyName) {
		
		List<WebElement> element = driver.findElements(By.xpath("//td[contains(text(),'" + toyName +"')]"));
		
		if(element.size() == 0) {
			Reporter.log(toyName + "is successfully removed from the list", true);
		} else {
			Reporter.log(toyName + "is successfully removed from the list", false);
		}
	}
	
	@And("User checks wether {string} alert present in the {string} page")
	public void user_checks_wether_alert_present_in_the_Cart_page(String alertMessage, String pageName) {
		
		By xpath = By.xpath("//*[contains(text(),'"+ alertMessage +"')]");
		
		new WebDriverWait(driver, 40).until(
				ExpectedConditions.visibilityOfElementLocated(xpath));
		
		List<WebElement> element = driver.findElements(xpath);
		
		if(element.size() == 1) {
			Reporter.log(alertMessage + " is successfully populated in the "+ pageName +" page", true);
		} else {
			Reporter.log(alertMessage + " is successfully populated in the "+ pageName +" page", false);
		}
	}
}
