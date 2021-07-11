package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Baseclass;
import utilities.ReusableMethods;

public class GiftCardsPage extends Baseclass {

	public GiftCardsPage(WebDriver driver, WebElement element) {
		super(driver, element);
	}

	static By weddingGiftCard = By.xpath("//p[contains(text(),'Wedding Gift Card')]");
	static By email = By.xpath("//li[contains(text(),'E-Mail')]");
	static By recipientName = By.name("name");
	static By senderName = By.name("senderName");
	static By recipientNumber = By.name("mobileNo");
	static By senderNumber = By.name("senderMobileNo");
	static By recipientEmail = By.name("emailId");
	static By senderEmail = By.name("senderEmailId");
	static By giftMessage = By.name("giftMessage");
	static By buynowButtton = By.xpath("//button[contains(text(),'BUY NOW')]");
	static By errorMessage = By.xpath("//*[@id=\"deliveredSection\"]/div/div/div/div[1]/div/div[3]/p");
	
	public static void selectWeddingGiftCard() throws InterruptedException {
		
		
		//WebDriverWait wait = new WebDriverWait(driver,10);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(weddingGiftCard));
		Thread.sleep(3000);
		driver.findElement(weddingGiftCard).click();
		System.out.println("card clicked");
	}
	
	public static void selectEmail() throws InterruptedException {
		//WebDriverWait wait = new WebDriverWait(driver,10);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(email));
		Thread.sleep(2000);
		driver.findElement(email).click();
	}

	public static void enterSenderDetails(String name,String phone,String email) {
		
		driver.findElement(senderName).sendKeys(name);
		driver.findElement(senderNumber).sendKeys(phone);
		driver.findElement(senderEmail).sendKeys(email);
	}
	
	public static void enterRecipientDetails(String name,String phone,String email) {
		driver.findElement(recipientName).sendKeys(name);
		driver.findElement(recipientNumber).sendKeys(phone);
		driver.findElement(recipientEmail).sendKeys(email);
	}
	
	public static void addMessage(String message) {
		driver.findElement(giftMessage).sendKeys(message);
	}
	
	public static void clickBuyNow() {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(buynowButtton));
		driver.findElement(buynowButtton).click();
	}
	
	public static void printErrorMessage() {
		String errorText = driver.findElement(errorMessage).getText();
		ReusableMethods.captureScreenShot(driver);
		System.out.println(errorText);
	}
}
