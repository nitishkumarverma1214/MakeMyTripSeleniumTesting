package appModules;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageobjectmodel.GiftCardsPage;
import pageobjectmodel.LandingPage;
import utilities.Baseclass;

public class GiftCards extends Baseclass {

	public GiftCards(WebDriver driver, WebElement element) {
		super(driver, element);
	}

	public static void execution() throws InterruptedException {
		LandingPage.clickGiftCardsLink();

		String parentWindow = driver.getWindowHandle();

		for (String window : driver.getWindowHandles()) {
			if (!window.equalsIgnoreCase(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}

		GiftCardsPage.selectWeddingGiftCard();
		GiftCardsPage.selectEmail();
		GiftCardsPage.enterSenderDetails("PM", "9871923832", "pmo@gmail.com");
		GiftCardsPage.enterRecipientDetails("Me", "9014834542", "hi.com");
		GiftCardsPage.addMessage("mithai lelo");
		GiftCardsPage.clickBuyNow();
		GiftCardsPage.printErrorMessage();
	}
}
