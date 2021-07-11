package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

public class DriverSetup extends Baseclass {
	static FileInputStream fis;
	static Properties prop;

	public DriverSetup(WebDriver driver, WebElement element) {

		super(driver, element);
	}

	public static void Initiate(String browserName) throws IOException {
		switch (browserName) {
		// chrome driver code
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "webdrivers//chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			// opening the browser in incognito mode.
			chromeOptions.addArguments("--disable-notifications", "--incognito");
			driver = new ChromeDriver(chromeOptions);
			openBrowser();
			break;

		case "edge":
			// MS Edge driver code
			System.setProperty("webdriver.edge.driver", "webdrivers//msedgedriver.exe");
			driver = new EdgeDriver();
			openBrowser();
			break;
		case "firefox":
			// firefox
			System.setProperty("webdriver.gecko.driver", "webdrivers//geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			// open browser in headless mode
			options.addArguments("--headless");
			options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
			driver = new FirefoxDriver(options);
			openBrowser();
			break;

		}

	}

	// method for opening the browser and navigating to the url
	public static void openBrowser() throws IOException {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fis = new FileInputStream("src//test//resources//config.properties");
		prop = new Properties();
		prop.load(fis);
		driver.get(prop.getProperty("baseurl"));
	}

	// method for closing the browser tab
	public static void Kill() {
		driver.quit();
	}
}
