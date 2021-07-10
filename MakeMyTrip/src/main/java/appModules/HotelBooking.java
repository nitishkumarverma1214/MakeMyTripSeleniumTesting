package appModules;

import java.text.ParseException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageobjectmodel.HotelBookingPage;
import pageobjectmodel.LandingPage;
import utilities.Baseclass;

public class HotelBooking extends Baseclass {

	public HotelBooking(WebDriver driver, WebElement element) {
		super(driver, element);
	}

	public static void execution() {
		LandingPage.clickHotelLink();
		try {
			HotelBookingPage.fillCity();
			HotelBookingPage.selectCheckInDate();
			HotelBookingPage.selectCheckOutDate();
			HotelBookingPage.showGuestCount();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
