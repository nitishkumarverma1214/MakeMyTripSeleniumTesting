package pageobjectmodel;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	static By travellingReason = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div/div[5]/label/span");
	static By workOption = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div/div[5]/ul/li[1]");

	public static void travellingReason() {
		driver.findElement(travellingReason).click();
	}
	
	public static void workOption() {
		driver.findElement(workOption).click();
	}
	
	public static void fillCity()  {
		// fill the city value
		driver.findElement(city).click();
		driver.findElement(hotelInput).sendKeys("Delhi");
		
		// wait for the input
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.textToBePresentInElementValue(hotelInput, "Delhi"));
		driver.findElement(hotelInput).sendKeys(Keys.DOWN, Keys.RETURN);
		ReusableMethods.captureScreenShot(driver);

	}

	public static void selectCheckInDate() throws ParseException, InterruptedException {
		String checkInDate = "01/08/2021";
		ReusableMethods.selectDate(driver, checkInDate);
	}

	public static void selectCheckOutDate() throws ParseException, InterruptedException {
		String checkInDate = "05/08/2021";
		ReusableMethods.selectDate(driver, checkInDate);
	}

	public static void showGuestCount()  {
		driver.findElement(guest).click();
		List<String> adultGuetsList = new ArrayList<String>();
		// wait for the list to become visible
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(adultGuest));
		
		driver.findElements(adultGuest).forEach(element -> adultGuetsList.add(element.getAttribute("data-cy")));
		ReusableMethods.captureScreenShot(driver);
		System.out.println(adultGuetsList);
	}
}
