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
	
	@Test(priority=2)
	public void validInputTest() {
		boolean choice = CabBooking.validInputsCheck();
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(choice);
	}
	
	@Test(priority=3)
	public void filterTest() throws InterruptedException {
		String text = CabBooking.filtersCheck();
		System.out.println(text);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals("SUV",text);
	}
	
	@Test(priority=4)
	public void priceShowTest() throws InterruptedException {
		List<WebElement> priceList = CabBooking.priceDisplayCheck();
		System.out.println(priceList.size());
		SoftAssert sa = new SoftAssert();
		if(priceList.size()==0) {
			sa.assertTrue(false);
		}
		else {
			sa.assertTrue(true);
		}
		
	}

/*	
	@Test
	public void buyGiftCard() throws InterruptedException {
		CabBooking.execution();
	}
*/	
	@AfterTest
	public void tearDown() {
		DriverSetup.Kill();
	}

}
