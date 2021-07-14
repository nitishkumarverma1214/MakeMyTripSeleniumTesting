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

public class HotelBookingTest {
static String configFile = "src//test//resources//config.properties";
	
	@BeforeTest
	public void setUp() {
		try (FileInputStream fis = new FileInputStream(configFile);) {
			Properties prop = new Properties();
			prop.load(fis);
			DriverSetup.Initiate(prop.getProperty("browserName"));
		} catch (IOException io) {
			io.printStackTrace();
		}
	}
	
	@Test
	public void titleTest() {
		String title = HotelBooking.websiteCheck();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals("MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday",title);
	}
	
	@Test(priority=1)
	public void hotelIconTest() {
		boolean t = HotelBooking.hotelElement();
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(t);
	}
	
	@Test(priority=3)
	public void nonMandatoryFieldTest() {
		boolean t = HotelBooking.nonMandatoryFieldCheck();
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(t);
	}
	
	@Test(priority=2)
	public void validInputTest() {
		boolean t = HotelBooking.validInputsTest();
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(t);
	}
	/*
	@org.testng.annotations.Test
	public void bookHotel() {
		HotelBooking.execution();
	}
	*/
	@AfterTest
	public void tearDown() {
		DriverSetup.Kill();
	}
}
