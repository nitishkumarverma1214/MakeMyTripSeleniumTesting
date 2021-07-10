package appModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageobjectmodel.LandingPage;
import utilities.Baseclass;

public class GiftCards extends Baseclass {

	public GiftCards(WebDriver driver, WebElement element) {
		super(driver, element);
	}
	public static void execution() {
		LandingPage.clickGiftCardsLink();
	}
}
