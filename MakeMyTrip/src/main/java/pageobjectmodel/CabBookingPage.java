package pageobjectmodel;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Baseclass;
import utilities.ExcelUtils;
import utilities.ReusableMethods;

public class CabBookingPage extends Baseclass {

	public CabBookingPage(WebDriver driver, WebElement element) {
		super(driver, element);
	}
	static List<String> li=ExcelUtils.readExcel("CAB");
	
	static By oneWayLink = By.xpath("//li[@data-cy='outstationOneWay']");
	static By fromCityLink = By.cssSelector("#fromCity");
	static By fromCityInput = By.xpath("//input[contains(@placeholder,'From')]");
	// static By toCityLink =By.cssSelector("#toCity");
	static By toCityInput = By.xpath("//input[contains(@placeholder,'To')]");
	static By searchButton = By.xpath("//a[contains(text(),'Search')]");
	

	public static void selectOneWay() {
		driver.findElement(oneWayLink).click();
		ReusableMethods.captureScreenShot(driver);
	}

	public static void fillFromCity() throws InterruptedException {
		driver.findElement(fromCityLink).click();
		driver.findElement(fromCityInput).sendKeys(li.get(0));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElementValue(fromCityInput, li.get(0)));
		Thread.sleep(3000);
		driver.findElement(fromCityInput).sendKeys(Keys.DOWN, Keys.RETURN);
		ReusableMethods.captureScreenShot(driver);
	}

	public static void fillToCity() throws InterruptedException {
//		driver.findElement(toCityLink).click();
		driver.findElement(toCityInput).sendKeys(li.get(1));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElementValue(toCityInput, li.get(1)));
		Thread.sleep(1000);
		driver.findElement(toCityInput).sendKeys(Keys.DOWN, Keys.RETURN);
		ReusableMethods.captureScreenShot(driver);
	}

	public static void fillDepartureDate() {
		try {
			ReusableMethods.selectDate(driver,li.get(2).substring(1,li.get(2).length()-1));
			ReusableMethods.captureScreenShot(driver);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void fillTime(){
		try {
			Thread.sleep(1000);
			driver.findElement(getResolvedTime(li.get(3))).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static By getResolvedTime(String time) {
		Map<String, Integer> timesheet = new HashMap<>();
		timesheet.put("12:00 AM",1);
		timesheet.put("12:30 AM",2);
		timesheet.put("01:00 AM",3);
		timesheet.put("01:30 AM",4);
		timesheet.put("02:00 AM",5);
		timesheet.put("02:30 AM",6);
		timesheet.put("03:00 AM",7);
		timesheet.put("03:30 AM",8);
		timesheet.put("04:00 AM",9);
		timesheet.put("04:30 AM",10);
		timesheet.put("05:00 AM",11);
		timesheet.put("05:30 AM",12);
		timesheet.put("06:00 AM",13);
		timesheet.put("06:30 AM",14);
		timesheet.put("07:00 AM",15);
		timesheet.put("07:30 AM",16);
		timesheet.put("08:00 AM",17);
		timesheet.put("08:30 AM",18);
		timesheet.put("09:00 AM",19);
		timesheet.put("09:30 AM",20);
		timesheet.put("10:00 AM",21);
		timesheet.put("10:30 AM",22);
		timesheet.put("11:00 AM",23);
		timesheet.put("11:30 AM",24);
		timesheet.put("12:00 PM",25);
		timesheet.put("12:30 PM",26);
		timesheet.put("01:00 PM",27);
		timesheet.put("01:30 PM",28);
		timesheet.put("02:00 PM",29);
		timesheet.put("02:30 PM",30);
		timesheet.put("03:00 PM",31);
		timesheet.put("03:30 PM",32);
		timesheet.put("04:00 PM",33);
		timesheet.put("04:30 PM",34);
		timesheet.put("05:00 PM",35);
		timesheet.put("05:30 PM",36);
		timesheet.put("06:00 PM",37);
		timesheet.put("06:30 PM",38);
		timesheet.put("07:00 PM",39);
		timesheet.put("07:30 PM",40);
		timesheet.put("08:00 PM",41);
		timesheet.put("08:30 PM",42);
		timesheet.put("09:00 PM",43);
		timesheet.put("09:30 PM",44);
		timesheet.put("10:00 PM",45);
		timesheet.put("10:30 PM",46);
		timesheet.put("11:00 PM",47);
		timesheet.put("11:30 PM",48);
		By by = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[5]/ul[1]/li["+String.valueOf(timesheet.get(time.toUpperCase(Locale.ROOT)))+"]");
		return by;
	}

	
	public static void clickSearch() {
		driver.findElement(searchButton).click();
		ReusableMethods.captureScreenShot(driver);
	}

	
}