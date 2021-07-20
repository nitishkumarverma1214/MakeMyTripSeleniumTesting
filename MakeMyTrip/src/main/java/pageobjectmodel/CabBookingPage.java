package pageobjectmodel;

import java.text.ParseException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Baseclass;
import utilities.ExcelUtils;
import utilities.ReusableMethods;

public class CabBookingPage extends Baseclass {
	private static Logger logger = (Logger) LogManager.getLogger(CabBookingPage.class);

	public CabBookingPage(WebDriver driver, WebElement element) {
		super(driver, element);
	}

	static List<String> li = ExcelUtils.readExcel("CAB");

	static By oneWayLink = By.xpath("//li[@data-cy='outstationOneWay']");
	static By fromCityLink = By.cssSelector("#fromCity");
	static By fromCityInput = By.xpath("//input[contains(@placeholder,'From')]");
	static By toCityInput = By.xpath("//input[contains(@placeholder,'To')]");
	static By searchButton = By.xpath("//a[contains(text(),'Search')]");
	static By pickupTime = By.xpath("//span[contains(text(),'PICKUP-TIME')]");
	static By timeDropDown = By.xpath("//ul[contains(@class,'timeDropDown')]/child::li");

	/************* To  select one way radio button *************/
	public static void selectOneWay() {
		driver.findElement(oneWayLink).click();
		ReusableMethods.captureScreenShot(driver);
	}

	/************* To fill from source city input *************/
	public static void fillFromCity() throws InterruptedException {
		driver.findElement(fromCityLink).click();
		driver.findElement(fromCityInput).sendKeys(li.get(0));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElementValue(fromCityInput, li.get(0)));
		Thread.sleep(3000);
		driver.findElement(fromCityInput).sendKeys(Keys.DOWN, Keys.RETURN);
		ReusableMethods.captureScreenShot(driver);
	}

	/************* To fill destination city input *************/
	public static void fillToCity() throws InterruptedException {
		driver.findElement(toCityInput).sendKeys(li.get(1));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElementValue(toCityInput, li.get(1)));
		Thread.sleep(1000);
		driver.findElement(toCityInput).sendKeys(Keys.DOWN, Keys.RETURN);
		ReusableMethods.captureScreenShot(driver);
	}

	/************* To fill the departure date *************/
	public static void fillDepartureDate() {
		try {
			ReusableMethods.selectDate(driver, li.get(2).substring(1, li.get(2).length() - 1));
			ReusableMethods.captureScreenShot(driver);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("departure date selected");
	}

	/************* To fill the pickup time *************/
	public static void fillTime() {
		logger.info("filling pickup time");
		String time = li.get(3);
		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(timeDropDown));
		List<WebElement> dropDown = driver.findElements(timeDropDown);

		for (WebElement li : dropDown) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", li);

			if (li.getText().contains(time.toUpperCase())) {
				System.out.println("selecting the time");

				wait.until(ExpectedConditions.elementToBeClickable(li));
				li.click();
				break;
			}
		}

	}

	/************* To click search button *************/
	public static void clickSearch() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(searchButton));

		driver.findElement(searchButton).click();
		ReusableMethods.captureScreenShot(driver);
	}

}