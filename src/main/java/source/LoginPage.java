package source;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.SeleniumBase;

public class LoginPage extends SeleniumBase{
	
	WebDriver driver = null;
	WebDriverWait wait = null;
	
	@FindBy(css = ".cbtn.btn_accept_ck")
	WebElement cookieAccept;
	
	@FindBy(css = ".closesitewebinar")
	WebElement closeAds;
	
	@FindBy(css = ".toast.jam")
	WebElement toastJam;
	
	@FindBy(id = "username")
	WebElement userNameTab;
	
	@FindBy(id = "password")
	WebElement passwordTab;
	
	@FindBy(css = ".applynow")
	WebElement submitBtn;
	
	@FindBy(xpath="//h4[text()='Login to Selenium Playground']")
	WebElement loginHeader;
	
	@FindBy(id = "developer-name")
	WebElement emailTab;
	
	@FindBy(id = "populate")
	WebElement populate;
	
	@FindBy(id = "3months")
	WebElement three_months;
	
	@FindBy(id = "discounts")
	WebElement discounts;
	
	@FindBy(id = "preferred-payment")
	WebElement selectPayment;
	
	@FindBy(id = "tried-ecom")
	WebElement triedEcom;

	@FindBy(css = "#slider span")
	WebElement sliderSpan;
	
	@FindBy(id = "comments")
	WebElement comments;
	
	@FindBy(id = "img")
	WebElement uploadBtn;

	@FindBy(css="img[alt='LambdaTest Jenkins integration']")
	WebElement jenkinsImage;
	
	@FindBy(id = "submit-button")
	WebElement submit_button;
	
	@FindBy(css = "#message p")
	WebElement submit_SuccessMsg;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(this.driver, 10);
	}

	public void loginLambDaTest() {
		driver.get("https://www.lambdatest.com/automation-demos/");
		clickElementIfVisible(closeAds, wait);
		clickElementIfVisible(cookieAccept, wait);
		enterText(userNameTab, wait, "lambda");
		enterText(passwordTab, wait, "lambda123");
		clickElement(submitBtn, wait);
	}
	
	public void verifySuccessLoginToastMsg() {
		waitForElement(toastJam, wait);
		String msg = toastJam.getText();
		assertTrue(msg.contains("Thank You Successully Login!!"));
		waitUntilInvisible(toastJam, wait);
		assertFalse(isElementVisible(toastJam, wait));
	}
	
	public void fillFormPartOne() throws AWTException {
		enterText(emailTab, wait, "abc@gmail.com");
		clickElement(populate, wait);
		driver.switchTo().alert().accept();
		clickElement(three_months, wait);
		clickElement(discounts, wait);
		selectFromDropdown(selectPayment, "Wallets");
	}
	
	public void setAndVerifySlider() {
		Actions action  = new Actions(driver);
		clickElement(triedEcom, wait);
		action.dragAndDropBy(sliderSpan, 500, 0).build().perform();
		assertTrue(sliderSpan.getAttribute("style").contains("88"));
	}
	
	public void verifyFormSubmitted() {
		clickElement(submit_button, wait);
		assertTrue(isElementVisible(submit_SuccessMsg, wait));
		assertEquals(submit_SuccessMsg.getText(), "You have successfully submitted the form.");
	}
	
}
