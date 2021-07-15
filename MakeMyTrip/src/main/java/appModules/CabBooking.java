package appModules;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
			List<WebElement> li = CabBookingPriceDetailsPage.getCarNames();
			List<WebElement> li1 = CabBookingPriceDetailsPage.getCarPrices();
			 
			List<String> list1=new ArrayList<String>();
			List<String> list2=new ArrayList<String>();
		    list1.add("CAB NAME");
		    list2.add("PRICE");
		    
			
			
			for (int i = 0; i < li.size(); i++) {
                        list1.add(li.get(i).getText());
                        list2.add(li1.get(i).getText().substring(1));
                        
			   	System.out.println(li.get(i).getText() + " -> Rs." + li1.get(i).getText().substring(1));
			}
			
			
			try {
				ExcelUtils.writeIntoExcel(list1, list2,"Sheet2");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	public static boolean cabElement() {
		 WebElement icon = LandingPage.cabLink();
		 boolean check = false;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if(icon.isDisplayed() && icon.isEnabled()) {
				check=true;
		}
		return check;
	 }

	public static boolean validInputsCheck() {
		try {
			LandingPage.clickCabLink();
			CabBookingPage.selectOneWay();
			CabBookingPage.fillFromCity();
			CabBookingPage.fillToCity();
			CabBookingPage.fillDepartureDate();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public static String filtersCheck() throws InterruptedException {
		CabBookingPage.clickSearch();
		Thread.sleep(5000);
		CabBookingPriceDetailsPage.clickSUV();
		return CabBookingPriceDetailsPage.textCheckSuv();
	}
	
	public static List<WebElement> priceDisplayCheck() throws InterruptedException {
		Thread.sleep(5000);
		List<WebElement> li = CabBookingPriceDetailsPage.getCarNames();
		List<WebElement> li1 = CabBookingPriceDetailsPage.getCarPrices();
		for (int i = 0; i < li.size(); i++) {

			System.out.println(li.get(i).getText() + " -> Rs." + li1.get(i).getText().substring(1));
		}
		return li1;
	}
}
