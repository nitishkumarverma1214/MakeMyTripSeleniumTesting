package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import appModules.CabBooking;
import appModules.GiftCards;
import utilities.DriverSetup;

public class CabBookingTest {

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

	@Test(priority=1)
	public void cabsElementTest() {
		boolean choice =CabBooking.cabElement();
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(choice);
	}

	@AfterTest
	public void tearDown() {
		DriverSetup.Kill();
	}

}
