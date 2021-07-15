package pageobjectmodel;

import java.io.IOException;
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
import utilities.ExcelUtils;
import utilities.ReusableMethods;

public class HotelBookingPage extends Baseclass {

	public HotelBookingPage(WebDriver driver, WebElement element) {
		super(driver, element);
	}
	static List<String> li=ExcelUtils.readExcel("Hotel");
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
		driver.findElement(hotelInput).sendKeys(li.get(0));
		
		// wait for the input
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.textToBePresentInElementValue(hotelInput, li.get(0)));
		driver.findElement(hotelInput).sendKeys(Keys.DOWN, Keys.RETURN);
		ReusableMethods.captureScreenShot(driver);

	}

	public static void selectCheckInDate() throws ParseException, InterruptedException {
		String checkInDate = li.get(1).substring(1,li.get(1).length()-1);
		ReusableMethods.selectDate(driver, checkInDate);
	}

	public static void selectCheckOutDate() throws ParseException, InterruptedException {
		String checkInDate = li.get(2).substring(1,li.get(2).length()-1);
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
		try {
			ExcelUtils.writeIntoExcel(adultGuetsList, new ArrayList<String>(), "Sheet1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
