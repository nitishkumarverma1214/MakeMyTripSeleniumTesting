package pageobjectmodel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Baseclass;

public class GiftCardsPage extends Baseclass {
	private static Logger logger =(Logger) LogManager.getLogger(GiftCardsPage.class);
	public GiftCardsPage(WebDriver driver, WebElement element) {
		super(driver, element);
	}
	static By weddingGiftCard = By.xpath("//p[contains(text(),'Wedding Gift Card')]");
	
 /*************** to select wedding gift card **************/	
	public static void selectWeddingGiftCard() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(weddingGiftCard));
		driver.findElement(weddingGiftCard).click();
		logger.info("card clicked");
		
	} 
	
	
}
