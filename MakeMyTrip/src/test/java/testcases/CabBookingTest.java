package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import appModules.CabBooking;
import utilities.DriverSetup;

public class CabBookingTest extends BaseTest {

	static String configFile = "src//test//resources//config.properties";

	/****************** browser setup and navigating to the url *******************/
	@BeforeTest(groups = { "smoke", "regression" })
	public void setUp() {
		try (FileInputStream inputStream = new FileInputStream(configFile);) {
			Properties prop = new Properties();
			prop.load(inputStream);
			DriverSetup.Initiate(prop.getProperty("browserName"));
		} catch (IOException io) {
			io.printStackTrace();
		}

	}

	/********* cab icon is displayed and clickable *********/
	@Test(priority = 1, groups = "smoke")
	public void cabsElementTest() {
		boolean choice = CabBooking.cabElement();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(choice);
	}

	/************** verifying the input field with valid input ***************/
	@Test(priority = 2, groups = "regression")
	public void validInputTest() {
		boolean choice = CabBooking.validInputsCheck();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(choice);
	}

	/************* verifying the suv checkbox ***************/
	@Test(priority = 4, groups = "regression")
	public void filterTest() throws InterruptedException {
		String text = CabBooking.filtersCheck();
		System.out.println(text);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals("SUV", text);
	}

	/***************** verifying the prices of the cab *****************/
	@Test(priority = 5, groups = "regression")
	public void priceShowTest() throws InterruptedException {
		List<WebElement> priceList = CabBooking.priceDisplayCheck();
		System.out.println(priceList.size());
		SoftAssert softAssert = new SoftAssert();
		if (priceList.size() == 0) {
			softAssert.assertTrue(false);
		} else {
			softAssert.assertTrue(true);
		}

	}

	/************** verifying the page title ****************/
	@Test(priority = 3, groups = "regression")
	public void titleTest() {
		String title = CabBooking.cabTitleCheck();
		System.out.println(title);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(title, "Online Cab Booking - Book Outstation Cabs at Lowest Fare @ MakeMyTrip");
		softAssert.assertAll();
	}

	/***************** closing the browser *****************/
	@AfterTest(groups = { "smoke", "regression" })
	public void tearDown() {
		DriverSetup.Kill();
	}

}
