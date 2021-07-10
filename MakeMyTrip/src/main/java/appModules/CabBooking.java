package appModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageobjectmodel.LandingPage;
import utilities.Baseclass;

public class CabBooking extends Baseclass {

	public CabBooking(WebDriver driver, WebElement element) {
		super(driver, element);
	}
	public static void execution() {
		LandingPage.clickCabLink();
	}

}
