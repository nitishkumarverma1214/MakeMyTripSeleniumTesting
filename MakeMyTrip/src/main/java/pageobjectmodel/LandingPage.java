package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Baseclass;

public class LandingPage extends Baseclass {

	public LandingPage(WebDriver driver, WebElement element) {
		super(driver, element);
	}

	@FindBy(xpath = "//li[@class='menu_Hotels']")
	public WebElement hotelLink;

	@FindBy(xpath = "//li[@class='menu_Cabs']")
	public WebElement cabLink;

	@FindBy(xpath = "//li[contains(@class,'menu_More')]")
	public WebElement moreMenu;
	
	@FindBy(partialLinkText = "Giftcards")
	public WebElement giftCardLink;
	
	public HotelBookingPage clickHotelLink() {
		hotelLink.click();
		return PageFactory.initElements(driver, HotelBookingPage.class);
	}

	public CabBookingPage clickCabLink() {
		cabLink.click();
		return PageFactory.initElements(driver, CabBookingPage.class);
	}
	
	public GiftCardsPage clickGiftCardsLink() {
		// Hover over More Menu
		Actions action = new Actions(driver);
		action.moveToElement(moreMenu).perform();
		
		// click GiftCard link
		giftCardLink.click();
		
		return PageFactory.initElements(driver, GiftCardsPage.class);
	}
	
}
