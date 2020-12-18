package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverBase {
	
	
	/**method to return driver
	 * @return
	 */
	public static WebDriver getDriver() {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = null;

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("console", true);
		capabilities.setCapability("network", true);
		capabilities.setCapability("visual", true);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments(new String[] { "--no-sandbox" });
		options.addArguments(new String[] { "--disable-notifications" });
		options.merge(capabilities);
		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		return driver;
	}

}
