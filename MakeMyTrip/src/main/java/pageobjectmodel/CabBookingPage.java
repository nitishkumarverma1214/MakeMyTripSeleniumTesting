package pageobjectmodel;

import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Baseclass;
import utilities.ReusableMethods;

public class CabBookingPage extends Baseclass {

	public CabBookingPage(WebDriver driver, WebElement element) {
		super(driver, element);
	}

	static By oneWayLink = By.xpath("//li[@data-cy='outstationOneWay']");
	static By fromCityLink = By.cssSelector("#fromCity");
	static By fromCityInput = By.xpath("//input[contains(@placeholder,'From')]");
	// static By toCityLink =By.cssSelector("#toCity");
	static By toCityInput = By.xpath("//input[contains(@placeholder,'To')]");
	static By searchButton = By.xpath("//a[contains(text(),'Search')]");
	static By backDropDiv = By.className("hsBackDrop");
	

	public static void selectOneWay() {
		driver.findElement(oneWayLink).click();
		ReusableMethods.captureScreenShot(driver);
	}

	public static void fillFromCity() throws InterruptedException {
		driver.findElement(fromCityLink).click();
		driver.findElement(fromCityInput).sendKeys("Delhi");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElementValue(fromCityInput, "Delhi"));
		Thread.sleep(3000);
		driver.findElement(fromCityInput).sendKeys(Keys.DOWN, Keys.RETURN);
		ReusableMethods.captureScreenShot(driver);
	}

	public static void fillToCity() throws InterruptedException {
//		driver.findElement(toCityLink).click();
		driver.findElement(toCityInput).sendKeys("Manali");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElementValue(toCityInput, "Manali"));
		Thread.sleep(1000);
		driver.findElement(toCityInput).sendKeys(Keys.DOWN, Keys.RETURN);
		ReusableMethods.captureScreenShot(driver);
	}

	public static void fillDepartureDate() {
		try {
			ReusableMethods.selectDate(driver, "01/08/2021");
			ReusableMethods.captureScreenShot(driver);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void clickSearch() {
		driver.findElement(backDropDiv).click();
		driver.findElement(searchButton).click();
		ReusableMethods.captureScreenShot(driver);
	}

	
}
