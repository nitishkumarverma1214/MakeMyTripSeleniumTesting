package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import appModules.HotelBooking;
import utilities.DriverSetup;

public class HotelBookingTest extends BaseTest {
	static String configFile = "src//test//resources//config.properties";

	/****************** browser setup and navigating to the url *******************/
	@BeforeTest(groups = { "smoke", "regression" })
	public void setUp() {
		try (FileInputStream fis = new FileInputStream(configFile);) {
			Properties prop = new Properties();
			prop.load(fis);
			DriverSetup.Initiate(prop.getProperty("browserName"));
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	/************** verifying the page title ****************/
	@Test(groups = "smoke")
	public void titleTest() {
		String title = HotelBooking.websiteCheck();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals("MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday", title);
	}

	/********* hotel icon is displayed and clickable *********/
	@Test(priority = 1, groups = "smoke")
	public void hotelIconTest() {
		boolean t = HotelBooking.hotelElement();
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(t);
	}

	/************** verifying the non mandatory fields ***************/
	@Test(priority = 3, groups = "regression")
	public void nonMandatoryFieldTest() {
		boolean t = HotelBooking.nonMandatoryFieldCheck();
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(t);
	}

	/************** verifying the input field with valid input ***************/
	@Test(priority = 2, groups = "regression")
	public void validInputTest() {
		boolean t = HotelBooking.validInputsTest();
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(t);
	}

	/***************** closing the browser *****************/
	@AfterTest(groups = { "smoke", "regression" })
	public void tearDown() {
		DriverSetup.Kill();
	}
}
