package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Baseclass;

public class GiftCardsPage extends Baseclass {

	public GiftCardsPage(WebDriver driver, WebElement element) {
		super(driver, element);
	}

	static By weddingGiftCard = By.xpath("//p[contains(text(),'Wedding Gift Card')]");
	
	
	public static void selectWeddingGiftCard() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(weddingGiftCard));
		driver.findElement(weddingGiftCard).click();
		System.out.println("card clicked");
		//Actions act = new Actions(driver);
		//act.moveToElement(driver.findElement(weddingGiftCard)).click().build().perform();
		//System.out.println("card clicked");
	} 
	
	
}
