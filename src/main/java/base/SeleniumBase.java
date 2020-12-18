package base;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SeleniumBase {

	public void waitForElement(WebElement element, WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void openNewBlankTab(WebDriver driver){
		((JavascriptExecutor)driver).executeScript("window.open();");
	}
	
	public void switchToTab(WebDriver driver, int tabNumber){
		try{
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			if(tabNumber<=tabs.size())
			{
				// change focus to new tab
				System.out.println(tabs.get(tabNumber-1));
				driver.switchTo().window(tabs.get(tabNumber-1));
				System.out.println("Switched to " + driver.getTitle());
			}
			else
			{
				System.out.println("No such tab exists");
				return;
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public boolean waitUntilInvisible(WebElement element, WebDriverWait wait) {
		try {
			wait.until(ExpectedConditions.invisibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean isElementVisible(WebElement element, WebDriverWait wait) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void clickElement(WebElement element, WebDriverWait wait) {
		waitForElement(element, wait);
		element.click();
	}
	
	public void clickElementIfVisible(WebElement element, WebDriverWait wait) {
		if(isElementVisible(element, wait)){
			element.click();
		}
	}


	public void scrollToElement(WebElement element){
		try{
			Coordinates coordinate = ((Locatable) element).getCoordinates();
			coordinate.inViewPort();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
	
	public void enterText(WebElement element, WebDriverWait wait, String textToEnter) {
		waitForElement(element, wait);
		element.click();
		element.clear();
		element.sendKeys(textToEnter);
	}

	public void selectFromDropdown( WebElement selectDropdownLoc, String text) {
		Select selectDropdown = new Select(selectDropdownLoc);
		selectDropdown.selectByVisibleText(text);
	}
	
}
