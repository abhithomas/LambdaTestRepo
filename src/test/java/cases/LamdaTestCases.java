package cases;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.DriverBase;
import source.LoginPage;

public class LamdaTestCases extends DriverBase {

	WebDriver driver = null;
	LoginPage loginPage = null;

	@BeforeClass
	public void beforeClass() {

		driver = getDriver();
		loginPage = new LoginPage(driver);
	}

	@Test(priority = 1)
	public void verify_login_successfully() throws AWTException {
		loginPage.loginLambDaTest();
		loginPage.verifySuccessLoginToastMsg();
	}

	@Test(priority = 2)
	public void fill_form_first_part() throws AWTException {
		loginPage.fillFormPartOne();
	}

	@Test(priority = 3)
	public void verify_slider_rating_set_nine() throws AWTException {
		loginPage.setAndVerifySlider();
	}

	@Test(priority = 4)
	public void verify_form_submitted_successfully() throws AWTException {
		loginPage.verifyFormSubmitted();
	}
	
	@AfterClass
	public void afterClass() {
		driver .quit();
	}
}
