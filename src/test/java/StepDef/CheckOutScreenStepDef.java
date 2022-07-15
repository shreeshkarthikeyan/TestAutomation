package StepDef;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utils.BrowserManager;

public class CheckOutScreenStepDef {

	WebDriver driver = BrowserManager.driver;
	@And("User checks wether mandatory fields validation alert comes to the {string} page")
	public void User_checks_wether_mandatory_fields_validation_alert_comes_to_the_checkout_page(String pageName) {
		
		List<String> mandatoryFields = new ArrayList<String>();
		boolean isFound = false;
		List<WebElement> elements = driver.findElements(By.xpath("//span[@class='req']/../..//label"));
		
		for(WebElement element: elements) {
			mandatoryFields.add(element.getText().replace("*", "").trim());
		}
		
		for(String mandatoryField : mandatoryFields) {
			if(mandatoryField.equals("Card Type")) {
				WebElement xpath = driver.findElement(By.xpath("//label[contains(text(),'Card Type')]/..//select"));
				Select cardType = new Select(xpath);
				cardType.selectByIndex(0);
				xpath.sendKeys(Keys.TAB);
			}
		}
		
		for(String mandatoryField : mandatoryFields) {
			isFound = false;
			String modified = mandatoryField + " is required";
			if(mandatoryField.equals("Card Number")) {
				modified = "Credit Card is required";
			} 
			List<WebElement> mandatoryElement = driver.findElements(By.xpath("//*[text()='"+ modified +"']"));
			if(mandatoryElement.size() == 1) {
				isFound = true;
			} else {
				isFound = false;
				break;
			}
		}
		if(isFound) {
			Reporter.log("All the mandatory validations passed.", true);
		} else {
			Reporter.log("All the mandatory validations passed.", false);
		}
	}
	
	@Then("User enters {string} as {string}")
	public void user_enters_as(String inputField, String inputValue) {
		
		String xpath = "//label[contains(text(),'"+ inputField +"')]/..//input | //label[contains(text(),'"+ inputField +"')]/..//textarea";
		
		List<WebElement> element = driver.findElements(By.xpath(xpath));		
		if(element.size() == 1) {
			element.get(0).sendKeys(inputValue);
			Reporter.log("User entered "+ inputField +" as "+ inputValue, true);
		} else {
			Reporter.log("User entered "+ inputField +" as "+ inputValue, false);
		}
	}
	
	@Then("User selects {string} as {string}")
	public void user_selects_as(String selectField, String selectValue) {
		
		List<WebElement> element = driver.findElements(By.xpath("//label[contains(text(),'"+ selectField +"')]/..//select"));		
		if(element.size() == 1) {
			
			Select cardType = new Select(element.get(0));
			cardType.selectByVisibleText(selectValue);
			element.get(0).sendKeys(Keys.TAB);
			
			Reporter.log("User selected "+ selectField +" as "+ selectValue, true);
		} else {
			Reporter.log("User selected "+ selectField +" as "+ selectValue, false);
		}
	}
}
