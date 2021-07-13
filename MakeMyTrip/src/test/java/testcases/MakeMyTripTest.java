package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import appModules.CabBooking;
import appModules.GiftCards;
import appModules.HotelBooking;
import utilities.DriverSetup;

public class MakeMyTripTest {
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
	public void bookOutStationCab() {
		CabBooking.execution();
	}

	@Test
	public void buyGiftCard() throws InterruptedException {
		GiftCards.execution();
	}

	@Test
	public void bookHotel() {
		HotelBooking.execution();
	}

	@AfterTest
	public void tearDown() {
		DriverSetup.Kill();
	}
}
