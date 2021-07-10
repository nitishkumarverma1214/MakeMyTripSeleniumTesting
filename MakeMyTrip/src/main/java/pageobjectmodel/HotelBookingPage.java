package pageobjectmodel;

import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.Baseclass;
import utilities.ReusableMethods;

public class HotelBookingPage extends Baseclass {

	public HotelBookingPage(WebDriver driver, WebElement element) {
		super(driver, element);
	}

	static By city = By.cssSelector("#city");
	static By hotelInput = By.xpath("//input[contains(@placeholder,' Hotel')]");
	static By guest = By.cssSelector("#guest");
	static By adultGuest = By.xpath("//ul[@data-cy='adultCount']/child::*");

	public static void fillCity() throws InterruptedException {
		// fill the city value
		driver.findElement(city).click();
		driver.findElement(hotelInput).sendKeys("Chennai");
		
		// replace the dead wait
		Thread.sleep(2000);
		driver.findElement(hotelInput).sendKeys(Keys.DOWN, Keys.RETURN);

	}

	public static void selectCheckInDate() throws ParseException, InterruptedException {
		String checkInDate = "01/08/2021";
		ReusableMethods.selectDate(driver, checkInDate);
	}

	public static void selectCheckOutDate() throws ParseException, InterruptedException {
		String checkInDate = "05/08/2021";
		ReusableMethods.selectDate(driver, checkInDate);
	}

	public static void showGuestCount() throws InterruptedException {
		driver.findElement(guest).click();
		
		// replace the dead wait
		Thread.sleep(1000);
		driver.findElements(adultGuest).forEach(element -> System.out.println(element.getAttribute("data-cy")));
	}
}
