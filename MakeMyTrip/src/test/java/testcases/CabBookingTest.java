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

	@BeforeTest(groups= {"smoke","regression"})
	public void setUp() {
		try (FileInputStream fis = new FileInputStream(configFile);) {
			Properties prop = new Properties();
			prop.load(fis);
			DriverSetup.Initiate(prop.getProperty("browserName"));
		} catch (IOException io) {
			io.printStackTrace();
		}

	}

	@Test(priority = 1, groups = "smoke")
	public void cabsElementTest() {
		boolean choice = CabBooking.cabElement();
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(choice);
	}
	@Test(priority = 2,groups="regression")
	public void validInputTest() {
		boolean choice = CabBooking.validInputsCheck();
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(choice);
	}

	@Test(priority = 4,groups="regression")
	public void filterTest() throws InterruptedException {
		String text = CabBooking.filtersCheck();
		System.out.println(text);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals("SUV", text);
	}

	@Test(priority = 5,groups="regression")
	public void priceShowTest() throws InterruptedException {
		List<WebElement> priceList = CabBooking.priceDisplayCheck();
		System.out.println(priceList.size());
		SoftAssert sa = new SoftAssert();
		if (priceList.size() == 0) {
			sa.assertTrue(false);
		} else {
			sa.assertTrue(true);
		}

	}

	@Test(priority = 3,groups="regression")
	public void titleTest() {
		String title = CabBooking.cabTitleCheck();
		System.out.println(title);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(title, "Online Cab Booking - Book Outstation Cabs at Lowest Fare @ MakeMyTrip");
		sa.assertAll();
	}

	@AfterTest(groups= {"smoke","regression"})
	public void tearDown() {
		DriverSetup.Kill();
	}

}
