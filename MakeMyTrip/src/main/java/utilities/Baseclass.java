package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Baseclass {
	public static WebDriver driver;
	public static WebElement element;

	public Baseclass(WebDriver driver, WebElement element) {
		Baseclass.driver = driver;
		Baseclass.element = element;
	}
}
