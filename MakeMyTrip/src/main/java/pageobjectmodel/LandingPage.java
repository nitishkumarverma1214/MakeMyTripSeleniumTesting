package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.Baseclass;

public class LandingPage extends Baseclass {

	public LandingPage(WebDriver driver, WebElement element) {
		super(driver, element);
	}

	static By hotelLink = By.xpath("//li[@class='menu_Hotels']");

	static By cabLink = By.xpath("//li[@class='menu_Cabs']");

	static By loginModal = By.className("loginModal");

	 static By moreMenu = By.xpath("//li[contains(@class,'menu_More')]");

	 static By giftCardLink = By.partialLinkText("Giftcards");

	 public static WebElement cabLink() {
		 return driver.findElement(cabLink);
	 }
	 public static WebElement hotelLink() {
		 return driver.findElement(hotelLink);
	 }
	 public static WebElement moreMenu() {
		 return driver.findElement(moreMenu);
	 }
	 
	 public static WebElement giftCardText() {
		 return driver.findElement(giftCardLink);
	 }
	 
	public static void closeLoginWindow() {
		if (!driver.findElements(loginModal).isEmpty())
			driver.findElement(loginModal).click();
	}

	public static void clickHotelLink() {
		closeLoginWindow();
		driver.findElement(hotelLink).click();
	}

	public static void clickCabLink() {
		closeLoginWindow();
		driver.findElement(cabLink).click();
	}

	public static void clickGiftCardsLink() {
		closeLoginWindow();
		// Hover over More Menu
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(moreMenu);
		action.moveToElement(element).perform();

		// click GiftCard link
		driver.findElement(giftCardLink).click();

	}

}
