package appModules;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageobjectmodel.CabBookingPage;
import pageobjectmodel.CabBookingPriceDetailsPage;
import pageobjectmodel.LandingPage;
import utilities.Baseclass;
import utilities.ExcelUtils;

public class CabBooking extends Baseclass {
	private static Logger logger = (Logger) LogManager.getLogger(CabBooking.class);

	public CabBooking(WebDriver driver, WebElement element) {
		super(driver, element);
	}
	public static void execution() {
		try {
			LandingPage.clickCabLink();
			CabBookingPage.selectOneWay();
			CabBookingPage.fillFromCity();
			CabBookingPage.fillToCity();
			CabBookingPage.fillDepartureDate();
			CabBookingPage.fillTime();
			CabBookingPage.clickSearch();
			Thread.sleep(5000);
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.elementToBeClickable(CabBookingPriceDetailsPage.suvclickable()));
			CabBookingPriceDetailsPage.clickSUV();
			List<WebElement>  cabNameElements = CabBookingPriceDetailsPage.getCarNames();
			List<WebElement> cabPriceElements = CabBookingPriceDetailsPage.getCarPrices();

			List<String> cabNameList = new ArrayList<String>();
			List<String> cabPriceList = new ArrayList<String>();
			cabNameList.add("CAB NAME");
			cabPriceList.add("PRICE");

			for (int i = 0; i <  cabNameElements.size(); i++) {
				cabNameList.add( cabNameElements.get(i).getText());
				cabPriceList.add(cabPriceElements.get(i).getText().substring(1));
				logger.info("Lowest Cab Prices");
				logger.info( cabNameElements.get(i).getText() + " -> Rs." + cabPriceElements.get(i).getText().substring(1));
			}

			try {
				ExcelUtils.writeIntoExcel(cabNameList, cabPriceList, "Sheet2");
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/************* To return if cab element is enabled or not *************/
	public static boolean cabElement() {
		WebElement icon = LandingPage.cabLink();
		boolean check = false;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if (icon.isDisplayed() && icon.isEnabled()) {
			check = true;
		}
		return check;
	}
	/************* To check with valid inputs *************/
	public static boolean validInputsCheck() {
		try {
			LandingPage.clickCabLink();
			CabBookingPage.selectOneWay();
			CabBookingPage.fillFromCity();
			CabBookingPage.fillToCity();
			CabBookingPage.fillDepartureDate();
			CabBookingPage.fillTime();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	/************* To check with Sorted Order(Price) of Cars *************/
	public static String sortedCarOrder() throws InterruptedException {

		CabBookingPage.clickSearch();
		Thread.sleep(5000);
		return CabBookingPriceDetailsPage.sortedPriceBy();
	}


	/************* To check with filters *************/
	public static String filtersCheck() throws InterruptedException {

		CabBookingPriceDetailsPage.clickSUV();
		return CabBookingPriceDetailsPage.textCheckSuv();
	}

	/************* To return list of cars with prices and names *************/
	public static List<WebElement> priceDisplayCheck() throws InterruptedException {

		List<WebElement> li = CabBookingPriceDetailsPage.getCarNames();
		List<WebElement> li1 = CabBookingPriceDetailsPage.getCarPrices();
		for (int i = 0; i < li.size(); i++) {
			logger.info(li.get(i).getText() + " -> Rs." + li1.get(i).getText().substring(1));
		}
		return li1;
	}

	/***************** To check the title of the page *********/
	public static String cabTitleCheck() {
		return driver.getTitle();
	}

}
