package appModules;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageobjectmodel.GiftCardsDetailsPage;
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

		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		GiftCardsPage.selectWeddingGiftCard();

		GiftCardsDetailsPage.selectEmail();
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		GiftCardsDetailsPage.enterSenderDetails("PM", "9871923832", "pmo@gmail.com");
		GiftCardsDetailsPage.enterRecipientDetails("Me", "9014834542", "hi.com");
		GiftCardsDetailsPage.addMessage("mithai lelo");
		GiftCardsDetailsPage.clickBuyNow();
		GiftCardsDetailsPage.printErrorMessage();

	}
}
