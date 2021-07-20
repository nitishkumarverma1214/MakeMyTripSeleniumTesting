package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverSetup extends Baseclass {
	static FileInputStream fis;
	static Properties prop;

	public DriverSetup(WebDriver driver, WebElement element) {

		super(driver, element);
	}
     /********* method to initiate driver setup **********/
	public static void Initiate(String browserName) throws IOException {
		DesiredCapabilities capabilities;
		URL gridUrl;

		gridUrl = new URL("http://localhost:4445/wd/hub");
		capabilities = new DesiredCapabilities();
		capabilities.setBrowserName(browserName);
		driver = new RemoteWebDriver(gridUrl, capabilities);
		
		openBrowser();

	}

	/*************** method for opening the browser and navigating to the url ***********************/
	public static void openBrowser() throws IOException {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		fis = new FileInputStream("src//test//resources//config.properties");
		prop = new Properties();
		prop.load(fis);
		driver.get(prop.getProperty("baseurl"));
	}

      /*************** method for closing the browser tab**************/
	public static void Kill() {
		driver.quit();
	}
}
