package appModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageobjectmodel.CabBookingPage;
import pageobjectmodel.LandingPage;
import utilities.Baseclass;

public class CabBooking extends Baseclass {

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
			CabBookingPage.clickSearch();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
