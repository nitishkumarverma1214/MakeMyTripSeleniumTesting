package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import appModules.GiftCards;
import utilities.DriverSetup;

public class GiftCardTest {

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
	public void moremenuElementTest() {
		boolean choice = GiftCards.moremenuElement();
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(choice);
	}
	
	@Test(priority=2)
	public void giftCardTextTest() {
		boolean choice = GiftCards.giftCardElement();
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(choice);
	}
	/*
	@Test
	public void buyGiftCard() throws InterruptedException {
		GiftCards.execution();
	}
	*/
	@AfterTest
	public void tearDown() {
		DriverSetup.Kill();
	}

}
