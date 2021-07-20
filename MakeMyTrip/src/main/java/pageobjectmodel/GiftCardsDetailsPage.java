package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Baseclass;

public class GiftCardsDetailsPage extends Baseclass {

	public GiftCardsDetailsPage(WebDriver driver, WebElement element) {
		super(driver, element);
	}
	static By email = By.xpath("//li[contains(text(),'E-Mail')]");
	static By recipientName = By.name("name");
	static By senderName = By.name("senderName");
	static By recipientNumber = By.name("mobileNo");
	static By senderNumber = By.name("senderMobileNo"); 
	static By recipientEmail = By.name("emailId");
	static By senderEmail = By.name("senderEmailId");
	static By giftMessage = By.name("giftMessage");
	static By buynowButtton = By.xpath("//button[contains(text(),'BUY NOW')]");
	static By senderNameErrorMessage = By.xpath("//*[@id=\"deliveredSection\"]/div/div/div/div[2]/div[1]/p");
	static By recipientNameErrorMessage = By.xpath("//*[@id=\"deliveredSection\"]/div/div/div/div[1]/div/div[1]/p ");
	static By senderMobileErrorMessage = By.xpath("//*[@id=\"deliveredSection\"]/div/div/div/div[2]/div[2]/div[2]/p");
	static By recipientMobileErrorMessage = By.xpath("//*[@id=\"deliveredSection\"]/div/div/div/div[1]/div/div[2]/div[2]/p");
	static By senderMailErrorMessage = By.xpath("//*[@id=\"deliveredSection\"]/div/div/div/div[2]/div[3]/p");
	static By recipientMailErrorMessage = By.xpath("//*[@id=\"deliveredSection\"]/div/div/div/div[1]/div/div[3]/p");
	/************* To return sender name *************/
	public static WebElement senderNameBox() {
		return driver.findElement(senderName);
	}
	/************* To return receiver EmailBox *************/
	public static WebElement receiverEmailBox() {
		return driver.findElement(recipientName);
	}
	/************* To return sender EmailBox *************/
	public static WebElement senderEmailBox() {
		return driver.findElement(senderEmail);
	}
	/************* To return recipient EmailBox *************/
	public static WebElement recipientEmailBox() {
		return driver.findElement(recipientEmail);
	}
	/************* To return sender Mobile TextBox *************/
	public static WebElement senderMobileTextBox() {
		return driver.findElement(senderNumber);
	}
	/************* To return recipient Mobile Text Box *************/
	public static WebElement recipientMobileTextBox() {
		return driver.findElement(recipientNumber);
	}
	/************* To select email *************/
	public static void selectEmail() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(email));
		driver.findElement(email).click();
	}
	/************* To enter sender details *************/
	public static void enterSenderDetails(String name,String phone,String email) {
		
		driver.findElement(senderName).sendKeys(name);
		driver.findElement(senderNumber).sendKeys(phone);
		driver.findElement(senderEmail).sendKeys(email);
	}
	/************* To enter recipient details *************/
	public static void enterRecipientDetails(String name,String phone,String email) {
		driver.findElement(recipientName).sendKeys(name);
		driver.findElement(recipientNumber).sendKeys(phone);
		driver.findElement(recipientEmail).sendKeys(email);
	}
	/************* To enter recipient details *************/
	public static void addMessage(String message) {
		driver.findElement(giftMessage).sendKeys(message);
	}
	/************* To enter recipient details *************/
	public static void clickBuyNow() {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(buynowButtton));
		driver.findElement(buynowButtton).click();
	}
	public static String printRecipientMailErrorMessage() {
		String errorText = driver.findElement(recipientMailErrorMessage).getText();
		return errorText;
	}
	public static String printSenderMailErrorMessage() {
		String errorText = driver.findElement(senderMailErrorMessage).getText();
		return errorText;
	}
	public static String printRecipientMobileErrorMessage() {
		String errorText = driver.findElement(recipientMobileErrorMessage).getText();
		return errorText;
	}
	public static String printRecipientNameErrorMessage() {
		String errorText = driver.findElement(recipientNameErrorMessage).getText();
		return errorText;
	}
	public static String printSenderNameErrorMessage() {
		String errorText = driver.findElement(senderNameErrorMessage).getText();
		return errorText;
	}
	
	public static String printSenderMobileErrorMessage() {
		String errorText = driver.findElement(senderMobileErrorMessage).getText();
		return errorText;
	}
}
