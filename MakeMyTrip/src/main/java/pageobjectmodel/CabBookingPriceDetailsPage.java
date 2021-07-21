package pageobjectmodel;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.Baseclass;

public class CabBookingPriceDetailsPage extends Baseclass {
	private static Logger logger = (Logger) LogManager.getLogger(CabBookingPriceDetailsPage.class);

	public CabBookingPriceDetailsPage(WebDriver driver, WebElement element) {
		super(driver, element);
	}

	static By suv = By.xpath("//label[contains(text(),'SUV')]");
	static By carname = By.xpath("//div[@class='cabImage']/parent::div/div[2]/descendant::span[1]");
	static By carprice = By.xpath("//div[@class='cabImage']/parent::div/div[3]/descendant::p[1]");

	public static By suvclickable() {
		return suv;
	}

	/************* To check the suv name *************/
	public static String textCheckSuv() {
		logger.info("verifying the SUV text");
		return driver.findElement(suv).getText();
	}

	/************* To select suv checkbox *************/
	public static void clickSUV() {
		logger.info("clicking the SUV text");
		driver.findElement(suv).click();
	}

	/************* To return list of car names *************/
	public static List<WebElement> getCarNames() {
		logger.info("Finding the list of cabs");
		return driver.findElements(carname);
	}

	/************* To return list of car prices *************/
	public static List<WebElement> getCarPrices() {
		logger.info("Finding the prices of cabs");
		return driver.findElements(carprice);
	}
}
