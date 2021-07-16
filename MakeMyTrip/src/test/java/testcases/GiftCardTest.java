package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import appModules.GiftCards;
import pageobjectmodel.GiftCardsDetailsPage;
import utilities.Baseclass;
import utilities.DriverSetup;

public class GiftCardTest{

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
	public void giftCardTextTest() throws InterruptedException {
		boolean choice = GiftCards.giftCardElement();
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(choice);
	}
	
	@DataProvider(name = "mobileNumber")
	public Object[][] invalidMobileNumber(){
		return new Object[][] {{"78329"}};
	}
	@DataProvider(name = "name")
	public Object[][] invalidName(){
		return new Object[][] {{""}};
	}
	@DataProvider(name = "email")
	public Object[][] invalidEmail(){
		return new Object[][] {{"hi.com"}};
	}
	
	@Test(dataProvider = "mobileNumber",priority =3)
	public void invalidSenderMobileNumberTest(String mobileNumber) throws InterruptedException {
		GiftCards.getMeDetailPage();
		GiftCardsDetailsPage.senderMobileTextBox().sendKeys(mobileNumber);
		GiftCardsDetailsPage.clickBuyNow();
		String errorText = GiftCardsDetailsPage.printSenderMobileErrorMessage();
		boolean answer;
		if(errorText.isEmpty() ) {
			answer = false;
		}
		else {
			answer = true;
		}
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(answer);
	}
	
	@Test(dataProvider = "mobileNumber",priority =4)
	public void invalidRecipientMobileNumberTest(String mobileNumber) throws InterruptedException {
	
		GiftCardsDetailsPage.recipientMobileTextBox().sendKeys(mobileNumber);
		GiftCardsDetailsPage.clickBuyNow();
		String errorText = GiftCardsDetailsPage.printRecipientMobileErrorMessage();
		boolean answer;
		if(errorText.isEmpty()) {
			answer = false;
		}
		else {
			answer = true;
		}
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(answer);
	}
	
	@Test(dataProvider = "email",priority=5)
	public void invalidSenderEmailTest(String email) throws InterruptedException {
		GiftCardsDetailsPage.senderEmailBox().sendKeys(email);		
		GiftCardsDetailsPage.clickBuyNow();
		String errorText = GiftCardsDetailsPage.printSenderMailErrorMessage();
		boolean answer;
		if(errorText.isEmpty()) {
			answer = false;
		}
		else {
			answer = true;
		}
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(answer);
	}
	
	@Test(dataProvider = "email",priority=6)
	public void invalidRecipientEmailTest(String email) throws InterruptedException {
		
		GiftCardsDetailsPage.recipientEmailBox().sendKeys(email);
		GiftCardsDetailsPage.clickBuyNow();
		String errorText = GiftCardsDetailsPage.printRecipientMailErrorMessage() ;
		boolean answer;
		if(errorText.isEmpty()) {
			answer = false;
		}
		else {
			answer = true;
		}
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(answer);
	}
	
	@Test(dataProvider = "name",priority=7)
	public void invalidSenderName(String name) throws InterruptedException {
		GiftCardsDetailsPage.senderNameBox().sendKeys(name);
		GiftCardsDetailsPage.clickBuyNow();
		String errorText = GiftCardsDetailsPage.printSenderMailErrorMessage();
		boolean answer;
		if(errorText.isEmpty() ) {
			answer = false;
		}
		else {
			answer = true;
		}
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(answer);
	}
	
	@Test(dataProvider = "name",priority=8)
	public void invalidRecipientName(String name) throws InterruptedException {

		GiftCardsDetailsPage.recipientEmailBox().sendKeys(name);
		GiftCardsDetailsPage.clickBuyNow();
		String errorText = GiftCardsDetailsPage.printRecipientMailErrorMessage() ;

		boolean answer;
		if(errorText.isEmpty()) {
			answer = false;
		}
		else {
			answer = true;
		}
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(answer);
	}
	
	
	@AfterTest
	public void tearDown() {
		DriverSetup.Kill();
	}

}
